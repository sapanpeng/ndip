package com.tenghong.ndip.service.his.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenghong.ndip.mapper.diet.DietElementMapper;
import com.tenghong.ndip.mapper.his.HisOmsDetailsMapper;
import com.tenghong.ndip.mapper.sys.SysOvenSchedualMapper;
import com.tenghong.ndip.model.his.HisOmsDetails;
import com.tenghong.ndip.model.sys.SysOvenSchedual;
import com.tenghong.ndip.service.his.OmsDetailsService;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:35 2018/6/24
 */
@Service
public class OmsDetailsServiceImpl implements OmsDetailsService {

    @Autowired
    private HisOmsDetailsMapper omsDetailsMapper;

    @Autowired
    private SysOvenSchedualMapper sysOvenSchedualMapper;

    @Autowired
    private DietElementMapper dietElementMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public void save(HisOmsDetails details) {
        omsDetailsMapper.insertSelective(details);
    }

    @Override
    public List<HisOmsDetails> getList(String patientId,String date,Integer mealId) {
        List<HisOmsDetails> list = omsDetailsMapper.getList(1,patientId,date,mealId);
//        List<HisOmsDetails> list2 = omsDetailsMapper.getList(2,patientId,date,mealId);
//        for (HisOmsDetails item : list2){
//            list.add(item);
//        }
        for(HisOmsDetails details : list){
            SysOvenSchedual schedual = sysOvenSchedualMapper.selectByKey(details.getMealId().toString());
            details.setHour(schedual.getExpHour());
            details.setMinute(schedual.getExpMin());
            details.setExpTime(schedual.getExpTime());
            details.setElement(dietElementMapper.selectByCondition(details.getGoalId(),details.getGoalType()));
        }
        return list;
    }

    @Override
    public HisOmsDetails getInfo(Integer id) {
        return omsDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Integer> getInfoList(Integer omsId) {
        String sql = "select oven_id from his_oms_details where oms_id = #{omsId}";
        return sqlMapper.selectList(sql,omsId,int.class);
    }

    @Override
    public void delete(Integer id) {
        omsDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(HisOmsDetails details) {
        omsDetailsMapper.updateByPrimaryKeySelective(details);
    }

	@Override
	public void updateBy(Integer omsId, Integer userId, Date time) {
		omsDetailsMapper.updateBy(omsId, userId, time);
	}

	@Override
	public void getOmsDetail(PageInfo pageInfo) {
		pageInfo.setRows(omsDetailsMapper.findOmsDetail(pageInfo));
        pageInfo.setRecords(omsDetailsMapper.findOmsDetailCount(pageInfo));
		
	}
}

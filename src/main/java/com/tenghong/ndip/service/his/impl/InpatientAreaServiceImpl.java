package com.tenghong.ndip.service.his.impl;

import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.mapper.his.HisInpatientAreaMapper;
import com.tenghong.ndip.model.his.HisInpatientArea;
import com.tenghong.ndip.model.vo.WardIndexVo;
import com.tenghong.ndip.service.his.InpatientAreaService;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 0:15 2018/6/8
 */
@Service
public class InpatientAreaServiceImpl implements InpatientAreaService{

    @Autowired
    private HisInpatientAreaMapper hisInpatientAreaMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public void getDataGrip(PageInfo pageInfo, String path) {
        List<HisInpatientArea> list = hisInpatientAreaMapper.findPageCondition(pageInfo);
        for (HisInpatientArea area : list){
            area.setWardPicVo(NdipUtils.ndipInstance().getImageUrl(area.getWardPic(),path));
            String sql = "select count(1) from his_relation where ward_id = #{wardId}";
            Integer flagNum = sqlMapper.selectOne(sql,area.getId(),int.class);
            if (flagNum == 0){
                area.setFlag(0);
            }else {
                area.setFlag(1);
            }
        }
        pageInfo.setRows(list);
        pageInfo.setRecords(hisInpatientAreaMapper.findPageCount(pageInfo));
    }

    @Override
    public HisInpatientArea getInfo(Integer id,String path) {
        HisInpatientArea area = hisInpatientAreaMapper.selectByPrimaryKey(id);
        area.setWardPicVo(NdipUtils.ndipInstance().getImageUrl(area.getWardPic(),path));
        return area;
    }

    @Override
    public void update(HisInpatientArea area) {
        hisInpatientAreaMapper.updateByPrimaryKeySelective(area);
    }

    @Override
    @Transactional
    public void save(HisInpatientArea area) {
        hisInpatientAreaMapper.insertSelective(area);
    }

    @Override
    public HisInpatientArea select(Integer id) {
        return hisInpatientAreaMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<HisInpatientArea> getDataGrip(List<Integer> list, String path,Integer userId) {
        List<HisInpatientArea> retList = hisInpatientAreaMapper.findDataByIdList(list,userId);
        for (HisInpatientArea area : retList){
            area.setWardPicVo(NdipUtils.ndipInstance().getImageUrl(area.getWardPic(),path));
        }
        return  retList;
    }

    @Override
    public HisInpatientArea selectByCode(String code) {
        return hisInpatientAreaMapper.selectByCode(code);
    }

    @Override
    public List<WardIndexVo> getTurnover(Integer cafeteriaId) {
        List<WardIndexVo> list = hisInpatientAreaMapper.findTurnover();
        for (WardIndexVo vo:list){
        	WardIndexVo wardIndexVo = hisInpatientAreaMapper.findWardTurnover(cafeteriaId, vo.getWardId());
            vo.setValue(wardIndexVo.getValue());
        }
        return list;
    }
}

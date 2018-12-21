package com.tenghong.ndip.service.his.impl;

import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.mapper.his.HisCafeteriaMapper;
import com.tenghong.ndip.model.dto.CafeteriaIndexDto;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.model.vo.SelectVo;
import com.tenghong.ndip.service.his.CafeteriaService;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 12:32 2018/6/7
 */
@Service
public class CafeteriaServiceImpl implements CafeteriaService{

    @Autowired
    private HisCafeteriaMapper hisCafeteriaMapper;

    @Autowired
    private SqlMapper sqlMapper;



    @Override
    public void getDataGrip(PageInfo pageInfo,String path) {
        List<HisCafeteria> list = hisCafeteriaMapper.findPageCondition(pageInfo);
        for (HisCafeteria cafeteria : list){
            cafeteria.setCafeteriaPicVo(NdipUtils.ndipInstance().getImageUrl(cafeteria.getCafeteriaPic(),path));
        }
        pageInfo.setRows(list);
        pageInfo.setRecords(hisCafeteriaMapper.findPageCount(pageInfo));
    }

    @Override
    public HisCafeteria getInfo(Integer cafeteriaId,String path) {
        HisCafeteria cafeteria = hisCafeteriaMapper.selectByPrimaryKey(cafeteriaId);
        cafeteria.setCafeteriaPicVo(NdipUtils.ndipInstance().getImageUrl(cafeteria.getCafeteriaPic(),path));
        return cafeteria;
    }

    @Override
    public void update(HisCafeteria cafeteria) {
        hisCafeteriaMapper.updateByPrimaryKeySelective(cafeteria);
    }

    @Override
    public HisCafeteria select(Integer cafeteriaId) {
        return hisCafeteriaMapper.selectByPrimaryKey(cafeteriaId);
    }

    @Override
    public void save(HisCafeteria cafeteria) {
         hisCafeteriaMapper.insertSelective(cafeteria);
    }

    @Override
    public List<SelectVo> selectByToken(String token) {
        List<SelectVo> list = new ArrayList<>();
        String sql = "select cafeteria_id from sys_user where user_token = #{userToken}";
        String ids = sqlMapper.selectOne(sql,token,String.class);
        List<Integer> idList = NdipUtils.ndipInstance().getIdList(ids);
        if (ids != null) {
            for (Integer param : idList) {
                SelectVo vo = new SelectVo();
                sql = "select cafeteria_name  from his_cafeteria where id = #{id} and status = 1";
                String key = sqlMapper.selectOne(sql,param,String.class);
                if (key != null && !key.equals("")){
                    vo.setKey(key);
                    vo.setValue(param.toString());
                    list.add(vo);
                }
            }
        }
        return list;
    }

    @Override
    public List<HisCafeteria> getDataGrip(List<Integer> list,String path) {
        List<HisCafeteria> retList = hisCafeteriaMapper.findDataByIdList(list);
        for (HisCafeteria cafeteria : retList){
            cafeteria.setCafeteriaPicVo(NdipUtils.ndipInstance().getImageUrl(cafeteria.getCafeteriaPic(),path));
        }
        return retList;
    }

    @Override
    public List<CafeteriaIndexDto> getTurnover() {
        List<CafeteriaIndexDto> list = hisCafeteriaMapper.findTurnover();
        for (CafeteriaIndexDto dto : list){
            String sql = "select IFNULL(sum(a.current_price),0) from his_oms_details a,his_oms b  where a.oms_id=b.id and b.cafeteria_id = #{cafeteriaId} and a.oms_status = 1"
            		+ " and DATE_FORMAT(b.dining_time,'%Y-%m-%d') between DATE_FORMAT(date_add(curdate(), interval - day(curdate()) + 1 day),'%Y-%m-%d') and DATE_FORMAT(curdate(),'%Y-%m-%d')";
            dto.setValue(sqlMapper.selectOne(sql,dto.getCafeteriaId(),double.class));
        }
        return list;
    }

}

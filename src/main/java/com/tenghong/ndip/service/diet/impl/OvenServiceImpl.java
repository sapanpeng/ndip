package com.tenghong.ndip.service.diet.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.mapper.diet.DietMenuMapper;
import com.tenghong.ndip.mapper.diet.DietOvenMapper;
import com.tenghong.ndip.mapper.diet.DietOvenTypeMapper;
import com.tenghong.ndip.mapper.his.HisOmsMapper;
import com.tenghong.ndip.model.diet.DietMenu;
import com.tenghong.ndip.model.diet.DietOven;
import com.tenghong.ndip.model.diet.DietOvenType;
import com.tenghong.ndip.model.vo.OvenIndexVo;
import com.tenghong.ndip.model.vo.OvenTreeVo;
import com.tenghong.ndip.service.diet.OvenService;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 17:05 2018/6/7
 */
@Service
public class OvenServiceImpl implements OvenService {

    @Autowired
    private DietOvenTypeMapper ovenTypeMapper;

    @Autowired
    private DietOvenMapper ovenMapper;

    @Autowired
    private DietMenuMapper menuMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Autowired
    private HisOmsMapper omsMapper;

    @Override
    public void getTypeDataGrip(PageInfo pageInfo,String path) {
        List<DietOvenType> list = ovenTypeMapper.findPageCondition(pageInfo);
        for (DietOvenType type : list){
            type.setOvenTypePicVo(NdipUtils.ndipInstance().getImageUrl(type.getOvenTypePic(),path));
        }
        pageInfo.setRows(list);
        pageInfo.setRecords(ovenTypeMapper.findPageCount(pageInfo));
    }

    @Override
    public void saveType(DietOvenType type) {
        ovenTypeMapper.insertSelective(type);
    }

    @Override
    public DietOvenType getInfoType(Integer id,String path) {
        DietOvenType type = ovenTypeMapper.selectByPrimaryKey(id);
        type.setOvenTypePicVo(NdipUtils.ndipInstance().getImageUrl(type.getOvenTypePic(),path));
        return type;
    }

    @Override
    public void updateType(DietOvenType type) {
        ovenTypeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public void getDataGrip(PageInfo pageInfo) {
        pageInfo.setRows(ovenMapper.findPageCondition(pageInfo));
        pageInfo.setRecords(ovenMapper.findPageCount(pageInfo));
    }

    @Override
    public void save(DietOven oven) {
        ovenMapper.insertSelective(oven);
    }

    @Override
    public DietOven getInfo(Integer id) {
        return ovenMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(DietOven oven) {
        ovenMapper.updateByPrimaryKeySelective(oven);
    }

    @Override
    public List<OvenTreeVo> getTree(Integer id) {
        String sql = "select id as typeId,oven_type_name as name from diet_oven_type where cafeteria_id = #{id}";
        List<OvenTreeVo> list = sqlMapper.selectList(sql,id,OvenTreeVo.class);
        for (OvenTreeVo vo : list){
            vo.setOven(ovenMapper.selectByTypeId(vo.getTypeId()));
        }
        return list;
    }

    @Override
    public List<DietOvenType> getTypeDataGrip(List<Integer> list, String path) {
        List<DietOvenType> retList = ovenTypeMapper.findDataByIdList(list);
        for (DietOvenType type : retList){
            type.setOvenTypePicVo(NdipUtils.ndipInstance().getImageUrl(type.getOvenTypePic(),path));
        }
        return retList;
    }

    @Override
    public List<DietOven> getDataGrip(List<Integer> list) {
        return ovenMapper.findDataByIdList(list);
    }

    @Override
    public DietOven getInfoByMenuId(Integer id) {
        DietMenu menu = menuMapper.selectByPrimaryKey(id);
        return ovenMapper.selectByPrimaryKey(menu.getOvenId());
    }

    @Override
    public List<OvenIndexVo> getDailyOrderVal(Integer cafeteriaId) {
        List<OvenIndexVo> list = ovenMapper.findOvenIndexVo(cafeteriaId);
        for (OvenIndexVo vo : list){
            OvenIndexVo voDb = omsMapper.findDailyOrderVal(vo.getOvenId(), cafeteriaId);
            vo.setBookFees(null == voDb ? 0.00 : voDb.getBookFees());
            vo.setBookNum(null == voDb ? 0 : voDb.getBookNum());
        }
        return list;
    }
}

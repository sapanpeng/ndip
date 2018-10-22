package com.tenghong.ndip.service.his.impl;

import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.mapper.his.HisRelationMapper;
import com.tenghong.ndip.mapper.sys.SysUserMapper;
import com.tenghong.ndip.model.his.HisRelation;
import com.tenghong.ndip.model.sys.SysUser;
import com.tenghong.ndip.service.his.AreaCafeteriaService;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 1:45 2018/6/8
 */
@Service
public class AreaCafeteriaServiceImpl implements AreaCafeteriaService {

    @Autowired
    private HisRelationMapper hisRelationMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public void save(HisRelation relation) {
        hisRelationMapper.insertSelective(relation);
    }

    @Override
    public void getDataGrip(PageInfo pageInfo) {
        List<HisRelation> list = hisRelationMapper.findPageCondition(pageInfo);
        for (HisRelation item : list){
            String userString = "";
            String nameString = "";
            for (Integer i : NdipUtils.ndipInstance().getIdList(item.getUserId())){
                SysUser user = sysUserMapper.selectByPrimaryKey(i);
                if(user!=null){
                    userString += user.getUserName()+",";
                    nameString += user.getRealName()+",";
                }
            }
            if (NdipUtils.ndipInstance().getIdList(item.getUserId()).size() > 0){
                item.setUserName(userString.substring(0,userString.length()-1));
                item.setRealName(nameString.substring(0,nameString.length()-1));
            }
        }
        pageInfo.setRows(list);
        pageInfo.setRecords(hisRelationMapper.findPageCount(pageInfo));
    }

    @Override
    public HisRelation getInfo(Integer id) {
        return hisRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(HisRelation relation) {
        hisRelationMapper.updateByPrimaryKeySelective(relation);
    }

    @Override
    public List<HisRelation> gelAll(Integer userId) {
        String sql = "select cafeteria_id as cafeteriaId,ward_id as wardId from his_relation where user_id = #{userId}";
        return sqlMapper.selectList(sql,userId,HisRelation.class);
    }

    @Override
    public List<Integer> getCatefeteriaIds(String userName) {
        String sql = "select distinct cafeteria_id from his_relation where user_name like concat(concat('%',#{userName}),'%')";
        return sqlMapper.selectList(sql,userName,int.class);
    }

    @Override
    public List<Integer> getWardIds(Integer userId) {
        String sql = "select distinct ward_id from his_relation where user_id = #{userId}";
        return sqlMapper.selectList(sql,userId,int.class);
    }
}

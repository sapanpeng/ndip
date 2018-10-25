package com.tenghong.ndip.service.sys.impl;

import com.tenghong.ndip.mapper.sys.SysOvenSchedualMapper;
import com.tenghong.ndip.model.sys.SysOvenSchedual;
import com.tenghong.ndip.service.sys.SchedualService;
import com.tenghong.ndip.utils.EhcacheUtil;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 1:29 2018/6/28
 */
@Service
public class SchedualServiceImpl implements SchedualService{

    @Autowired
    private SqlMapper sqlMapper;

    @Autowired
    private SysOvenSchedualMapper ovenSchedualMapper;

    @Override
    public List<Integer> select() {
        String sql = "select `key` from sys_oven_schedual";
        return sqlMapper.selectList(sql,int.class);
    }

    @Override
    public void select(String key) {
        String sql = "select ded_time from sys_oven_schedual where `key` = #{key}";
        EhcacheUtil.getInstance().put("mealTimesCache", key,
                sqlMapper.selectOne(sql,Integer.parseInt(key),String.class));
    }

    @Override
    public void save(SysOvenSchedual sysOvenSchedual) {
        ovenSchedualMapper.insertSelective(sysOvenSchedual);
    }

    @Override
    public SysOvenSchedual selectForItem(String key) {
        return ovenSchedualMapper.selectByKey(key);
    }

    @Override
    public void update(SysOvenSchedual sysOvenSchedual) {
        ovenSchedualMapper.updateByPrimaryKeySelective(sysOvenSchedual);
    }

    @Override
    public void delete(SysOvenSchedual sysOvenSchedual) {
        ovenSchedualMapper.deleteByPrimaryKey(sysOvenSchedual.getId());
    }
}

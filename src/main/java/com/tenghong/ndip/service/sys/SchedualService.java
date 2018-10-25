package com.tenghong.ndip.service.sys;

import com.tenghong.ndip.model.sys.SysOvenSchedual;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 1:28 2018/6/28
 */
public interface SchedualService {

    List<Integer> select();

    void select(String key);

    void save(SysOvenSchedual sysOvenSchedual);

    SysOvenSchedual selectForItem(String key);

    void update(SysOvenSchedual sysOvenSchedual);

    void delete(SysOvenSchedual sysOvenSchedual);
}

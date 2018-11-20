package com.tenghong.ndip.service.his;

import java.util.Date;
import java.util.List;

import com.tenghong.ndip.model.his.HisOmsDetails;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:35 2018/6/24
 */
public interface OmsDetailsService {

    void save(HisOmsDetails details);
    
    //根据病人ID和日期删除订单详情
    void updateBy(Integer omsId, Integer userId, Date time);

    List<HisOmsDetails> getList(String patientId,String date,Integer mealId);

    HisOmsDetails getInfo(Integer id);

    List<Integer> getInfoList(Integer omsId);

    void delete(Integer id);

    void update(HisOmsDetails details);

    //根据订单ID查询订单详情
	void getOmsDetail(PageInfo pageInfo);
}

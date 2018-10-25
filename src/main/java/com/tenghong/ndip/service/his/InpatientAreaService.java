package com.tenghong.ndip.service.his;

import com.tenghong.ndip.model.his.HisInpatientArea;
import com.tenghong.ndip.model.vo.WardIndexVo;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 0:14 2018/6/8
 */
public interface InpatientAreaService {

    //获取病区列表
    void getDataGrip(PageInfo pageInfo,String path);

    //获取病区实例
    HisInpatientArea getInfo(Integer id,String path);

    //修改病区实例(逻辑删除)
    void update(HisInpatientArea area);

    //保存病区实例
    void save(HisInpatientArea area);

    //查询病区实例
    HisInpatientArea select(Integer id);

    List<HisInpatientArea> getDataGrip(List<Integer> list, String path, Integer userId);

    //根据病区code查询实例
    HisInpatientArea selectByCode(String code);

    //查询病区营业额
    List<WardIndexVo> getTurnover();
}

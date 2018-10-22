package com.tenghong.ndip.service.his;

import com.tenghong.ndip.model.dto.CafeteriaIndexDto;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.model.vo.SelectVo;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 12:32 2018/6/7
 */
public interface CafeteriaService {

    //获取食堂列表
    void getDataGrip(PageInfo pageInfo,String path);

    //获取食堂详情
    HisCafeteria getInfo(Integer cafeteriaId,String path);

    //修改食堂实例
    void update(HisCafeteria cafeteria);

    //查询食堂实例
    HisCafeteria select(Integer cafeteriaId);

    //保存食堂实例
    void save(HisCafeteria cafeteria);

    //根据token查询食堂列表
    List<SelectVo> selectByToken(String token);

    //app获取食堂列表
    List<HisCafeteria> getDataGrip(List<Integer> list,String path);

    //查询食堂营业额
    List<CafeteriaIndexDto> getTurnover();

}

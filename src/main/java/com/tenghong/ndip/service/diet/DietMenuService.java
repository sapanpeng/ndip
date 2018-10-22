package com.tenghong.ndip.service.diet;

import com.tenghong.ndip.model.diet.DietMenu;
import com.tenghong.ndip.model.vo.MenuVo;
import com.tenghong.ndip.utils.PageInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 15:32 2018/6/19
 */
public interface DietMenuService {

    //查询菜单
    void getDataGrip(PageInfo pageInfo,Integer page,Integer rows,String menuDate,Integer ovenId,Integer mealTimesId);

    //查询菜单实例
    DietMenu getInfo(Integer id);

    //保存实例
    void save(DietMenu menu);

    //更新实例
    void update(DietMenu menu);

    List<MenuVo> getDataGrip(String ids,String path);

    //复制菜单
    void copy(Integer differDays,Date sourcesStartTime,Date targetStartTime,List<Integer> mealId,List<Integer> ovenId,Integer userId);
}

package com.tenghong.ndip.service.diet.impl;

import com.google.common.collect.Maps;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.mapper.diet.DietElementMapper;
import com.tenghong.ndip.mapper.diet.DietMenuMapper;
import com.tenghong.ndip.mapper.diet.DietRelationMapper;
import com.tenghong.ndip.model.diet.DietElement;
import com.tenghong.ndip.model.diet.DietMenu;
import com.tenghong.ndip.model.diet.DietRelation;
import com.tenghong.ndip.model.vo.MenuVo;
import com.tenghong.ndip.service.diet.DietMenuService;
import com.tenghong.ndip.utils.DateUtil;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 15:33 2018/6/19
 */
@Service
public class DietMenuServiceImpl implements DietMenuService {

    @Autowired
    private DietMenuMapper dietMenuMapper;

    @Autowired
    private DietRelationMapper dietRelationMapper;

    @Autowired
    private DietElementMapper dietElementMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public void getDataGrip(PageInfo pageInfo, Integer page, Integer rows, String menuDate, Integer ovenId, Integer mealTimesId) {
        Map<String,Object> map = Maps.newHashMap();
        String sql = "select distinct relation_id from diet_relation where re_parent_type = 4";
        List<Integer> ids = sqlMapper.selectList(sql,int.class);
        if(ids.size() != 0) {
            pageInfo.setList(ids);
            map.put("menuDate", menuDate);
            map.put("ovenId", ovenId);
            map.put("mealTimesId", mealTimesId);
            map.put("flag", 1);
            pageInfo.setCondition(map);
            List<MenuVo> dishList = dietMenuMapper.findPageConditionNew(pageInfo);
            for (MenuVo item1 : dishList){
                item1.setElement(dietElementMapper.selectByCondition(item1.getElementGoalId(),2));
            }
            map.put("flag", 2);
            pageInfo.setCondition(map);
            List<MenuVo> dishPkgList = dietMenuMapper.findPageConditionNew(pageInfo);
            for (MenuVo item2 : dishPkgList){
                item2.setElement(dietElementMapper.selectByCondition(item2.getElementGoalId(),3));
            }
            for (MenuVo vo : dishPkgList) {
                dishList.add(vo);
            }
            pageInfo.setRows(dishList);
        }
    }

    @Override
    public DietMenu getInfo(Integer id) {
        return dietMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(DietMenu menu) {
        dietMenuMapper.insertSelective(menu);
    }

    @Override
    public void update(DietMenu menu) {
        dietMenuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public List<MenuVo> getDataGrip(String catIds,String path) {
        String sql = "select distinct relation_id from diet_relation relation LEFT JOIN diet_menu menu ON relation.re_parent_id = menu.id where menu.cafeteria_id in (#{catIds}) AND relation.re_parent_type = 4";
        List<Integer> ids = sqlMapper.selectList(sql,catIds,int.class);
        List<MenuVo> dishList = dietMenuMapper.findDataByIdList(ids,1);
        List<MenuVo> dishPkgList = dietMenuMapper.findDataByIdList(ids,2);
        for(MenuVo vo: dishPkgList){
            dishList.add(vo);
        }
        for (MenuVo vo:dishList){
            vo.setIconVo(NdipUtils.ndipInstance().getImageUrl(vo.getIcon(),path));
        }
        return dishList;
    }

    @Override
    @Transactional
    public void copy(Integer differDays,Date sourcesStartTime,Date targetStartTime, List<Integer> mealId, List<Integer> ovenId, Integer userId) {
        for (int i = 0;i <= differDays; i++){
            Date time = DateUtil.getOtherDay(sourcesStartTime,i);
            List<DietMenu> list = dietMenuMapper.getCopyList(ovenId,mealId,time);
            for (DietMenu menu : list){
                DietMenu menuNew = new DietMenu();
                menuNew.setMealId(menu.getMealId());
                menuNew.setOvenId(menu.getOvenId());
                menuNew.setMenuTime(DateUtil.getOtherDay(targetStartTime,i));
                menuNew.setCafeteriaId(menu.getCafeteriaId());
                menuNew.setCreateBy(userId);
                menuNew.setCreateTime(new Date());
                menuNew.setStatus(1);
                dietMenuMapper.insertSelective(menuNew);

                //查询关系
                List<DietRelation> relaList = dietRelationMapper.selectByParentKey(menu.getId(),4);
                for (DietRelation item :relaList){
                    DietRelation relation = new DietRelation();
                    relation.setReParentType(item.getReParentType());
                    relation.setReParentId(menuNew.getId());
                    relation.setReGoalId(item.getReGoalId());
                    relation.setReGoalType(item.getReGoalType());
                    relation.setReGoalNum(item.getReGoalNum());
                    relation.setReGoalName(item.getReGoalName());
                    relation.setReGoalTipsOne(item.getReGoalTipsOne());
                    relation.setReGoalTipsTwo(item.getReGoalTipsTwo());
                    //保存关系
                    dietRelationMapper.insertSelective(relation);
                    //保存营养素
                    DietElement element = item.getElement();
                    element.setElementId(null);
                    element.setGoalId(menuNew.getId());
                    dietElementMapper.insertSelective(element);
                }
            }
        }
    }


}

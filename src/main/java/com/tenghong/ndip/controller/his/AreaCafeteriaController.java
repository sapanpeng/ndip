package com.tenghong.ndip.controller.his;

import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.mapper.sys.SysUserMapper;
import com.tenghong.ndip.model.his.HisInpatientArea;
import com.tenghong.ndip.model.his.HisRelation;
import com.tenghong.ndip.model.sys.SysUser;
import com.tenghong.ndip.service.his.AreaCafeteriaService;
import com.tenghong.ndip.service.his.InpatientAreaService;
import com.tenghong.ndip.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 1:43 2018/6/8
 */
@Controller
@RequestMapping("/admin")
public class AreaCafeteriaController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaCafeteriaController.class);

    @Autowired
    private AreaCafeteriaService areaCafeteriaService;
    @Autowired
    private InpatientAreaService inpatientAreaService;
    @Autowired
    private SysUserMapper sysUserMapper;

    @RequestMapping(value = "/relation/saveUser",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("relationId") List<Integer> relationId,
                       @RequestParam("userId") String userId){
        Result result = getResultInstance();
        try{
            List<Integer> userIdInt = NdipUtils.ndipInstance().getIdList(userId);
            String userName = "";
            for (Integer id : userIdInt){
                SysUser user = sysUserMapper.selectByPrimaryKey(id);
                userName += user.getUserName()+",";
            }
            for(Integer item : relationId){
                HisRelation relation = areaCafeteriaService.getInfo(item);
                relation.setUserId(userId);
                relation.setUserName(userName);
                areaCafeteriaService.update(relation);
            }
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }


    @RequestMapping(value = "/relation/saveArea",method = RequestMethod.POST)
    @ResponseBody
    public Result saveCat(@RequestParam("cafeteriaId") Integer cafeteriaId,
                          @RequestParam("wardId") List<Integer> wardId){
        Result result = getResultInstance();
        try{
            for (Integer item : wardId){
                HisRelation relation = new HisRelation();
                HisInpatientArea area = inpatientAreaService.select(item);
                relation.setCafeteriaId(cafeteriaId );
                relation.setWardId(item);
                relation.setWardName(area.getWardName());
                relation.setWardCode(area.getWardCode());
                areaCafeteriaService.save(relation);
            }
            result.setState(1); 
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/relation/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "cafeteriaId", required = false, defaultValue = "") Integer cafeteriaId,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = getQueryMap();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "id", "desc");
            queryMap.put("cafeteriaId",cafeteriaId);
            pageInfo.setCondition(queryMap);
            areaCafeteriaService.getDataGrip(pageInfo);
            result.setData(pageInfo);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/relation/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam("relationId") Integer relationId){
        Result result = getResultInstance();
        try{
            HisRelation relation = areaCafeteriaService.getInfo(relationId);
            relation.setStatus(0);
            areaCafeteriaService.update(relation);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }
}

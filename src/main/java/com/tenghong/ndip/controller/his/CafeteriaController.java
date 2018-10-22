package com.tenghong.ndip.controller.his;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.dto.ImageDto;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.service.his.CafeteriaService;
import com.tenghong.ndip.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 11:50 2018/6/7
 */
@Controller
@RequestMapping("/admin")
public class CafeteriaController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(CafeteriaController.class);

    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;

    @Autowired
    private CafeteriaService cafeteriaService;

    @RequestMapping(value = "/cafeteria/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "sort", "desc");
            cafeteriaService.getDataGrip(pageInfo,fileViewPath);
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

    @RequestMapping(value = "/cafeteria/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result detail(@RequestParam(value = "cafeteriaId")Integer cafeteriaId){
        Result result = getResultInstance();
        try{
            result.setData(cafeteriaService.getInfo(cafeteriaId,fileViewPath));
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/cafeteria/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam(value = "token") String token,
                       @RequestParam(value = "cafeteriaId") Integer cafeteriaId,
                       @RequestParam(value = "cafeteriaCode") String cafeteriaCode,
                       @RequestParam(value = "cafeteriaName") String cafeteriaName,
                       @RequestParam(value = "cafeteriaPic") String cafeteriaPic,
                       @RequestParam(value = "cafeteriaIndex")  Integer cafeteriaIndex){
        Result result = getResultInstance();
        try{
            List<ImageDto> list = JSONArray.parseArray(cafeteriaPic, ImageDto.class);
            HisCafeteria cafeteria = cafeteriaService.select(cafeteriaId);
            cafeteria.setCafeteriaCode(cafeteriaCode);
            cafeteria.setCafeteriaName(cafeteriaName);
            cafeteria.setCafeteriaPic(NdipUtils.ndipInstance().getImageName(list));
            cafeteria.setSort(cafeteriaIndex);
            cafeteria.setUpdateTime(new Date());
            cafeteria.setUpdateBy(getCurrentUser(token).getUserId());
            cafeteriaService.update(cafeteria);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/cafeteria/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam(value = "token") String token,
                       @RequestParam(value = "cafeteriaCode") String cafeteriaCode,
                       @RequestParam(value = "cafeteriaName") String cafeteriaName,
                       @RequestParam(value = "cafeteriaPic") String cafeteriaPic,
                       @RequestParam(value = "cafeteriaIndex")  Integer cafeteriaIndex){
        Result result = getResultInstance();
        try{
            List<ImageDto> list = JSONArray.parseArray(cafeteriaPic, ImageDto.class);
            HisCafeteria cafeteria = new HisCafeteria();
            cafeteria.setCafeteriaCode(cafeteriaCode);
            cafeteria.setCafeteriaName(cafeteriaName);
            cafeteria.setCafeteriaPic(NdipUtils.ndipInstance().getImageName(list));
            cafeteria.setSort(cafeteriaIndex);
            cafeteria.setCreateTime(new Date());
            cafeteria.setCreateBy(getCurrentUser(token).getUserId());
            cafeteriaService.save(cafeteria);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/cafeteria/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam(value = "token") String token,
                       @RequestParam(value = "cafeteriaId") Integer cafeteriaId){
        Result result = getResultInstance();
        try{
            HisCafeteria cafeteria = cafeteriaService.select(cafeteriaId);
            cafeteria.setUpdateTime(new Date());
            cafeteria.setUpdateBy(getCurrentUser(token).getUserId());
            cafeteria.setStatus(0);
            cafeteriaService.update(cafeteria);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/cafeteria/ubac",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam("token") String token){
        Result result = getResultInstance();
        try{
            result.setData(cafeteriaService.selectByToken(token));
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

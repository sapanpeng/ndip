package com.tenghong.ndip.controller.his;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.dto.ImageDto;
import com.tenghong.ndip.model.his.HisInpatientArea;
import com.tenghong.ndip.service.his.InpatientAreaService;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 0:11 2018/6/8
 */
@Controller
@RequestMapping("/admin")
public class InpatientAreaController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InpatientAreaController.class);

    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;

    @Autowired
    private InpatientAreaService inpatientAreaService;

    @RequestMapping(value = "/area/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "sort", "desc");
            inpatientAreaService.getDataGrip(pageInfo,fileViewPath);
            result.setData(pageInfo);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/area/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result detail(@RequestParam("wardId")Integer wardId){
        Result result = getResultInstance();
        try{
            result.setData(inpatientAreaService.getInfo(wardId,fileViewPath));
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/area/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam("token")String token,
                       @RequestParam("wardId")Integer wardId,
                       @RequestParam("wardCode")String wardCode,
                       @RequestParam("wardName")String wardName,
                       @RequestParam("wardPic")String wardPic,
                       @RequestParam("wardIndex")Integer sort,
                       @RequestParam(value = "wardMemo", required = false, defaultValue = "")String memo){
        Result result = getResultInstance();
        try{
        	
        	HisInpatientArea hisInpatientArea = inpatientAreaService.selectByCode(wardCode);
        	if (hisInpatientArea != null && hisInpatientArea.getId() != null && hisInpatientArea.getId().intValue() != 0) {
        		throw new Exception("HisInpatientAreaRepeat");
        	}
        	
            List<ImageDto> list = JSONArray.parseArray(wardPic, ImageDto.class);
            HisInpatientArea area = inpatientAreaService.select(wardId);
            area.setWardCode(wardCode);
            area.setWardName(wardName);
            area.setWardPic(NdipUtils.ndipInstance().getImageName(list));
            area.setSort(sort);
            area.setMemo(memo);
            area.setUpdateBy(getCurrentUser(token).getUserId());
            area.setUpdateTime(new Date());
            inpatientAreaService.update(area);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
        	if ("HisInpatientAreaRepeat".equals(e.getMessage())) {
        		LOGGER.error("Server Exception：{}",e);
        		result.setState(0);
        		result.setMsg("病区编号重复，请确认。");
        	} else {
        		LOGGER.error("Server Exception：{}",e);
        		result.setState(0);
        		result.setMsg("Server Exception");
        	}
        }
        return result;
    }

    @RequestMapping(value = "/area/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam("token")String token,
                       @RequestParam("wardId")Integer wardId){
        Result result = getResultInstance();
        try{
            HisInpatientArea area = inpatientAreaService.select(wardId);
            area.setStatus(0);
            area.setUpdateBy(getCurrentUser(token).getUserId());
            area.setUpdateTime(new Date());
            inpatientAreaService.update(area);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }
}

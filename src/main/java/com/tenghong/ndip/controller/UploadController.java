package com.tenghong.ndip.controller;

import com.tenghong.ndip.controller.sys.ResourcesController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 18:59 2018/6/6
 */
@Controller
@RequestMapping("/admin")
public class UploadController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourcesController.class);


    @Value("#{applicationProperties['image.path.home']}")
    private String fileSavePath;

    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile picture) {
        Result result = getResultInstance();
        Map<String,Object> map = new HashMap<>();

        String pictureName = DateUtil.getAllTime()+UUID.randomUUID().toString().substring(0,4) + ".jpg";
        try {
            picture.transferTo(new File(fileSavePath + pictureName));
            map.put("imageUrl",fileViewPath+pictureName);
            result.setState(1);
            result.setMsg("success");
            result.setData(map);
        } catch (Exception e) {
            result.setMsg("Server Exception");
            LOGGER.error("Server Exception：{}",e);
        }
        return result;
    }

}

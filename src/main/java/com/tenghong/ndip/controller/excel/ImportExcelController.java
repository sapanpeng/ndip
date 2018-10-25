package com.tenghong.ndip.controller.excel;

import com.tenghong.ndip.config.exception.AreaCodeException;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.his.HisInpatientArea;
import com.tenghong.ndip.service.his.InpatientAreaService;
import com.tenghong.ndip.utils.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:03 2018/6/9
 */
@Controller
@RequestMapping("/admin")
public class ImportExcelController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportExcelController.class);

    @Autowired
    private InpatientAreaService inpatientAreaService;

    @RequestMapping(value = "/import/area",method = RequestMethod.POST)
    @ResponseBody
    public Result importAreaData(@RequestParam("upfile") MultipartFile multipartFile,
                                 @RequestParam("token")String token){
        ExcelUtils utils = new ExcelUtils();
        Set<Object> set = new HashSet<>();
        Result result = getResultInstance();
        try{
            List<List<Object>> list = utils.getBankListByExcel(multipartFile.getInputStream(),
                    multipartFile.getOriginalFilename());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get(0) != null  && !dataValid(list.get(i).get(0),set))
                    throw new AreaCodeException();
            }
            for (int i = 0; i < list.size(); i++) {
                HisInpatientArea area = new HisInpatientArea();
                area.setWardCode(list.get(i).get(0) != null ? list.get(i).get(0).toString():"");
                area.setWardName(list.get(i).get(1) != null ? list.get(i).get(1).toString():"");
                area.setSort(1);
                area.setStatus(1);
                area.setCreateBy(getCurrentUser(token).getUserId());
                area.setCreateTime(new Date());
                area.setMemo(list.get(i).get(2) != null ? list.get(i).get(2).toString():"");
                inpatientAreaService.save(area);
            }
            result.setMsg("success");
            result.setState(1);
        }catch (AreaCodeException e){
             result.setMsg("病区code重复");
             result.setState(0);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setMsg("server Exception");
            result.setState(0);
        }
        return result;
    }


}

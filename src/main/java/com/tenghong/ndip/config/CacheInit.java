package com.tenghong.ndip.config;

import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.service.sys.SchedualService;
import com.tenghong.ndip.utils.EhcacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 1:23 2018/6/28
 */
@Component
public class CacheInit {

    @Autowired
    private SchedualService schedualService;

    @PostConstruct
    public void init(){
        List<Integer> keyList = schedualService.select();
        EhcacheUtil.getInstance().put("mealTimesCache","ovenKeyList", keyList);
        if (keyList.size() > 0){
            for (Integer key : keyList){
                schedualService.select(key.toString());
            }
        }
    }


}

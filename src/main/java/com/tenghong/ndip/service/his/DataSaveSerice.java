package com.tenghong.ndip.service.his;

import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.dto.OmsAppDto;
import com.tenghong.ndip.model.his.HisOmsDetails;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 10:40 2018/7/13
 */
public interface DataSaveSerice {

    Result saveAppData(List<OmsAppDto> dtoList,String style);

    Result saveWebData(List<HisOmsDetails> details,Date diningTime,List<String> list,String token,String style);

}

package com.tenghong.ndip.core;

import com.tenghong.ndip.model.dto.ImageDto;
import com.tenghong.ndip.model.sys.SysUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 13:16 2018/6/7
 */
@Component
public class NdipUtils {



    //获得本类实例化对象
    public static NdipUtils ndipInstance(){
        return new NdipUtils();
    }

    //拼接图片访问路径
    public  List<ImageDto> getImageUrl(String imageUrls,String path){
        List<ImageDto> imageList = new ArrayList<>();
        String[] imageUrl;
        if (imageUrls != null && !imageUrls.equals("")){
            imageUrl = imageUrls.split(";");
        }else{
            return imageList;
        }
        for (int i = 0;i < imageUrl.length;i++){
            ImageDto dto = new ImageDto();
            dto.setName(imageUrl[i]);
            dto.setUrl(path+imageUrl[i]);
            imageList.add(dto);
        }
        return imageList;
    }

    //获取图片名称
    public String getImageName(List<ImageDto> list){
        String name = "";
        for (ImageDto dto : list){
            name += dto.getName()+";";
        }
        return name;
    }

    //String ids 转化为 Integer集合
    public List<Integer> getIdList(String ids){
        List<Integer> list = new ArrayList<>();
        if (ids != null && !ids.equals("")){
            String[] param = ids.split(",");
            for (int i = 0; i< param.length; i++){
                list.add(Integer.parseInt(param[i]));
            }
        }
        return list;
    }

    //把集合转化为string
    public String getIds(List<Integer> ids){
        String newIds = "";
        for (Integer item : ids){
            newIds+= item + ",";
        }
        return newIds;
    }

    public List voList(List pojoList, Class clazz){
        List list = new ArrayList(pojoList.size());
        try {
            for (Object source : pojoList){
                Object target = clazz.newInstance();
                BeanUtils.copyProperties(source,target);
                list.add(target);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}

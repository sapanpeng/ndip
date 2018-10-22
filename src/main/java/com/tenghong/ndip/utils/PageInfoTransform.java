package com.tenghong.ndip.utils;

public class PageInfoTransform {

    public static PageInfo transform(com.github.pagehelper.PageInfo source){
        PageInfo result = new PageInfo();
        result.setRows(source.getList());
        result.setTotal((int) source.getTotal());
        result.setNowpage(source.getPageNum());
        result.setPagesize(source.getSize());
        return result;
    }
}

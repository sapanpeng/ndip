package com.tenghong.ndip.utils;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @description：分页实体类 (结合jqgrid)
 * @author：bynow
 * @date：2015年4月23日 上午1:41:46
 */
public class PageInfo implements Serializable{

	private static final long serialVersionUID = -8130141566178040255L;

	private final static int PAGESIZE = 10; //默认显示的记录数 

    @JSONField(serialize = false)
    private int records; // 总记录

    @JSONField(name = "list")
    private List rows; //显示的记录

    @JSONField(name = "pageNo")
    private int nowpage; // 当前页 
    /** 总页数 */
    @JSONField(name = "pageCount")
    private int total;

    @JSONField(name = "title")
    private String title;

    @JSONField(serialize = false)
    private int from;
    @JSONField(serialize = false)
    private int size;
    @JSONField(name = "pageSize")
    private int pagesize; // 每页显示的记录数 
    @JSONField(serialize = false)
    private Map<String, Object> condition = Maps.newHashMap(); //查询条件

    @JSONField(serialize = false)
    private String sort = "seq";// 排序字段
    @JSONField(serialize = false)
    private String order = "asc";// asc，desc mybatis Order 关键字

    @JSONField(serialize = false)
    private List<?> list;// 查询集合
	
    public PageInfo() {
    }

    //构造方法
    public PageInfo(int nowpage, int pagesize) {
        //计算当前页  
        if (nowpage < 0) {
            this.nowpage = 1;
        } else {
            //当前页
            this.nowpage = nowpage;
        }
        //记录每页显示的记录数  
        if (pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else {
            this.pagesize = pagesize;
        }
        //计算开始的记录和结束的记录  
        this.from = (this.nowpage - 1) * this.pagesize;
        this.size = this.pagesize;
    }

    // 构造方法
    public PageInfo(int nowpage, int pagesize, String sort, String order) {
        // 计算当前页  
        if (nowpage < 0) {
            this.nowpage = 1;
        } else {
            // 当前页
            this.nowpage = nowpage;
        }
        // 记录每页显示的记录数  
        if (pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else {
            this.pagesize = pagesize;
        }
        // 计算开始的记录和结束的记录  
        this.from = (this.nowpage - 1) * this.pagesize;
        this.size = this.pagesize;
        // 排序字段，正序还是反序
        this.sort = sort;
        this.order = order;
    }

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
		calcuteTotal(records);
	}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNowpage() {
        return nowpage;
    }

    public void setNowpage(int nowpage) {
        this.nowpage = nowpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
    /**
     * @Title: calcuteTotal 
     * @Description: 计算总页数 
     * @param records  总记录数
     * @return void 
     * @throws
     */
    private void calcuteTotal(int records){
    	int mod = records % pagesize;
    	if(mod == 0){
    		this.total = records / pagesize;
    	}else{
    		this.total = records / pagesize + 1;
    	}
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}

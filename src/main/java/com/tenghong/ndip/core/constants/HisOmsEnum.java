package com.tenghong.ndip.core.constants;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 17:42 2018/6/22
 */
public enum HisOmsEnum {
    WAIT_FOR_PAY(1,"预定(待付款)"),
    PAY(2,"已缴费"),
    REFUND(3,"删除");

    private int type;
    private String description;

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private HisOmsEnum(int type, String description)
    {
        this.type = type;
        this.description = description;
    }

    public static HisOmsEnum getByType(int type)
    {
        for(HisOmsEnum at:HisOmsEnum.values()){
            if(at.type==type){
                return at;
            }
        }
        throw new IllegalArgumentException("Not supported client type:" + type);
    }
}

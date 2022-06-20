package com.Echidnar.Mishop.entity;

import javax.xml.crypto.Data;

public class Category {
    private Integer cid;
    private String cname;
    //分类的启用状态。默认为1,0为未启用
    private Integer state;
    //排序规则
    private Integer order_number;
    private String description;
    private Data create_time;

    public Category(){
    }

    public Category(Integer cid, String cname, Integer state, Integer order_number, String description, Data create_time) {
        this.cid = cid;
        this.cname = cname;
        this.state = state;
        this.order_number = order_number;
        this.description = description;
        this.create_time = create_time;
    }

    public Category(String cname, Integer state, Integer order_number, String description, Data create_time) {
        this.cname = cname;
        this.state = state;
        this.order_number = order_number;
        this.description = description;
        this.create_time = create_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Integer order_number) {
        this.order_number = order_number;
    }

    public Data getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Data create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", state=" + state +
                ", order_number=" + order_number +
                ", description='" + description + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}

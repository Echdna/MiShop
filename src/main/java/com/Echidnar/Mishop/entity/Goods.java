package com.Echidnar.Mishop.entity;

import java.util.Date;

public class Goods {
    private Integer gid;//商品主键
    private Integer cid;//关联商品分类主键的外键
    private String gname;//商品名称
    private String color;//商品颜色private string size;//商品尺寸private Double price;//商品价格
    private String description;//商品简介
    private String full_description;//商品描述
    private String pic;//商品图片
    /*
        商品的小分类值
        0正常         1热门产品           2为你推荐           3新品         4小米明星单品
    查询商品时，我们可以通过大分类(cid)得到一个分类中的数据
    也可以通过小分类state来得到不同大分类中的商品数据
    */
    private Integer state;
    private String version;//商品版本
    private Date product_date;//商品的生产日期

    public Goods(){

    }

    public Goods(Integer gid, Integer cid, String gname, String color, String description, String full_description, String pic, Integer state, String version, Date product_date) {
        this.gid = gid;
        this.cid = cid;
        this.gname = gname;
        this.color = color;
        this.description = description;
        this.full_description = full_description;
        this.pic = pic;
        this.state = state;
        this.version = version;
        this.product_date = product_date;
    }

    public Goods(Integer cid, String gname, String color, String description, String full_description, String pic, Integer state, String version, Date product_date) {
        this.cid = cid;
        this.gname = gname;
        this.color = color;
        this.description = description;
        this.full_description = full_description;
        this.pic = pic;
        this.state = state;
        this.version = version;
        this.product_date = product_date;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getProduct_date() {
        return product_date;
    }

    public void setProduct_date(Date product_date) {
        this.product_date = product_date;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", cid=" + cid +
                ", gname='" + gname + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", full_description='" + full_description + '\'' +
                ", pic='" + pic + '\'' +
                ", state=" + state +
                ", version='" + version + '\'' +
                ", product_date=" + product_date +
                '}';
    }
}

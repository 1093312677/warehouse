package com.warehouse.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 差评入库记录
 * Created by kone on 2017-08-08.
 */
public class ProductRecord {
    private Long id;

    private Long productId;//产品id

    private Integer inNum;//入库数量

    private String remark;//备注

    private String time;//入库时间

    private  Integer yn;

    private Product product;

    private List<ProductRecordMaterial> productRecordMaterialList = new ArrayList<ProductRecordMaterial>();

    public ProductRecord() {
    }

    public ProductRecord(Long id, Long productId, Integer inNum, String remark, String time, Integer yn) {
        this.id = id;
        this.productId = productId;
        this.inNum = inNum;
        this.remark = remark;
        this.time = time;
        this.yn = yn;
    }

    public ProductRecord(Long id, Long productId, Integer inNum, String remark, String time, Integer yn, Product product, List<ProductRecordMaterial> productRecordMaterialList) {
        this.id = id;
        this.productId = productId;
        this.inNum = inNum;
        this.remark = remark;
        this.time = time;
        this.yn = yn;
        this.product = product;
        this.productRecordMaterialList = productRecordMaterialList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getInNum() {
        return inNum;
    }

    public void setInNum(Integer inNum) {
        this.inNum = inNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ProductRecordMaterial> getProductRecordMaterialList() {
        return productRecordMaterialList;
    }

    public void setProductRecordMaterialList(List<ProductRecordMaterial> productRecordMaterialList) {
        this.productRecordMaterialList = productRecordMaterialList;
    }

    @Override
    public String toString() {
        return "ProductRecord{" +
                "id=" + id +
                ", productId=" + productId +
                ", inNum=" + inNum +
                ", remark='" + remark + '\'' +
                ", time='" + time + '\'' +
                ", yn=" + yn +
                ", product=" + product +
                '}';
    }
}

package com.warehouse.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品实体类
 * Created by kone on 2017-08-08.
 */
public class Product {
    private Long id;

    private Long projectId;//项目编号

    private String productName;//产品名称

    private Integer number;//成品数量

    private Integer yn;

    private List<ProductRecord> productRecordList = new ArrayList<ProductRecord>();

    public Product() {
    }

    public Product(Long id, Long projectId, String productName, Integer number, Integer yn) {
        this.id = id;
        this.projectId = projectId;
        this.productName = productName;
        this.number = number;
        this.yn = yn;
    }

    public Product(Long id, Long projectId, String productName, Integer number, Integer yn, List<ProductRecord> productRecordList) {
        this.id = id;
        this.projectId = projectId;
        this.productName = productName;
        this.number = number;
        this.yn = yn;
        this.productRecordList = productRecordList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public List<ProductRecord> getProductRecordList() {
        return productRecordList;
    }

    public void setProductRecordList(List<ProductRecord> productRecordList) {
        this.productRecordList = productRecordList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", productName='" + productName + '\'' +
                ", number=" + number +
                ", yn=" + yn +
                ", productRecordList=" + productRecordList +
                '}';
    }
}

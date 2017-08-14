package com.warehouse.entity;

import java.util.Date;

/**
 * 原材料入库记录
 * Created by kone on 2017-08-08.
 */
public class MaterialRecord {
    private Long id;

    private Long materialId;//原材料id

    private Float inNum;//入库数量

    private String remark;//备注

    private String time;//入库时间

    private  Integer yn;

    private Material material;

    public MaterialRecord() {
    }

    public MaterialRecord(Long id, Long materialId, Float inNum, String remark, String time, Integer yn, Material material) {
        this.id = id;
        this.materialId = materialId;
        this.inNum = inNum;
        this.remark = remark;
        this.time = time;
        this.yn = yn;
        this.material = material;
    }

    public MaterialRecord(Long id, Long materialId, Float inNum, String remark, String time, Integer yn) {
        this.id = id;
        this.materialId = materialId;
        this.inNum = inNum;
        this.remark = remark;
        this.time = time;
        this.yn = yn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Float getInNum() {
        return inNum;
    }

    public void setInNum(Float inNum) {
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }
}

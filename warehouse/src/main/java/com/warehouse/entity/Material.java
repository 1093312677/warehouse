package com.warehouse.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 原材料实体类
 * Created by kone on 2017-08-08.
 */
public class Material {
    private Long id;

    private Long projectId;//项目编号

    private String materialName;//原材料名称

    private Float number;//原材料数量

    private Integer yn;

    private List<MaterialRecord> materialRecordList = new ArrayList<MaterialRecord>();

    public Material() {
    }

    public Material(Long id, Long projectId, String materialName, Float number, Integer yn) {
        this.id = id;
        this.projectId = projectId;
        this.materialName = materialName;
        this.number = number;
        this.yn = yn;
    }

    public Material(Long id, Long projectId, String materialName, Float number, Integer yn, List<MaterialRecord> materialRecordList) {
        this.id = id;
        this.projectId = projectId;
        this.materialName = materialName;
        this.number = number;
        this.yn = yn;
        this.materialRecordList = materialRecordList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public List<MaterialRecord> getMaterialRecordList() {
        return materialRecordList;
    }

    public void setMaterialRecordList(List<MaterialRecord> materialRecordList) {
        this.materialRecordList = materialRecordList;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}

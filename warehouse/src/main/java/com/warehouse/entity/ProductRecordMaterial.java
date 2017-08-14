package com.warehouse.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品和材料多对多实体类
 * Created by kone on 2017-08-09.
 */
public class ProductRecordMaterial {
    private Long id;

    private Long materialId;//材料编号

    private Long productRecordId;//产品记录id

    private Float number;//材料数量

    private Integer yn;

    private ProductRecord productRecord;

    private Material material;

    public ProductRecordMaterial() {
    }

    public ProductRecordMaterial(Long id, Long materialId, Long productRecordId, Float number, Integer yn, ProductRecord productRecord, Material material) {
        this.id = id;
        this.materialId = materialId;
        this.productRecordId = productRecordId;
        this.number = number;
        this.yn = yn;
        this.productRecord = productRecord;
        this.material = material;
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

    public Long getProductRecordId() {
        return productRecordId;
    }

    public void setProductRecordId(Long productRecordId) {
        this.productRecordId = productRecordId;
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

    public ProductRecord getProductRecord() {
        return productRecord;
    }

    public void setProductRecord(ProductRecord productRecord) {
        this.productRecord = productRecord;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}

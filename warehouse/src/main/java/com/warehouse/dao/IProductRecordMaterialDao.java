package com.warehouse.dao;

import com.warehouse.entity.ProductRecord;
import com.warehouse.entity.ProductRecordMaterial;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kone on 2017-08-08.
 */
public interface IProductRecordMaterialDao {

    /**
     * 查看产品
     * @return
     */
    public List<ProductRecordMaterial> viewProductRecordMaterial(@Param("productRecordId") Long productRecordId, @Param("offset") int offset, @Param("size") int size);

    /**
     * 增加产品
     * @param productRecordMaterial
     * @return
     */
    public Long addProductRecordMaterial(ProductRecordMaterial productRecordMaterial);

    /**
     * 查看产品入库记录表
     * @param id
     * @return
     */
    public List<ProductRecordMaterial> viewProductRecordMaterialDetials(Long id);


}

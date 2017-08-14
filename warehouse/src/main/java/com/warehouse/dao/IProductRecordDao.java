package com.warehouse.dao;

import com.warehouse.entity.Product;
import com.warehouse.entity.ProductRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kone on 2017-08-08.
 */
public interface IProductRecordDao {

    /**
     * 查看产品记录
     * @return
     */
    public List<ProductRecord> viewProductRecord(@Param("productId") Long productId, @Param("offset") int offset, @Param("size") int size, @Param("startTime")  String startTime,@Param("endTime")  String endTime);

    /**
     * 查看产品记录总条数
     * @param productId
     * @return
     */
    public Integer viewProductRecordCount(@Param("productId") Long productId, @Param("startTime")  String startTime,@Param("endTime")  String endTime);

    /**
     * 增加产品记录
     * @param productRecord
     * @return
     */
    public void addProductRecord(@Param("productRecord") ProductRecord productRecord);

    /**
     * 获取查找或者全部的数量
     * @param productId
     * @return
     */
    public Float getSum(@Param("productId") Long productId, @Param("startTime")  String startTime,@Param("endTime")  String endTime);
}

package com.warehouse.dao;

import com.warehouse.entity.Material;
import com.warehouse.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kone on 2017-08-08.
 */
public interface IProductDao {

    /**
     * 查看产品
     * @return
     */
    public List<Product> viewProduct(@Param("projectId") Long projectId, @Param("offset") int offset,@Param("size") int size);

    /**
     * 增加产品
     * @param product
     * @return
     */
    public boolean addProduct(Product product);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteProduct(Long id);

    /**
     * 添加产品
     * @param id
     * @param number
     * @return
     */
    public boolean updateProductNum(@Param("id")Long id, @Param("number")Integer number);

}

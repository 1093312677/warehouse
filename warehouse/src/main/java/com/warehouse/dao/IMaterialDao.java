package com.warehouse.dao;

import com.warehouse.entity.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kone on 2017-08-08.
 */
public interface IMaterialDao {

    /**
     * 查看原材料
     * @return
     */
    public List<Material> viewMaterial(Long projectId);

    /**
     * 增加原材料
     * @param material
     * @return
     */
    public boolean addMaterial(Material material);

    /**
     * 删除原材料
     * @param id
     * @return
     */
    public boolean deleteMaterial(Long id);

    /**
     * 材料入库数量增加
     * @param id
     * @param number
     * @return
     */
    public boolean updateMaterialNum(@Param("id") Long id, @Param("number") Float number);

    /**
     * 通过id查看Material
     * @param id
     * @return
     */
    public Material viewMaterialDetials(Long id);

    /**
     * 材料入库数量增加
     * @param id
     * @param number
     * @return
     */
    public boolean reduceMaterialNum(@Param("id") Long id, @Param("number") Float number);

}

package com.warehouse.service;

import com.warehouse.entity.*;
import com.warehouse.util.Pagination;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 货物逻辑处理
 * Created by kone on 2017-08-06.
 */
public interface IGoodsService {
    /**
     * 查看工程
     * @return
     */
    public List<Project> viewProject();
    /**
     * 增加工程
     * @param project
     * @return
     */
    public boolean addProject(Project project);

    /**
     * 删除工程
     * @param projectId
     * @return
     */
    public boolean deleteProject(Long projectId);

    /**
     * 获取单个项目
     * @param projectId
     * @return
     */
    public Project getProjectOne(Long projectId);

    /**
     * 更新项目
     * @param project
     * @return
     */
    public boolean updateProject(Project project);

    /**
     * 查看原材料
     * @param projectId
     * @return
     */
    public List<Material> viewMaterial(Long projectId);

    /**
     * 增加材料
     * @param material
     * @return
     */
    public boolean addMaterial(Material material);

    /**
     * 增加材料入库记录
     * @param materialRecord
     * @return
     */
    public boolean addMaterialRecord(MaterialRecord materialRecord);

    /**
     * 查看材料入库记录
     * @param materialId
     * @return
     */
    public ModelAndView viewMaterialRecords(Long materialId, String startTime, String endTime, int num, int size);

    /**
     * 查看成品
     * @param projectId
     * @return
     */
    public List<Product> viewProduct(Long projectId, int num, int size);

    /**
     * 增加成品样式
     * @param product
     * @return
     */
    public boolean addProduct(Product product);

    /**
     * 增加成品数量，和相应的记录
     * @param materialName
     * @param materialNum
     * @param productRecord
     * @return
     */
    public boolean addProductRecord(Long[] materialName, Float[] materialNum, ProductRecord productRecord);

    /**
     * 查看产品入库记录
     * @param productId
     * @param num
     * @param size
     * @return
     */
    public ModelAndView viewProductRecord(Long productId, int num, int size, String startTime, String endTime);

}

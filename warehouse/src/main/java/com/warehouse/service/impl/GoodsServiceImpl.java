package com.warehouse.service.impl;

import com.warehouse.dao.*;
import com.warehouse.entity.*;
import com.warehouse.service.IAccountService;
import com.warehouse.service.IGoodsService;
import com.warehouse.util.Pagination;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kone on 2017-08-06.
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    private Logger logger = Logger.getLogger(GoodsServiceImpl.class);

    @Resource
    private IProjectDao projectDao;

    @Resource
    private IMaterialDao materialDao;

    @Resource
    private IMaterialRecordDao materialRecordDao;

    @Resource
    private IProductDao productDao;

    @Resource
    private IProductRecordDao productRecordDao;

    @Resource
    private IProductRecordMaterialDao productRecordMaterialDao;

    public List<Project> viewProject() {
        return projectDao.viewProject();
    }

    public boolean addProject(Project project) {
        return projectDao.addProject(project);
    }

    public boolean deleteProject(Long projectId) {
        if(projectDao.updateYn(projectId))
            return true;
        return false;
    }

    public Project getProjectOne(Long projectId) {
        return projectDao.getProjectOne(projectId);
    }

    public boolean updateProject(Project project) {
        if(projectDao.updateProject(project))
            return true;
        return false;
    }

    public List<Material> viewMaterial(Long projectId) {
        return materialDao.viewMaterial(projectId);
    }

    public boolean addMaterial(Material material) {
        material.setYn(0);
        return materialDao.addMaterial(material);
    }
    @Transactional
    public boolean addMaterialRecord(MaterialRecord materialRecord) {
        materialDao.updateMaterialNum(materialRecord.getMaterialId(), materialRecord.getInNum());
        return materialRecordDao.addMaterialRecord(materialRecord);
    }

    public ModelAndView viewMaterialRecords(Long materialId, String startTime, String endTime, int num, int size) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("sum",materialRecordDao.getSum(materialId, startTime, endTime));

//      分页数据
        Pagination<List<MaterialRecord>> pa = new Pagination<List<MaterialRecord>>();
        pa.setCurrentPage(num);
        pa.setPageSize(size);
        pa.setTotal(materialRecordDao.getCount(materialId, startTime, endTime));
        if(num >= 1) {
            num -= 1;
        } else {
            num = 0;
        }
        if(startTime == "" || endTime == "") {
            startTime = null;
            endTime = null;
        }
        List<MaterialRecord> materialRecords = materialRecordDao.viewMaterialRecord(materialId, startTime, endTime, num*size, size);

        pa.setData(materialRecords);
        mv.addObject("pagination",pa);
        return mv;
    }

    public List<Product> viewProduct(Long projectId, int num, int size) {
        return productDao.viewProduct(projectId, num*size, size);
    }

    public boolean addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Transactional
    public boolean addProductRecord(Long[] materialName, Float[] materialNum, ProductRecord productRecord) {
//        增加成品数量
        if(productDao.updateProductNum(productRecord.getProductId(), productRecord.getInNum())) {
//            增加成品入库记录
             productRecordDao.addProductRecord(productRecord);
            for(int i=0;i<materialName.length;i++) {
                if(materialName[i] != 0) {
                    ProductRecordMaterial prm = new ProductRecordMaterial();
                    prm.setMaterialId(materialName[i]);
                    prm.setNumber(materialNum[i]);
                    prm.setProductRecordId(productRecord.getId());
//                     减少材料数量
                    materialDao.reduceMaterialNum(materialName[i], materialNum[i]);

//                    增加产品入库记录材料表
                    productRecordMaterialDao.addProductRecordMaterial(prm);
                }
            }
            return true;
        }
        return false;
    }

    public ModelAndView viewProductRecord(Long productId, int num, int size, String startTime, String endTime) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("sum",productRecordDao.getSum(productId, startTime, endTime));
        // 分页数据
        Pagination<List<ProductRecord>> pa = new Pagination<List<ProductRecord>>();
        pa.setCurrentPage(num);
        pa.setPageSize(size);
        pa.setTotal(productRecordDao.viewProductRecordCount(productId, startTime, endTime));
        if(num >= 1) {
            num -= 1;
        } else {
            num = 0;
        }

        List<ProductRecord> productRecords = productRecordDao.viewProductRecord(productId, num*size, size, startTime, endTime);
        List<ProductRecordMaterial> productRecordMaterials = null;
        for(ProductRecord pr:productRecords) {
            logger.info(pr.getId());
            productRecordMaterials =  new ArrayList<ProductRecordMaterial>();
            productRecordMaterials = productRecordMaterialDao.viewProductRecordMaterialDetials(pr.getId());
            Material m = null;
            for(ProductRecordMaterial prm:productRecordMaterials) {
                m = materialDao.viewMaterialDetials(prm.getMaterialId());
                prm.setMaterial(m);
                logger.info(prm.getNumber()+"------------material-------"+prm.getMaterial().getMaterialName());
            }

            pr.setProductRecordMaterialList(productRecordMaterials);
        }


        pa.setData(productRecords);


        mv.addObject("pagination",pa);
        return mv;
    }
}

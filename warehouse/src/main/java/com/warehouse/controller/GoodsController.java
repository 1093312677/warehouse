package com.warehouse.controller;

import com.warehouse.entity.*;
import com.warehouse.service.IGoodsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 货物管理控制器
 * Created by kone on 2017-08-05.
 */
@Controller
@RequestMapping("/controller/goods")
public class GoodsController {

    private Logger logger = Logger.getLogger(GoodsController.class);

    @Resource
    private IGoodsService goodsService;
    /**
     * 查看所有工程
     * @return mv
     */
    @RequestMapping("/viewProject")
    public ModelAndView viewProject() {
        ModelAndView mv = new ModelAndView();
        List<Project> projects = goodsService.viewProject();
        for(Project p : projects) {
            logger.info(p.getName()+"---------"+p.getCreateTime());
        }
        mv.addObject("projects",projects);
        mv.setViewName("viewProject");
        return mv;
    }

    /**
     * 增加项目
     * @param project
     * @param response
     * @return
     */
    @RequestMapping("/addProject")
    public String addProject(Project project, HttpServletResponse response) {
        if(goodsService.addProject(project)) {
            try {
                response.getWriter().print(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 逻辑删除项目
     * @param projectId
     * @param response
     * @return
     */
    @RequestMapping("/deleteProject")
    public String deleteProject(Long projectId, HttpServletResponse response) {
        if(goodsService.deleteProject(projectId)) {
            try {
                response.getWriter().print(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 查找单个项目
     * @param projectId
     * @return
     */
    @RequestMapping("/getProjectOne")
    @ResponseBody
    public Project getProjectOne(Long projectId) {
        Project project = null;
        project = goodsService.getProjectOne(projectId);
        return project;
    }
    /**
     * 更新项目
     * @param project
     * @param response
     * @return
     */
    @RequestMapping("/updateProject")
    public String updateProject(Project project, HttpServletResponse response) {
        if(goodsService.updateProject(project)) {
            try {
                response.getWriter().print(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 查看原材料详情
     * @param projectId
     * @return
     */
    @RequestMapping("/viewMaterial")
    public ModelAndView viewMaterial(Long projectId) {
        ModelAndView mv = new ModelAndView();
        List<Material> materials = goodsService.viewMaterial(projectId);
        for(Material p : materials) {
            logger.info(p.getMaterialName()+"---------"+p.getNumber());
        }
        mv.addObject("materials",materials);
        mv.setViewName("viewMaterial");
        mv.addObject("projectId",projectId);
        return mv;
    }

    /**
     * 增加材料
     * @param material
     * @param response
     * @return
     */
    @RequestMapping("/addMaterial")
    public String addMaterial(Material material, HttpServletResponse response) {
        if(goodsService.addMaterial(material)) {
            try {
                response.getWriter().print(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 查看材料入库记录
     * @param materialId
     * @return
     */
    @RequestMapping("/viewMaterialRecord")
    public ModelAndView viewMaterialRecord(Long materialId, String startTime, String endTime,
                                            @RequestParam(value = "num",defaultValue = "1")int num,
                                            @RequestParam(value = "size",defaultValue = "10")int size) {
        ModelAndView mv = new ModelAndView();
        mv = goodsService.viewMaterialRecords(materialId, startTime, endTime, num, size);
        mv.setViewName("viewMaterialRecord");

        mv.addObject("startTime",startTime);
        mv.addObject("endTime",endTime);
        mv.addObject("materialId",materialId);
        return mv;
    }

    /**
     * 材料入库
     * @param materialRecord
     * @param response
     * @return
     */
    @RequestMapping("/addMaterialRecord")
    public String addMaterialRecord(MaterialRecord materialRecord, HttpServletResponse response) {
        logger.info(materialRecord.getInNum()+"-------------------------");
        if(goodsService.addMaterialRecord(materialRecord)) {
            try {
                response.getWriter().print(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 查看成品
     * @param projectId
     * @return
     */
    @RequestMapping("/viewProduct")
    public ModelAndView viewProduct(Long projectId,
                                    @RequestParam(value = "num",defaultValue = "0")int num,
                                    @RequestParam(value = "size",defaultValue = "1000000")int size) {
        ModelAndView mv = new ModelAndView();
        List<Product> products = goodsService.viewProduct(projectId, num, size);
        mv.addObject("products",products);
        mv.setViewName("viewProduct");
        mv.addObject("projectId",projectId);
        return mv;
    }

    /**
     * 增加成品类型
     * @param product
     * @param response
     * @return
     */
    @RequestMapping("/addProduct")
    public String addProduct(Product product, HttpServletResponse response) {
        logger.info("----------add product---------------");
        if(goodsService.addProduct(product)) {
            try {
                response.getWriter().print(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 添加成品时选择原材料
     * @param projectId
     * @return
     */
    @RequestMapping("/selectMaterial")
    @ResponseBody
    public List<Material> selectMaterial(Long projectId) {
        List<Material> materials = goodsService.viewMaterial(projectId);
        return materials;
    }

    /**
     * 增加成品数量，和相应的记录
     * @param productRecord
     * @param response
     * @return
     */
    @RequestMapping("/addProductRecord")
    public String addProductRecord(Long[] materialName, Float[] materialNum, ProductRecord productRecord, HttpServletResponse response) {
        logger.info("----------add product record---------------");
        if(goodsService.addProductRecord(materialName, materialNum, productRecord)) {
            try {
                response.getWriter().print(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 查看产品入库记录
     * @param productId
     * @param num
     * @param size
     * @return
     */
    @RequestMapping("/viewProductRecord")
    public ModelAndView viewProductRecord(Long productId, String startTime, String endTime,
                                    @RequestParam(value = "num",defaultValue = "1")int num,
                                    @RequestParam(value = "size",defaultValue = "10")int size) {
        ModelAndView mv = new ModelAndView();
        mv = goodsService.viewProductRecord(productId, num, size, startTime, endTime);

        mv.setViewName("viewProductRecord");
        mv.addObject("productId",productId);
        mv.addObject("startTime",startTime);
        mv.addObject("endTime",endTime);
        return mv;
    }
}

package com.warehouse.dao;

import com.warehouse.entity.Project;
import com.warehouse.entity.User;

import java.util.List;

/**
 * Created by kone on 2017-08-06.
 */
public interface IProjectDao {

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
     *项目逻辑上删除
     * @param projectId
     * @return
     */
    public boolean updateYn(Long projectId);

    /**
     * 更新项目
     * @param project
     * @return
     */
    public boolean updateProject(Project project);

    /**
     * 获取单个项目
     * @param projectId
     * @return
     */
    public Project getProjectOne(Long projectId);

}

package com.warehouse.entity;

import java.util.Date;

/**
 * Created by kone on 2017-08-06.
 */
public class Project {
    private Long id;

    private String projectName;//项目名称

    private String projectContent;//项目说明

    private String name;//给谁做的项目

    private String tel;//项目的手机号

    private String createTime;//项目创建时间

    private Integer yn;

    public Project() {
    }

    public Project(Long id, String projectName, String projectContent, String name, String tel, String createTime, Integer yn) {
        this.id = id;
        this.projectName = projectName;
        this.projectContent = projectContent;
        this.name = name;
        this.tel = tel;
        this.createTime = createTime;
        this.yn = yn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }
}

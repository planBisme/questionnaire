package com.guolei.demo.dao.entity;

import java.util.Date;

public class ProjectEntity {
    private String id;
    private String userId;
    private String projectName;
    private String projectContent;
    private String createdBy;
    private Date creationDate;
    private String lastUpDateBy;
    private Date lastUpdateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpDateBy() {
        return lastUpDateBy;
    }

    public void setLastUpDateBy(String lastUpDateBy) {
        this.lastUpDateBy = lastUpDateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectContent='" + projectContent + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", lastUpDateBy='" + lastUpDateBy + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                '}';
    }
}

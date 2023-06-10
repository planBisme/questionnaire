package com.guolei.demo.dao.entity;

import java.util.Date;

public class QuestionnaireEntity {
    private String id;
    private String ProjectName;
    private String questionnaireName;
    private String questionnaireContent;
    private String createdBy;
    private Date creationDate;
    private Date startTime;
    private Date endTime;
    private String questionId;
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public String getQuestionnaireContent() {
        return questionnaireContent;
    }

    public void setQuestionnaireContent(String questionnaireContent) {
        this.questionnaireContent = questionnaireContent;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QuestionnaireEntity{" +
                "id='" + id + '\'' +
                ", ProjectName='" + ProjectName + '\'' +
                ", questionnaireName='" + questionnaireName + '\'' +
                ", questionnaireContent='" + questionnaireContent + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", questionId='" + questionId + '\'' +
                ", status=" + status +
                '}';
    }
}

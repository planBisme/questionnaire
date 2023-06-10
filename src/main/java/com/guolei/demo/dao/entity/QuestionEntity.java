package com.guolei.demo.dao.entity;

import java.io.Serializable;
import java.util.List;

public class QuestionEntity implements Serializable {
    private String questionId;
    private String surveyId;
    private String questionText;
    private String questionType;
    private List<OptionEntity> options;
    public QuestionEntity() {
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<OptionEntity> getOptions() {
        return options;
    }

    public void setOptions(List<OptionEntity> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "questionId='" + questionId + '\'' +
                ", surveyId='" + surveyId + '\'' +
                ", questionText='" + questionText + '\'' +
                ", questionType='" + questionType + '\'' +
                ", options=" + options +
                '}';
    }
}

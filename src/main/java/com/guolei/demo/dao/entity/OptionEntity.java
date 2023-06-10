package com.guolei.demo.dao.entity;

import java.io.Serializable;

public class OptionEntity implements Serializable {
    private  String optionId;
    private  String questionId;
    private  String optionContent;
    private String surveyId;
    private int  number;

    public  OptionEntity(){

    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OptionEntity{" +
                "optionId='" + optionId + '\'' +
                ", questionId='" + questionId + '\'' +
                ", optionContent='" + optionContent + '\'' +
                ", surveyId='" + surveyId + '\'' +
                ", number=" + number +
                '}';
    }
}

package com.guolei.demo.dao.entity;

import java.io.Serializable;

public class UnitEntity implements Serializable {

    private QuestionEntity questionEntity;
    private OptionEntity optionEntity;

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    public OptionEntity getOptionEntity() {
        return optionEntity;
    }

    public void setOptionEntity(OptionEntity optionEntity) {
        this.optionEntity = optionEntity;
    }
}

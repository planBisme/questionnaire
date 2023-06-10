package com.guolei.demo.service;

import com.guolei.demo.common.utils.UUIDUtil;
import com.guolei.demo.dao.QuestionnaireEntityMapper;
import com.guolei.demo.dao.entity.OptionEntity;
import com.guolei.demo.dao.entity.QuestionEntity;
import com.guolei.demo.dao.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireEntityMapper questionnaireEntityMapper;
    public int addQuestionnaireInfo(QuestionnaireEntity questionnaireEntity) {
        //questionnaireEntity.setId(UUIDUtil.getOneUUID());
        int result=questionnaireEntityMapper.insert(questionnaireEntity);
        return result;
    }

    public int modifyQuestionnaire(List<QuestionEntity> questionEntityList) {
        if(questionEntityList.isEmpty()){
            return 0;
        }
        for(QuestionEntity q:questionEntityList){
            questionnaireEntityMapper.insertQues(q);
            List<OptionEntity> list=q.getOptions();
            for(OptionEntity option:list){
                questionnaireEntityMapper.insertOption(option);
            }

        }
        return  1;
    }

    public List<QuestionnaireEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity) {
        List<QuestionnaireEntity>  result=questionnaireEntityMapper.queryQuestionnaireList(questionnaireEntity);
        return result;
    }

    public int releaseQuestionnaire(QuestionnaireEntity questionnaireEntity) {
        int result=questionnaireEntityMapper.releaseQuestionnaire(questionnaireEntity);
        return result;
    }

    public List<QuestionEntity> queryQuestionList(QuestionEntity questionEntity) {
        List<QuestionEntity> result=questionnaireEntityMapper.queryQuestionList(questionEntity);
        return result;
    }

    public List<OptionEntity> queryOptionList(OptionEntity optionEntity) {
        List<OptionEntity> result=questionnaireEntityMapper.queryOptionList(optionEntity);
        return result;
    }

    public int submitQuestionnaire(List<OptionEntity> optionEntityList) {
        if(optionEntityList.isEmpty()){
            return 0;
        }
        for(OptionEntity option:optionEntityList){
            questionnaireEntityMapper.updateOption(option);
        }
        return  1;
    }
}

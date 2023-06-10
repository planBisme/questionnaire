package com.guolei.demo.dao;

import com.guolei.demo.dao.entity.OptionEntity;
import com.guolei.demo.dao.entity.QuestionEntity;
import com.guolei.demo.dao.entity.QuestionnaireEntity;
import com.guolei.demo.dao.entity.UserEntity;
import com.guolei.demo.service.QuestionnaireService;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface QuestionnaireEntityMapper {

    int insert(QuestionnaireEntity questionnaireEntity);

    int insertQues(QuestionEntity questionEntity);

    int insertOption(OptionEntity option);

    List<QuestionnaireEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity);



    int releaseQuestionnaire(QuestionnaireEntity questionnaireEntity);

    List<QuestionEntity> queryQuestionList(QuestionEntity questionEntity);

    List<OptionEntity> queryOptionList(OptionEntity optionEntity);

    int updateOption(OptionEntity option);
}

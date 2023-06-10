package com.guolei.demo.controller;

import com.guolei.demo.beans.HttpResponseEntity;
import com.guolei.demo.dao.entity.*;
import com.guolei.demo.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;
    //第一个用法添加问卷
    @RequestMapping(value="/addQuestionnaireInfo",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity addQuestionnaireInfo(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        System.out.println("进入创建问卷功能");
        try{
            int  result=questionnaireService.addQuestionnaireInfo(questionnaireEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("问卷创建成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("问卷创建失败!");
            }
        }catch(Exception e){
            System.out.println("问卷创建失败err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }


    @RequestMapping(value="/modifyQuestionnaire",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity modifyQuestionnaire(@RequestBody List<QuestionEntity> questionEntityList){
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
         System.out.println("进入编辑问题功能");
        try{
            int  result=questionnaireService.modifyQuestionnaire(questionEntityList);

            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("问题编辑成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("问题编辑失败!");
            }
        }catch(Exception e){
            System.out.println("问题编辑失败err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/queryQuestionnaireList",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity queryQuestionnaireList(@RequestBody QuestionnaireEntity questionnaireEntity){
        System.out.println("进入查询问卷列表功能");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            System.out.println("try");
            List<QuestionnaireEntity> questionnaireList=questionnaireService.queryQuestionnaireList(questionnaireEntity);
            System.out.println(questionnaireList.size());
            if(questionnaireList.isEmpty()){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(null);
                httpResponseEntity.setMassage("查询问卷列表为空!");
            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(questionnaireList);
                httpResponseEntity.setMassage("查询问卷列表成功!");
            }
        }catch(Exception e){
            System.out.println("查询问卷列表异常err!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/releaseQuestionnaire",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity releaseQuestionnaire(@RequestBody QuestionnaireEntity questionnaireEntity){
        System.out.println("进入发布问卷");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            int result=questionnaireService.releaseQuestionnaire(questionnaireEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("发布问卷成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("发布问卷失败!");
            }
        }catch(Exception e){
            System.out.println("发布问卷err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }
    //答题界面接口
    @RequestMapping(value = "/answer/{id}",method = RequestMethod.GET,headers = "Accept=application/json")
    public ModelAndView test(@PathVariable String id){
        System.out.println(id+"的界面");
        String targetPage = "http://172.22.232.62:8085/pages/answerSheet/index.html?id="+id; // 指定你要跳转的页面
        return new ModelAndView(new RedirectView(targetPage));
        //return id+"test";
    }
    @RequestMapping(value="/queryQuestionList",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity queryQuestionList(@RequestBody QuestionEntity questionEntity){
        System.out.println("进入查询试题界面列表");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            List<QuestionEntity> questionList=questionnaireService.queryQuestionList(questionEntity);
            System.out.println("查询到的试题列表"+questionList.size());
            if(questionList.isEmpty()){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(null);
                httpResponseEntity.setMassage("查询问题列表失败!");
            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(questionList);
                httpResponseEntity.setMassage("查询问题列表成功!");
            }
        }catch(Exception e){
            System.out.println("查询问题列表异常err!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/queryOptionList",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity queryOptionList(@RequestBody OptionEntity optionEntity){
        System.out.println("进入查询选项界面列表");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            List<OptionEntity> optionList=questionnaireService.queryOptionList(optionEntity);
            System.out.println(optionList.size());
            if(optionList.isEmpty()){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(null);
                httpResponseEntity.setMassage("查询选项列表失败!");
            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(optionList);
                httpResponseEntity.setMassage("查询选项列表成功!");
            }
        }catch(Exception e){
            System.out.println("查询选项列表异常err!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/submitQuestionnaire",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity submitQuestionnaire(@RequestBody List<OptionEntity> optionEntityList){
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        System.out.println("进入提交问题功能");
        try{
            int  result=questionnaireService.submitQuestionnaire(optionEntityList);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("提交问题成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("提交问题失败!");
            }
        }catch(Exception e){
            System.out.println("提交问题失败err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }

}

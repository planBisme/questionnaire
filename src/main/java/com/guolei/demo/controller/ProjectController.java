package com.guolei.demo.controller;

import com.guolei.demo.beans.HttpResponseEntity;
import com.guolei.demo.dao.entity.ProjectEntity;
import com.guolei.demo.dao.entity.UserEntity;
import com.guolei.demo.service.ProjectService;
import com.guolei.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/manage")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @RequestMapping(value="/queryProjectList",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity  queryProjectList(@RequestBody ProjectEntity projectEntity){
        System.out.println("进入工程查询列表");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
            try{
                List<Map<String,ProjectEntity>> projectSet=projectService.queryProjectList(projectEntity);
                System.out.println("查询到的工程列表："+projectSet.size());
                if(projectSet.isEmpty()){
                    httpResponseEntity.setCode("0");
                    httpResponseEntity.setData(null);
                    httpResponseEntity.setMassage("查询项目列表失败!");
                }else{
                    httpResponseEntity.setCode("666");
                    httpResponseEntity.setData(projectSet);
                    httpResponseEntity.setMassage("查询项目列表成功!");
                }
            }catch(Exception e){
                System.out.println("查询项目列表异常err!");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        return httpResponseEntity;
    }
    @RequestMapping(value="/addProjectInfo",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity  addProjectInfo(@RequestBody ProjectEntity projectEntity){
        System.out.println("进入添加工程功能");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            int  result=projectService.addProjectInfo(projectEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("添加工程成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("添加工程失败!");
            }
        }catch(Exception e){
            System.out.println("添加工程失败err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/modifyProjectInfo",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity  modifyProjectInfo(@RequestBody ProjectEntity projectEntity){
        System.out.println("进入修改工程功能");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            int  result=projectService.modifyProjectInfo(projectEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("修改工程成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("修改工程失败!");
            }
        }catch(Exception e){
            System.out.println("修改工程失败err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/deleteProjectById",method= RequestMethod.DELETE,headers="Accept=application/json")
    public HttpResponseEntity  deleteProjectById(@RequestBody ProjectEntity projectEntity){
        System.out.println("进入删除工程功能");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            int  result=projectService.deleteProjectById(projectEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("删除工程成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("删除工程失败!");
            }
        }catch(Exception e){
            System.out.println("删除工程失败err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }


}

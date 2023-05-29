package com.guolei.demo.controller;

import com.guolei.demo.beans.HttpResponseEntity;
import com.guolei.demo.dao.entity.UserEntity;
import com.guolei.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    //登录验证
    @RequestMapping(value="/userLogin",method=RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity userLogin(@RequestBody UserEntity userEntity){
        System.out.println("进入");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            System.out.println("try");
            List<UserEntity> hasUser=userService.selectUserInfo(userEntity);
            System.out.println(hasUser.size());
            if(hasUser.isEmpty()){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(hasUser.get(0));
                httpResponseEntity.setMassage("登陆失败,用户名密码错误!");
            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasUser);
                httpResponseEntity.setMassage("登陆成功!");
            }
        }catch(Exception e){
            System.out.println("错误异常err!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/queryUserList",method=RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity queryUserList(@RequestBody UserEntity userEntity){
        System.out.println("进入查询列表");
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            System.out.println("try");
            List<UserEntity> hasUser=userService.queryUserList(userEntity);
            System.out.println(hasUser.size());
            if(hasUser.isEmpty()){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(null);
                httpResponseEntity.setMassage("查询用户列表失败!");
            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasUser);
                httpResponseEntity.setMassage("查询用户列表成功!");
            }
        }catch(Exception e){
            System.out.println("查询用户列表异常err!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/addUserInfo",method= RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity addUserInfo(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        System.out.println("进入创建用户");
        try{
            int  result=userService.addUaerInfo(userEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("创建成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("创建失败!");
            }
        }catch(Exception e){
            System.out.println("创建失败err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/modifyUserInfo",method= RequestMethod.PUT,headers="Accept=application/json")
    public HttpResponseEntity modifyUserInfo(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            int  result=userService.modifyUserInfo(userEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("修改成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("修改失败!");
            }
        }catch(Exception e){
            System.out.println("查询用户列表异常err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }
    @RequestMapping(value="/deleteUserById",method= RequestMethod.DELETE,headers="Accept=application/json")
    public HttpResponseEntity deleteUserById(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity= new HttpResponseEntity();
        try{
            int  result=userService.deleteUserById(userEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMassage("删除成功!");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMassage("删除失败!");
            }
        }catch(Exception e){
            System.out.println("查询用户列表异常err!");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }

}

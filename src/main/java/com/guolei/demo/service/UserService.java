package com.guolei.demo.service;

import com.guolei.demo.common.utils.UUIDUtil;
import com.guolei.demo.dao.UserEntityMapper;
import com.guolei.demo.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;
    public List<UserEntity> selectUserInfo(UserEntity userEntity){
        List<UserEntity> result=userEntityMapper.selectUserInfo(userEntity);
        return result;
    }
    public List<UserEntity> queryUserList(UserEntity userEntity){
        List<UserEntity> result=userEntityMapper.queryUserList(userEntity);
        return result;
    }
    public int addUaerInfo(UserEntity userEntity){
        userEntity.setId(UUIDUtil.getOneUUID());
        int result=userEntityMapper.insert(userEntity);
        if(result!=0){
            return 3;//该用户存在；
        }else {
            return result;
        }
    }
    public int modifyUserInfo(UserEntity userEntity){
        int result=userEntityMapper.updateByPrimarKey(userEntity);
        return result;
    }
    public int deleteUserById(UserEntity userEntity){
        int result=userEntityMapper.deleteUserById(userEntity);
        return result;
    }


}

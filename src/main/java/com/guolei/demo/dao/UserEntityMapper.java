package com.guolei.demo.dao;
import com.guolei.demo.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Component
@Mapper
public interface UserEntityMapper {
   /*
   查询
   */
    List<UserEntity> queryUserList (UserEntity userEntity) ;

    /*
    插入
     */
    int insert(UserEntity userEntity);
    /*
    删除
     */
    int deleteUserById (UserEntity userEntity);
    /*
    更新
     */
    int updateByPrimarKey (UserEntity userEntity);

    //
    List<UserEntity> selectUserInfo (UserEntity userEntity);

    int deleteUserByName(UserEntity userEntity);

 int closeUserById(UserEntity userEntity);
}

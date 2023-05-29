package com.guolei.demo.dao;

import com.guolei.demo.dao.entity.ProjectEntity;
import com.guolei.demo.dao.entity.UserEntity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface ProjectEntityMapper {
    @MapKey("project_name")
    List  <Map<String,ProjectEntity>>  queryProjectList (ProjectEntity projectEntity);
    int insert(ProjectEntity projectEntity);

    int updateByPrimaryKeySelective(ProjectEntity projectEntity);


    int deleteProjectById(ProjectEntity projectEntity);
}

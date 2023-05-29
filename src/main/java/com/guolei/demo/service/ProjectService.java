package com.guolei.demo.service;

import com.guolei.demo.common.utils.UUIDUtil;
import com.guolei.demo.dao.ProjectEntityMapper;
import com.guolei.demo.dao.entity.ProjectEntity;
import com.guolei.demo.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectEntityMapper projectEntityMapper;
    public List<Map<String,ProjectEntity>> queryProjectList(ProjectEntity projectEntity){
        List<Map<String,ProjectEntity>> result= projectEntityMapper.queryProjectList(projectEntity);
        return result;
    }
    public int addProjectInfo(ProjectEntity projectEntity){
        //UUIDUtil uuid=new UUIDUtil();
        projectEntity.setId(UUIDUtil.getOneUUID());
        int result=projectEntityMapper.insert(projectEntity);
        return result;
    }

    public int modifyProjectInfo(ProjectEntity projectEntity) {
        int result=projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
        return result;
    }

    public int deleteProjectById(ProjectEntity projectEntity) {
        int result=projectEntityMapper.deleteProjectById(projectEntity);
        return result;
    }

}

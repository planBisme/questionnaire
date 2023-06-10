//package com.guolei.demo;
//
//
//import com.guolei.demo.common.utils.UUIDUtil;
//import com.guolei.demo.dao.ProjectEntityMapper;
//import com.guolei.demo.dao.QuestionnaireEntityMapper;
//import com.guolei.demo.dao.UserEntityMapper;
//import com.guolei.demo.dao.entity.*;
//import com.guolei.demo.service.UserService;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Before;
//
//
//import org.junit.jupiter.api.Test;
//
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.CollectionUtils;
//
//import java.io.IOException;
//
//import java.io.InputStream;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//
////@SpringBootTest
//class DemoApplicationTests {
////    @Test
////    void contextLoads() {
//
//    //    }
//    Logger log = Logger.getLogger(DemoApplicationTests.class);
//    @Test
//    public void queryUserList() throws Exception {
//        String resource = "mybatis-config.xml";
//        //获取核心配置文件输入流
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //获取SqlSessionFactory对象工厂模式
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //获取SqlSession对象，mybatis操作数据库的对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象，接口的实现类，代理模式
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        List<UserEntity> list = userEntityMapper.queryUserList(userEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
//            System.out.println(list);
//            // 记录info级别的信息
//            log.info(">>queryUserList用户列表查询测试成功");
//        }
//    }
//
//    @Test
//    public void selectUserInfo() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("admin");
//        userEntity.setPassword("123");
//        List<UserEntity> list = userEntityMapper.selectUserInfo(userEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
//            System.out.println(list);
//            // 记录info级别的信息
//            log.info(">>qselectUserInfo用户登录测试成功");
//        }
//    }
//
//    @Test
//    public void insert() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(UUIDUtil.getOneUUID());
//        userEntity.setStatus("1");
//        userEntity.setUsername("LS");
//        userEntity.setPassword("123");
//        int i = userEntityMapper.insert(userEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>insert用户插入测试成功");
//        }
//    }
//
//   @Test
//    public void deleteUserByName() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //修改之前的事务为已提交状态
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("kkk");
//        int i = userEntityMapper.deleteUserByName(userEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>delete用户删除测试成功");
//        }
//    }
//    @Test
//    public void queryProjectList() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
//        //调用userMapper的方法
//        ProjectEntity projectEntity = new ProjectEntity();
//        projectEntity.setProjectName("第一个项目");
//        List  <Map<String,ProjectEntity>> list = projectEntityMapper.queryProjectList(projectEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
//            System.out.println(list);
//            // 记录info级别的信息
//            log.info(">>queryProjectList项目列表查询测试成功");
//        }
//    }
//    @Test
//    public void Projectinsert() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
//        //调用userMapper的方法
//        ProjectEntity projectEntity = new ProjectEntity();
//        projectEntity.setId(UUIDUtil.getOneUUID());
//        projectEntity.setProjectName("插入测试");
//        projectEntity.setProjectContent("插入的内容");
//        int i = projectEntityMapper.insert(projectEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>Projectinsert项目插入测试成功");
//        }
//    }
//    @Test
//    public void modifyProjectInfo() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
//        //调用userMapper的方法
//        ProjectEntity projectEntity = new ProjectEntity();
//        projectEntity.setId("123");
//        projectEntity.setProjectName("更新用例");
//        projectEntity.setProjectContent("更新用例说明");
//        int i = projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>update项目更新测试成功");
//        }
//    }
//    @Test
//    public void deleteProjectById() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
//        //调用userMapper的方法
//        ProjectEntity projectEntity = new ProjectEntity();
//        projectEntity.setId("283dcf241cf245aea824dc10bbb3d680");
//        int i = projectEntityMapper.deleteProjectById(projectEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>delete项目删除测试成功");
//        }
//    }
//    //测试问卷发布功能个
//    @Test
//    public void releaseQuestionnaire() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        QuestionnaireEntityMapper questionnaireEntityMapper = sqlSession.getMapper(QuestionnaireEntityMapper.class);
//        //调用userMapper的方法
//        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
//        questionnaireEntity.setId("0d7dc30d5776ba1e68472edbd4ec");
//        int i = questionnaireEntityMapper.releaseQuestionnaire(questionnaireEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>发布问卷功能测试成功");
//        }
//    }
//   // @Test
//    public void createQuestionnaire() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        QuestionnaireEntityMapper questionnaireEntityMapper = sqlSession.getMapper(QuestionnaireEntityMapper.class);
//        //调用userMapper的方法
//        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
//        //id,questionnaireName, questionnaireContent,createdBy,startTime,endTime,projectName;
//        questionnaireEntity.setId("test");
//        questionnaireEntity.setQuestionnaireName("....");
////        questionnaireEntity.setId("test");
////        questionnaireEntity.setId("test");
////        questionnaireEntity.setId("test");
//        int i = questionnaireEntityMapper.insert(questionnaireEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>创建问卷功能测试成功");
//        }
//    }
//
////@Test
////    int insertQues(QuestionEntity questionEntity);
//public void insertQues() throws Exception {
//    String resource = "mybatis-config.xml";
//    InputStream inputStream = Resources.getResourceAsStream(resource);
//    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//    SqlSession sqlSession = sqlSessionFactory.openSession(true);
//    //创建UserMapper对象，mybatis自动生成mapper代理对象
//    QuestionnaireEntityMapper questionnaireEntityMapper = sqlSession.getMapper(QuestionnaireEntityMapper.class);
//    //调用userMapper的方法
//    QuestionEntity questionEntity = new QuestionEntity();
//    //id,questionnaireName, questionnaireContent,createdBy,startTime,endTime,projectName;
//    questionEntity.setQuestionId("test");
//    //questionnaireEntity.setQuestionnaireName("....");
////        questionnaireEntity.setId("test");
////        questionnaireEntity.setId("test");
////        questionnaireEntity.setId("test");
//    int i = questionnaireEntityMapper.insertQues(questionEntity);
//    if(i==0){
//        // 记录error级别的信息
//    }else{
//        System.out.println(i);
//        // 记录info级别的信息
//        log.info(">>添加问题功能测试成功");
//    }
//}
//
////    void insertOption(OptionEntity option);
////@Test
////    int insertQues(QuestionEntity questionEntity);
//public void insertOption() throws Exception {
//    String resource = "mybatis-config.xml";
//    InputStream inputStream = Resources.getResourceAsStream(resource);
//    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//    SqlSession sqlSession = sqlSessionFactory.openSession(true);
//    //创建UserMapper对象，mybatis自动生成mapper代理对象
//    QuestionnaireEntityMapper questionnaireEntityMapper = sqlSession.getMapper(QuestionnaireEntityMapper.class);
//    //调用userMapper的方法
//    OptionEntity optionEntity = new OptionEntity();
//    //id,questionnaireName, questionnaireContent,createdBy,startTime,endTime,projectName;
//    optionEntity.setOptionId("test");
//    //questionnaireEntity.setQuestionnaireName("....");
////        questionnaireEntity.setId("test");
////        questionnaireEntity.setId("test");
////        questionnaireEntity.setId("test");
//    int i = questionnaireEntityMapper.insertOption(optionEntity);
//    if(i==0){
//        // 记录error级别的信息
//    }else{
//        System.out.println(i);
//        // 记录info级别的信息
//        log.info(">>添加选项功能测试成功");
//    }
//}
//
////    List<QuestionnaireEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity);
//@Test
//public void queryQuestionnaireList() throws Exception {
//    String resource = "mybatis-config.xml";
//    //获取核心配置文件输入流
//    InputStream inputStream = Resources.getResourceAsStream(resource);
//    //获取SqlSessionFactory对象工厂模式
//    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//    //获取SqlSession对象，mybatis操作数据库的对象
//    SqlSession sqlSession = sqlSessionFactory.openSession();
//    //创建UserMapper对象，mybatis自动生成mapper代理对象，接口的实现类，代理模式
//    QuestionnaireEntityMapper questionnaireEntityMapper = sqlSession.getMapper(QuestionnaireEntityMapper.class);
//    //调用userMapper的方法
//    QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
//    questionnaireEntity.setProjectName("13543");
//    List<QuestionnaireEntity> list = questionnaireEntityMapper.queryQuestionnaireList(questionnaireEntity);
//    if (CollectionUtils.isEmpty(list)) {
//        // 记录error级别的信息
//    } else {
//        System.out.println(list);
//        // 记录info级别的信息
//        log.info(">> queryQuestionnaireList问卷列表查询测试成功");
//    }
//}
//}
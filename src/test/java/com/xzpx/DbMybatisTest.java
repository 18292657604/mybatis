package com.xzpx;

import com.xzpx.bean.Student;
import com.xzpx.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

/**
 * Created by angel on 2018/11/30.
 */
public class DbMybatisTest {

    private final static String path = "mybatis-config.xml";

    @Test
    public void testMybatis() throws Exception {
        //获取mybaits的配置文件
        InputStream inputStream = Resources.getResourceAsStream(path);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<Student> userLest = sqlSession.selectList("com.xzpx.userList");

        //通过反射获取StudentMapper对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Map<String, Object>> mapLest = studentMapper.queryDatabase();

        ObjectMapper mapper = new ObjectMapper();
        String json=null;
        List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
        Map<String,Object> map1=null;
        Map<String,Object> map2=null;
        for (int i=0;i<mapLest.size();i++) {
            map1=new HashMap<String, Object>();
            map1.put("_id", UUID.randomUUID().toString().trim().replaceAll("-", ""));
            map2=new HashMap<String, Object>();
            map2.put("index",map1);
            result.add(map2);
            result.add(mapLest.get(i));
        }
    }
}

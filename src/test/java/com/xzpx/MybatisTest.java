package com.xzpx;

import com.xzpx.bean.Student;
import com.xzpx.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


/**
 * Created by angel on 2018/11/12.
 */
public class MybatisTest {

    private final static String path = "mybatis-config.xml";

    @Test
    public void testMybatis() throws Exception{
        //获取mybaits的配置文件
        InputStream inputStream = Resources.getResourceAsStream(path);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<Student> userLest = sqlSession.selectList("com.xzpx.userList");

        //通过反射获取StudentMapper对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> userLest = studentMapper.userList();

        System.out.println("======================");
        for (Student user:userLest) {
            System.out.print(user.getName()+" ");
        }
        System.out.println("");
        System.out.println("======================");

    }

}

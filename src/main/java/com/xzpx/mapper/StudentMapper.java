package com.xzpx.mapper;

import com.xzpx.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * mapper 文件
 * @author lsy
 * @date 2018/11/12
 */
@Mapper
public interface StudentMapper {

    @Select("select * from student")
    public List<Student> userList();


    @Select("select * from database_data")
    public List<Map<String, Object>> queryDatabase();

}

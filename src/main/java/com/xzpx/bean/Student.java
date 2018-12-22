package com.xzpx.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author angel
 * @date 2018/11/12
 */
public class Student implements Serializable {

    private Integer id;
    private String name;
    private Date createTime;


    public Student() {
    }

    public Student(Integer id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

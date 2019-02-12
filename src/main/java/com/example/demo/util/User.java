package com.example.demo.util;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;


public class User {

    @ApiModelProperty(hidden=true)
    private Integer id;


    private String name;


    private String pwd;
    @ApiModelProperty(hidden=true)

    private Date createDate;


    private Integer departmentId;


    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

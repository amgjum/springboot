package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user")
public class User {
    private String test;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ApiModelProperty(hidden=true)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String pwd;

    //@ApiModelProperty(hidden=true)
    @Column(name="create_time")
    private Date createDate;


    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name="department_id")
    @ApiModelProperty(hidden=true)
    Department department;

    public User(){}

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

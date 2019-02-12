package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.service.Interface.IUserSerivice;
import com.example.demo.service.UserServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jpacros")
@Api("jpa持久化测试")
public class JpaCrosController {

    @Autowired
    private IUserSerivice userServiceImp;



    @ApiOperation(value = "新增用户", notes = "通过jpa新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名称", paramType = "form", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "用户密码", paramType = "form", required = true, dataType = "String"),
            @ApiImplicitParam(name = "department.id", value = "部门id", paramType = "form", required = true, dataType = "Long"),


    })
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveUser(User user){
        Integer id = this.userServiceImp.addUser(user);

        HashMap<String,Object> h = new HashMap<String,Object>();
        h.put("id",id);
        h.put("code",200);
        h.put("flag","success");
        return h;



    }

    @ApiOperation(value = "查询所有用户", notes = "通过jpa查询用户")
    @RequestMapping(value="/users",method = RequestMethod.GET)
    public List<User> Users(){
        List<User> users = this.userServiceImp.getUsers();
        return users;



    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "Integer"),



    })
    @ApiOperation(value = "根据id查询用户", notes = "通过jpa根据id查询用户")
    @RequestMapping(value="/user",method = RequestMethod.GET)
    @ResponseBody
    public User User(Integer id){
        User user = this.userServiceImp.getUsers(id);
        return user;



    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Pwd", value = "用户密码", paramType = "query", required = true, dataType = "String"),



    })
    @ApiOperation(value = "根据pwd查询用户", notes = "通过jpa根据pwd模糊查询用户")
    @RequestMapping(value="/userByPwd",method = RequestMethod.GET)
    @ResponseBody
    public List<User> UserByPwd(String Pwd){
        List<User> users = this.userServiceImp.findByPwdLike(Pwd);
        return users;



    }


    public IUserSerivice getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(IUserSerivice userServiceImp) {
        this.userServiceImp = userServiceImp;
    }
}

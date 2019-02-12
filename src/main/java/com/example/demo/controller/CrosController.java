package com.example.demo.controller;


import com.example.demo.service.UserService;
import com.example.demo.util.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api("cors相关的api")
public class CrosController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/test",method = RequestMethod.GET)
    @ResponseBody
    public User  test(){
        User u = new User();
        u.setName("aj");
        u.setPwd("132");

        return u;
    }




    @ApiOperation(value = "当前服务器时间信息", notes = "查询数据库服务器时间信息")
    //@ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value="/now",method = RequestMethod.GET)
    @ResponseBody
    public Map  test1(){
       Map map = new HashMap();
       map.put("time",new Date());
       return map;

    }



    @ApiOperation(value = "根据id查询用户", notes = "查询数据库中某个用户信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "query" ,required = true, dataType = "Integer")
    @RequestMapping(value="/user",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(Long id){
            User user = userService.getUser(id);
            return user;



    }


    @RequestMapping(value="/userList",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(Long id){
        List<User> users = userService.getUserList(id);
        return users;



    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名称", paramType = "form", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "用户密码", paramType = "form", required = true, dataType = "String"),
            @ApiImplicitParam(name = "departmentId", value = "部门id", paramType = "form", required = true, dataType = "Long"),


    })

    //@ApiIgnore()

    @RequestMapping(value="/adduser",method = RequestMethod.POST)

    @ResponseBody
    public Integer getUsers(User user){
       Integer id = userService.addUser(user);
        return id;



    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

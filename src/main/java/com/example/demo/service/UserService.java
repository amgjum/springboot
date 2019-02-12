package com.example.demo.service;


import com.example.demo.dao.UserDao;
import com.example.demo.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(Long id){
        User u = userDao.getUser(id);
        return u;

    }


    public List<User> getUserList(Long departmentId){
        List<User> users = userDao.getUserByDepartmentId(departmentId);
        return users;

    }

    public Integer addUser(User user){

        Integer newId = userDao.insertUser(user);
        return newId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

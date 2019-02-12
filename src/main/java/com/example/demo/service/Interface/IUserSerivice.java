package com.example.demo.service.Interface;

import com.example.demo.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserSerivice {
//    public User findUser(int id);
    public Integer addUser(User user);
    public List<User> getUsers();
    public User getUsers(Integer id);
    public List<User> findByPwdLike(String name);
//    public List<User> getAllUser(int start, int end);
//    public User getUser(String name);
//    public User getUser(String name,Integer departmentId);
//    public Page<User> queryUser(Integer departmentId, Pageable page);
//    public Page<User> queryUser2(Integer departmentId,Pageable page);
//    public List<User> getByExample(String name) ;
//    public void updateUser();

}

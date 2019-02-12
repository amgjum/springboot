package com.example.demo.service;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.User;
import com.example.demo.dao.Interface.DepartmentReposotory;
import com.example.demo.dao.Interface.UserRepository;
import com.example.demo.service.Interface.IUserSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements IUserSerivice {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentReposotory departmentReposotory ;

    @Override
    public Integer addUser(User user) {

        user.setCreateDate(new Date(System.currentTimeMillis()));
        Department department = this.departmentReposotory.getOne(user.getDepartment().getId());
        //user.setDepartment(department);
        userRepository.save(user);

        return user.getId();

    }

    @Override
    public List<User> findByPwdLike(String name) {
        return this.userRepository.query(name);
        //return null;
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();

    }

    public User getUsers(Integer id){
        Optional<User> list = this.userRepository.findById(id);
        return list.get();

    }



    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

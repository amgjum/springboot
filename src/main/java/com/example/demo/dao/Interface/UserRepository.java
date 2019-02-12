package com.example.demo.dao.Interface;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{

    @Query(value="select b from User b where b.pwd like %:name%")
    public List<User> query(@Param("name") String name);
}

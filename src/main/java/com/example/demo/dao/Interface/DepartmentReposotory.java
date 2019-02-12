package com.example.demo.dao.Interface;

import com.example.demo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentReposotory extends JpaRepository<Department,Integer> {
}

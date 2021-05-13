package com.example.Department.reprository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Department.model.Department;

public interface DepartRepository extends JpaRepository<Department, Integer> {

}

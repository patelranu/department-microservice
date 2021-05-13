package com.example.Department.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Department.model.Department;
import com.example.Department.reprository.DepartRepository;

import reactor.core.publisher.Flux;

@Service
public class DepartmentService {
	
	@Autowired
	DepartRepository repo;

	public Department save(Department department) {
		return repo.save(department);
	}

	public Department findByID(Integer id) {
		return repo.findById(id).orElse(null);
	}
    
	public Flux<Department> findAll() {
		return (Flux<Department>) repo.findAll();
	}
	

}

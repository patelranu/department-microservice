package com.example.Department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Department.model.Department;
import com.example.Department.service.DepartmentService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	
	@GetMapping("/")
	public String getDepartment() {
		return "welcome ranu";
	}

	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		System.out.println(department.getAddress());
		return service.save(department);
	}
	
	@GetMapping("/getData/{id}")
	public Department getDepartment(@PathVariable("id") int ID) {
		return service.findByID(ID);
	}
	
	//@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@GetMapping(value="/fluxDetails",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Department>getDetails(){
		return service.findAll();
		
	}
}

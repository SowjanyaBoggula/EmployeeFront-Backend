 package com.example.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dao.EmployeeRepo;
 
import com.example.springboot.exception.ResultNotFoundException;
import com.example.springboot.model.Employee;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController 
{
	@Autowired
	private EmployeeRepo repo;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmp()
	{
		return repo.findAll();
	}
	
	@PostMapping("/employee")
	public Employee createEmp(@RequestBody Employee emp)
	{
		System.out.println("emp : "+emp);
		return repo.save(emp);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int id)
	{
		Employee emp =repo.findById(id).orElseThrow(()-> new ResultNotFoundException("Employee data does not Exists"+id));
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable int id,@RequestBody Employee empdetails)
	{
		Employee emp =repo.findById(id).orElseThrow(()-> new ResultNotFoundException("Employee does not Exists"+id));
		emp.setFirstName(empdetails.getFirstName());
		emp.setLastName(empdetails.getLastName());
		emp.setEmailId(empdetails.getEmailId());
		Employee updateEmp=repo.save(emp);
		return ResponseEntity.ok(updateEmp);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String, Boolean>> deteteEmp(@PathVariable int id)
	{
		Employee emp =repo.findById(id).orElseThrow(()-> new ResultNotFoundException("Employee does not Exists"+id));
		repo.delete(emp);
		Map<String, Boolean> response =new HashMap();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
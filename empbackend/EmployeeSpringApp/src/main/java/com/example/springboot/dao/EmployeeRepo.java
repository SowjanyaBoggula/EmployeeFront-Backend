 package com.example.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{
	
}
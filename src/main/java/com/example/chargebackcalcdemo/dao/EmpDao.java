package com.example.chargebackcalcdemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.chargebackcalcdemo.models.Employee;

public interface EmpDao extends CrudRepository<Employee,String>{
     public Employee findByempId(String empId);
     public Employee findBycontactNumber(String contactNumber);
     public List<Employee> findAll();
}

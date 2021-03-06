package com.example.chargebackcalcdemo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.chargebackcalcdemo.models.Admin;

@Repository
public interface AdminDao extends CrudRepository<Admin,String> {
	public Admin findByadminId(String adminId);
	public Admin findBycontactNumber(String contactNumber);
	}

package com.example.chargebackcalcdemo.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.chargebackcalcdemo.models.Feedbackquestions;

public interface feedbackdao extends CrudRepository<Feedbackquestions,Integer>

{
	public List<Feedbackquestions>  findAll();
	public Feedbackquestions findBycustomerId(String customerId);
	public Feedbackquestions findByfid(long fid);
	


}

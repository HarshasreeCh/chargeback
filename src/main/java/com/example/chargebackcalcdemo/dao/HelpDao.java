package com.example.chargebackcalcdemo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.chargebackcalcdemo.models.Help;
@Repository
public interface HelpDao extends CrudRepository<Help,String>{
	public Help findByuserId(String userId);
public List<Help> findAll();
public Help findByhelpId(long helpId);
@Query("select helpId from Help")
public Set<Long> getAllHelpIds();

}

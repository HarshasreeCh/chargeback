package com.example.chargebackcalcdemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.chargebackcalcdemo.models.Bank;

public interface BankDao extends CrudRepository<Bank, String> 
{
	public List<Bank> findAll();

}


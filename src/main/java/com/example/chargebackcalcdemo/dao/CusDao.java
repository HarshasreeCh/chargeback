package com.example.chargebackcalcdemo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.chargebackcalcdemo.models.Customer;

public interface CusDao extends CrudRepository<Customer,String>{
	public Customer findBycusId(String cusId);
	public List<Customer> findAll();
	public Customer findBycontactNumber(String contactNumber);
	public Customer findBycustomerId(long customerId);
	@Query("select customerId from Customer")
	public Set<Long> getAllCustomerIds();
	
	
	/*
	 * @Query("select c from customer c where c.customerId like :customer") public
	 * List<Customer> searchcustomerId(@Param("customer")String customerId);
	 */


}

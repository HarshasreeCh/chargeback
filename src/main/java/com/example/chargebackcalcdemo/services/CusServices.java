package com.example.chargebackcalcdemo.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.Feedbackquestions;
import com.example.chargebackcalcdemo.models.ForgotUid;
import com.example.chargebackcalcdemo.models.Help;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;

public interface CusServices {
	public int createCus(Customer customer);
	public int login(CusLogin cuslogin);
	List<Transactions> transactionlist();
	public int help(Help help);
	//public Customer findByCutomerId(long cutomerId); 
	@Query("select c from Customer c where c.cutomerId like :customerid")
	public List<Customer> searchById(@Param("customerid")long cutomerId);
	
	public Customer findByCutomerId(long cutomerId);
	public List<Customer> cusList();
	public Customer getCustomer(String userId);
	public String fid(ForgotUid fuid);
	public boolean fpwd(ForgotUid fuid);
	public int createComplaint(LodgeComplaint lodgecomplaint);
	public int CreateFeedback(Feedbackquestions fq);

}



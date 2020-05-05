package com.example.chargebackcalcdemo.services;

import java.util.List;
import java.util.Set;

import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.EmpLogin;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.ForgotUid;
import com.example.chargebackcalcdemo.models.Transactions;

public interface EmpServices {
	public int CreateEmp(Employee emp);
	public int login(EmpLogin emplogin);
	public List<Transactions>  transactionList();
	 public Customer searchBycustomerId(long customerId); 
	 public List<Employee> empList();
	 public Set<Long> getCustIds();
	 public String fid(ForgotUid fuid);
	public boolean fpwd(ForgotUid fuid);
	
		
		}

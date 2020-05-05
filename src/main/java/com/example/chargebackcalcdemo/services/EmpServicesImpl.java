package com.example.chargebackcalcdemo.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.chargebackcalcdemo.dao.CusDao;
import com.example.chargebackcalcdemo.dao.EmpDao;
import com.example.chargebackcalcdemo.dao.TransacDao;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.EmpLogin;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.ForgotUid;
import com.example.chargebackcalcdemo.models.Transactions;
@Service
@Component
public class EmpServicesImpl implements EmpServices {
   @Autowired
   private EmpDao dao;
   @Autowired
   private CusDao cdao;
   @Autowired
   private TransacDao tdao;
   
	@Override
	public int CreateEmp(Employee emp) {
		Employee e=dao.findByempId(emp.getEmpId());
		if(e==null) {
			Employee e1=dao.save(emp);
			if (e1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
		
	}

	@Override
	public int login(EmpLogin emplogin) {
		Employee e=dao.findByempId(emplogin.getEmpId());
		 if(e==null)
		 {
		   return 1;
		 }else if(e.getStatus().equals("no"))
		 {
			 	return 2;
			 }
			 else if(e.getPassword().equals(emplogin.getPassword()) && e.getStatus().equals("yes"))
			 {
			 	return 3;
			 }
			 else
			 {
			 return 4;
			 }


	}

	

	@Override
	public Customer searchBycustomerId(long customerId) {
		// TODO Auto-generated method stub
		return cdao.findBycustomerId(customerId);
	}

	@Override
	public List<Transactions> transactionList() {
		// TODO Auto-generated method stub
		return tdao.findAll();
	}

	@Override
	public Set<Long> getCustIds() {
		// TODO Auto-generated method stub
		return cdao.getAllCustomerIds();
	}

	@Override
	public String fid(ForgotUid fuid) {
		Employee a1=dao.findBycontactNumber(fuid.getPhno());
		  if(a1!=null)
		  {
			int a2= a1.getSecretquestion1().compareTo(fuid.getQstn1());
			int a3= a1.getSecretquestion2().compareTo(fuid.getQstn2());
			int a4= a1.getSecretquestion3().compareTo(fuid.getQstn3());
			if((a2==0) && (a3==0) && (a4==0))
			{
				boolean a5=a1.getAnswer1().equalsIgnoreCase(fuid.getAns1());
				boolean a6=a1.getAnswer2().equalsIgnoreCase(fuid.getAns2());
				boolean a7=a1.getAnswer3().equalsIgnoreCase(fuid.getAns3());
				if((a5==true) &&(a6==true) && (a7==true))
				{
					return a1.getEmpId();
				}
			}
		  }
		  return null;}

	@Override
	public boolean fpwd(ForgotUid fuid) {
		Employee a1=dao.findByempId(fuid.getUid());
		  if(a1!=null)
		  {
			int a2= a1.getSecretquestion1().compareTo(fuid.getQstn1());
			int a3= a1.getSecretquestion2().compareTo(fuid.getQstn2());
			int a4= a1.getSecretquestion3().compareTo(fuid.getQstn3());
			if((a2==0) && (a3==0) && (a4==0))
			{
				boolean a5=a1.getAnswer1().equalsIgnoreCase(fuid.getAns1());
				boolean a6=a1.getAnswer2().equalsIgnoreCase(fuid.getAns2());
				boolean a7=a1.getAnswer3().equalsIgnoreCase(fuid.getAns3());
				if((a5==true) &&(a6==true) && (a7==true))
				{
					return true;
				}
			}
		  }
		  return false;
			}

	@Override
	public List<Employee> empList() {
		return dao.findAll();
	}
	
	
}

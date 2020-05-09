package com.example.chargebackcalcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.chargebackcalcdemo.dao.CusDao;
import com.example.chargebackcalcdemo.dao.HelpDao;
import com.example.chargebackcalcdemo.dao.LodgeDao;
import com.example.chargebackcalcdemo.dao.TransacDao;
import com.example.chargebackcalcdemo.dao.feedbackdao;
import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.Feedbackquestions;
import com.example.chargebackcalcdemo.models.ForgotUid;
import com.example.chargebackcalcdemo.models.Help;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;
@Service
@Component
public class CusServicesImpl implements CusServices {
    @Autowired
    private CusDao dao;
    @Autowired 
    private HelpDao hdao;
    @Autowired
    private LodgeDao lcdao;
    @Autowired
    private feedbackdao fdao;
    
    
    private TransacDao transdao;
    	@Override
	public int createCus(Customer customer) {
		Customer c=dao.findBycusId(customer.getCusId());
		if(c==null) {
			Customer c1=dao.save(customer);
			if (c1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
	}
	@Override
	public int login(CusLogin cuslogin) {
		Customer c=dao.findBycusId(cuslogin.getCusId());
		 if(c==null)
		 {
			 return 1;
		 }else if(c.getStatus().equals("Wait for Admin acceptance"))
		 {
		 	return 2;
		 }
		 else if(c.getPassword().equals(cuslogin.getPassword3()) && c.getStatus().equals("Activated"))
		 {
		 	return 3;
		 }
		 else
		 {
		 return 4;
		 }

	}
	@Override
	public List<Customer> cusList() {
		return dao.findAll();

	}

	@Override
	public List<Transactions> transactionlist() {
		
		
	List<Transactions> tl=(List<Transactions>)transdao.findAll();
	return tl;   
	
	}

	/*
	 * @Override
	 * 
	 * public Customer findByCutomerId(Customer customer) {
	 * 
	 * 
	 * Customer c = dao.findByCutomerId(customer.getTransactionslist());
	 * 
	 * return c;
	 * 
	 * 
	 * }
	 */
	
	
	@Override
	public List<Customer> searchById(long cutomerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Customer findByCutomerId(long cutomerId) {
		// TODO Auto-generated method stub
		return dao.findBycustomerId(cutomerId);
	}
	@Override
	public Customer getCustomer(String userId) {
		// TODO Auto-generated method stub
		return dao.findBycusId(userId);
	}
	@Override
	public int help(Help help) {
			Help h1=hdao.save(help);
			if (h1!=null)
			{
				return 1;
			}
			else
			{
				return 2;
			}
		 
	}
	@Override
	public boolean fpwd(ForgotUid fuid) {
		Customer a1=dao.findBycusId(fuid.getUid());
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
	public String fid(ForgotUid fuid) {
		Customer a1=dao.findBycontactNumber(fuid.getPhno());
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
					return a1.getCusId();
				}
			}
		  }
		  return null;
		}

	@Override
	public int createComplaint(LodgeComplaint lodgecomplaint)
	{
		LodgeComplaint lc=lcdao.findByBankaccountnumber(lodgecomplaint.getBankaccountnumber());		
		if(lc==null) {
			LodgeComplaint lc1=lcdao.save(lodgecomplaint);
			if (lc1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
		
		
		return 0;
		
	}
	@Override
	public int CreateFeedback(Feedbackquestions fq) {
		Feedbackquestions f=fdao.findBycustomerId(fq.getCustomerId());
		if(f==null) {
		Feedbackquestions f1=fdao.save(fq);
		if(f1!=null) {
			return 1;
		}else {
			return 2;
		}
		
	}
		return 0;
	}

}
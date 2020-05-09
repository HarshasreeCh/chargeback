package com.example.chargebackcalcdemo.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.chargebackcalcdemo.dao.AdminDao;
import com.example.chargebackcalcdemo.dao.CusDao;
import com.example.chargebackcalcdemo.dao.EmpDao;
import com.example.chargebackcalcdemo.dao.HelpDao;
import com.example.chargebackcalcdemo.dao.feedbackdao;
import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.AdminLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.Feedbackquestions;
import com.example.chargebackcalcdemo.models.ForgotUid;
import com.example.chargebackcalcdemo.models.Help;

@Service
@Component
public class AdminServicesImpl implements AdminServices {
	@Autowired
	private AdminDao dao;
	@Autowired
	private HelpDao hdao; 
	@Autowired 
	private feedbackdao fdao;
	@Autowired
	private CusDao cdao; 
	@Autowired
	private EmpDao edao;
	
	@Override
	public int CreateAd(Admin admin) {
		Admin a=dao.findByadminId(admin.getAdminId());
		if(a==null) {
			Admin a1=dao.save(admin);
			if (a1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
	}

	@Override
	public int login(AdminLogin adminlogin) {
		Admin a =dao.findByadminId(adminlogin.getAdminId());
		 if(a==null)
		 {
		   return 1;
		 }
		 else
		 {
		 return 2;
		 }
}
	

	@Override
	public List<Employee> listemp() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String fid(ForgotUid fuid) {
		Admin a1=dao.findBycontactNumber(fuid.getPhno());
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
					return a1.getAdminId();
				}
			}
		  }
		  return null;
		}

	@Override
	public List<Help> listhelp() {
		return hdao.findAll();
	}

	@Override
	public boolean reply(String userid) {
        Help h=hdao.findByuserId(userid);
        String s=h.getStatus();
        if(s!=null)
        {
        	h.setStatus("your issue has been addressed");
        	hdao.save(h);
        	return true;
        }
		return false;
	}

	@Override
	public boolean fpwd(ForgotUid fuid) {
		Admin a1=dao.findByadminId(fuid.getUid());
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
	public Help searchByhelpId(long helpId) {
		return hdao.findByhelpId(helpId);
	}

	@Override
	public Set<Long> getHelpIds() {
		return hdao.getAllHelpIds();
	}
	@Override
	public List<Feedbackquestions> feedbackList() {
		return fdao.findAll();
	}
	@Override
	public boolean activate(String cusId) {
		Customer c=cdao.findBycusId(cusId);
		String s=c.getStatus();
		c.setStatus("Activated");
		Customer c1=cdao.save(c);
		if(c1.getStatus().equals(s))
		{
		return false;
	}
		return true;
		}

	@Override
	public boolean deactivate(String cusId) {
		Customer c=cdao.findBycusId(cusId);
		String s=c.getStatus();
		c.setStatus("Deactivated");
		Customer c1=cdao.save(c);
		if(c1.getStatus().equals(s)) {
		return false;
	}
		return true;
	}

	@Override
	public boolean accept(String empId) {
		Employee c=edao.findByempId(empId);
		String s=c.getStatus();
		c.setStatus("yes");
		Employee c1=edao.save(c);
		if(c1.getStatus().equals(s))
		{
		return false;
	}
		return true;
	
	}

	@Override
	public boolean reject(String empId) {
		Employee c=edao.findByempId(empId);
		String s=c.getStatus();
		c.setStatus("no");
		Employee c1=edao.save(c);
		if(c1.getStatus().equals(s)) {
		return false;
	}
		return true;
		}
	

	
	}

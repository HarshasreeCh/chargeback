package com.example.chargebackcalcdemo.services;

import java.util.List;
import java.util.Set;

import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.AdminLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.Feedbackquestions;
import com.example.chargebackcalcdemo.models.ForgotUid;
import com.example.chargebackcalcdemo.models.Help;

public interface AdminServices {
	public int CreateAd(Admin admin);
	public int login(AdminLogin adminlogin);
	public List<Employee> listemp();
	public boolean reply(String userid);
	public String fid(ForgotUid fuid);
	public boolean fpwd(ForgotUid fuid);
	public List<Help> listhelp();
	public Help searchByhelpId(long helpId); 
	public Set<Long> getHelpIds(); 
	public List<Feedbackquestions>  feedbackList();
	public boolean activate(String cusId);
	public boolean deactivate(String cusId);
	public boolean accept(String empId);
	public boolean reject(String empId);
	
}

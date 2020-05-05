package com.example.chargebackcalcdemo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chargebackcalcdemo.dao.EmpDao;
import com.example.chargebackcalcdemo.dao.LodgeDao;
import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.EmpLogin;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.ForgotUid;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;
import com.example.chargebackcalcdemo.services.EmpServices;


@Controller
public class EmployeeController {
	@Autowired
	private EmpServices empservices;
	@Autowired
	private EmpDao dao;
@Autowired
private LodgeDao ldao;
	
	@GetMapping(value="/emp")
	public String employee(Model model)
	{ 
		model.addAttribute("emp" ,new Employee());
		return "Empreg";	
	}
	@PostMapping(value="/empr")
   public String empreg(@ModelAttribute("emp") Employee epreg,BindingResult result,Model model)
   {
		if(result.hasErrors())
		{
			return "Empreg";
		}
		
		else {
			
			model.addAttribute("epreg",new EmpLogin());
		
		int res = empservices.CreateEmp(epreg);
		if(res==0)
		{
			model.addAttribute("message", epreg.getFirstName().concat(epreg.getLastName()).toUpperCase()+" You are already registered");
			return "Empreg";
		
		}
		else if(res==1)
		{
			model.addAttribute("message", epreg.getFirstName().concat(epreg.getLastName()).toUpperCase()+" Congrats your registration is successfull");
			return "Empreg";
		
		}
		else
		{
			model.addAttribute("message", "Some thing went wrong");
			return "failure1";
		}
     }
   }	
	@GetMapping(value="/emplogin")
	public String empLogin(Model model)
	{
		model.addAttribute("emplogin",new EmpLogin());
		return "EmpLogin";
	}
	
	@PostMapping(value="/login")
	public String loginverify(@ModelAttribute("emplogin") EmpLogin emplogin,BindingResult result,Model model,HttpSession session)
	{
		if(result.hasErrors())
		{
			return "EmpLogin";
		}
			else {
				int status = empservices.login(emplogin);
				
				if(status==1)
				{
					model.addAttribute("message","you are not registered");
					return "EmpLogin";
			    }
				else if(status==2)
				{
					String message="You are Not yet activated Please wait for admin confirmation";	
					model.addAttribute("message", message);
					return "EmpLogin";
					}
				
				
				else if(status==3)
				{
					
					
					session.setAttribute("name",emplogin.getEmpId());
					
					model.addAttribute("CustIDs",empservices.getCustIds());
					return "EmpHome";
				}
				else
				{
					model.addAttribute("message","Invalid Username OR password");
					return "failure1";
				}
				
				}

	} 
	
	
	
	 @GetMapping("/eforgotuid")
	public String fid(Model model){
		model.addAttribute("name",new ForgotUid());
		return "Empforgotid";
	}
	@PostMapping("/eforgotuid1")
	public String fid1(@ModelAttribute("name") ForgotUid fid,Model model)
	{
		String b=empservices.fid(fid);
		if(b!=null)
		{
	  	model.addAttribute("message",b+" is your id");
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
		}
		return "Empforgotid";
	}
	@GetMapping("/eforgotpswd")
	public String fpwd(Model model){
		model.addAttribute("name1",new ForgotUid());
		return "EmpforgotPwd";
	}
	@PostMapping("/eforgotpwd1")
	public String fpwd1(@ModelAttribute("name1") ForgotUid fid,Model model)
	{
		boolean b=empservices.fpwd(fid);
		if(b==true)
		{
	  	  return "EmpResetPwd";
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
			return "EmpResetPwd";
		}
	}
	@PostMapping("/eupdatepwd")
	public String updatePassword(@ModelAttribute("name1") ForgotUid forgetUID,Model model)
	{
		Employee ad =dao.findByempId(forgetUID.getUid());
		ad.setPassword(forgetUID.getPwd());
		dao.save(ad);
		model.addAttribute("message","your password has been updated");
		return "EmpResetPwd";
	}
	@GetMapping(value="/getCustDetails")
	public String getCustDetails(@RequestParam("cust") long customerid ,Model model)
	{
		Customer customer=empservices.searchBycustomerId(customerid);
		model.addAttribute("customer",customer);
		return "ListCustomers1";
		
	}
	 @PostMapping("/searchcustomers") 
	  public String searchUser(@RequestParam("searchbycustomerId") long customerId,HttpSession
	  session,Model model) 
	  { 
      Customer customers= empservices.searchBycustomerId(customerId); //System.out.println(users)
	  model.addAttribute("searchCustomer", customers); 
	  return "ListCustomers2"; 
	  }
	@GetMapping("/Transactions")
	public String getAllTransactions(Model model,HttpSession session)
	{
		List<Transactions> cusList=empservices.transactionList();
		model.addAttribute("translist", cusList);
		return "ListCustomers1";
	}
	
	@GetMapping("/complaints")
	public String complaints(Model model)
	{
		List<LodgeComplaint> lc=ldao.findAll();
		model.addAttribute("lodge",lc);
		return "chargeback";
		
	}
	@GetMapping("/eaccept")
	public String accpt(@RequestParam("acc") LodgeComplaint lc)
	{
		LodgeComplaint l=ldao.findByBankaccountnumber(lc.getBankaccountnumber());
		l.setStatus("refund intiated");
	    l.setView("unseen");
		ldao.save(l);
		return "chargeback";
	}
	@GetMapping("/ereject")
	public String reject(@RequestParam("acc")LodgeComplaint lc)
	{
		LodgeComplaint l=ldao.findByBankaccountnumber(lc.getBankaccountnumber());
		l.setStatus("Refund rejected because some conditions aren't met");
	    l.setView("unseen");
		ldao.save(l);
		
		return "chargeback";
		
	
	}
	
	@GetMapping(value="/report")
	 public String generateReport(Model model)
	 {
		// long cid=(long)session.getAttribute("customerid");
		 model.addAttribute("message", "Customer's Complaint Status Report ");
		 
		 return "GenerateReport";
	 }
	 @GetMapping(value="/complaintscount")
	 public String complaintsCount(Model model)
	 {
		int count=0;
		 List<LodgeComplaint> lc=ldao.findAll();
		 List<LodgeComplaint> list=new ArrayList();
		 for(LodgeComplaint c:lc)
		 {
			 list.add(c);
			 
			 count++;
		 }
		model.addAttribute("ccount", count);	 
		 return "ComplaintCount";
	 }
	@GetMapping("/Emphome")
	public String h()
	{
		return "EmpHome";
	}
	 @GetMapping(value="/statusofcomplaints")
	 public String statusComplaints(Model model)
	 {  
		 List<LodgeComplaint> lc=ldao.findAll();
		 model.addAttribute("status", lc);
		 return "statusofC";
	 }

	
	@GetMapping(value="/emplogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/listcust")
	public String listc(Model model)
	{
		model.addAttribute("CustIDs",empservices.getCustIds());
		return "ListCustomers";
	}
	
		}


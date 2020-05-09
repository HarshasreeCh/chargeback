package com.example.chargebackcalcdemo.controllers;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chargebackcalcdemo.dao.CusDao;
import com.example.chargebackcalcdemo.dao.HelpDao;
import com.example.chargebackcalcdemo.dao.LodgeDao;
import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.Feedbackquestions;
import com.example.chargebackcalcdemo.models.ForgotUid;
import com.example.chargebackcalcdemo.models.Help;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;
import com.example.chargebackcalcdemo.services.CusServices;
import com.example.chargebackcalcdemo.services.HelpService;



@Controller
public class CustomerController {

	@Autowired
	private CusServices cusservices;
	@Autowired
	private CusDao dao;
	@Autowired
	private HelpDao hdao;
	@Autowired
	private LodgeDao ldao;
	
	@GetMapping(value="/cus")
	 public String customer(Model model) {
		 model.addAttribute("cus",new Customer());
		 return "CusReg";
	 }
	
	
	@PostMapping(value="/cusreg")
	public String cusreg(@ModelAttribute("cus") Customer cust,BindingResult result,Model model) {
		if(result.hasErrors())
		{
			return "CusReg";
		}
		
		else {
			
			model.addAttribute("cust",new CusLogin());
		
		int res = cusservices.createCus(cust);
		if(res==0)
		{
			model.addAttribute("message", cust.getFirstName().concat(cust.getLastName()).toUpperCase()+" You are already registered");
			return "CusReg";
		
		}
		else if(res==1)
		{
			model.addAttribute("message", cust.getFirstName().concat(cust.getLastName()).toUpperCase()+" Congrats your registration is successfull");
			return "CusReg";
		
		}
		else
		{
			model.addAttribute("message", "Some thing went wrong");
			return "failure2";
		}
		
		}
		
	}
	@GetMapping(value="/cuslogin")
	public String cuslogin(Model model) {
		model.addAttribute("cuslogin", new CusLogin());
		return "CusLogin";
	}
	
	@PostMapping(value="/clogin")
	public String loginverify(@ModelAttribute("cuslogin") CusLogin cuslogin,BindingResult result,Model model,HttpSession session) {
		if(result.hasErrors())
		{
			return "CusLogin";
		}
			else {
				int status = cusservices.login(cuslogin);
				
				if(status==1)
				{ 
					model.addAttribute("message","you are not registered");
					return "failure2";
			    }
				else if(status==2)
				{
					String message="You are Not yet activated Please wait for admin confirmation";	
					model.addAttribute("message", message);
					return "CusLogin";
					}
				
				else if(status==3)
				{
					Customer c = cusservices.getCustomer(cuslogin.getCusId());
					session.setAttribute("name",cuslogin.getCusId());
					session.setAttribute("customerid",c.getCustomerId());
					session.setAttribute("firstname", c.getFirstName());
					session.setAttribute("lastname", c.getLastName());
					
					return "CusHome";
				}
				else
				{
					model.addAttribute("message","Invalid Username OR password");
					return "failure2";
				}
				
				}

	}
	@GetMapping("/Custhome")
	public String h()
	{
		return "CusHome";
	}
	
	@GetMapping(value="/translist")
	public String transactionList(Model model,HttpSession session)
	{
		long customerid = (long) session.getAttribute("customerid");
		Customer c = cusservices.findByCutomerId(customerid);
		List<Transactions> translist=c.getTransacList();
		model.addAttribute("custtransactionlist", translist);
		return 	"CusHome";
	
	}
	
	@GetMapping(value="/LodgeComplaint")
	public String lodgeComplaint(Model model,HttpSession session,@RequestParam("transactionid") long tid)
	{
		
		 long customerid = (long) session.getAttribute("customerid");
			Customer c = cusservices.findByCutomerId(customerid);

		List<Transactions> translist=c.getTransacList();
		
		Transactions tx =null;
		for(Transactions t :translist)
		{
			if(t.getTransactionid() == tid)
			{
				tx = t;
			}
		}
		
		
		Date dt =new Date();
		
		Date td = tx.getTransactiondate(); 
		int diff =(int)(( dt.getTime() - td.getTime())/(1000*60*60*24));
		
		if(diff<=15)
		{
			LodgeComplaint lc = new LodgeComplaint();
			model.addAttribute("lc", lc);
			
			return "LodgeComplaintHome";
		}
		else
		{
			model.addAttribute("message", "Not Eligible for Lodge Complaint");
			return "CusHome";
			
		}
		
		  }
	
	
	@GetMapping(value="/beforehelp")
	public String help(Model model)
	{
		model.addAttribute("help",new Help());
		return "CusHelp";
	}
	@PostMapping(value="/afterhelp")
	public String help1(@ModelAttribute("help") Help h,BindingResult result,Model model) {
		if(result.hasErrors())
		{
			return "CusHelp";
		}
		else
		{
			
			int status=cusservices.help(h);
			if(status==1)
			{
				
				model.addAttribute("message","your issue is registered");
				return "CusHelp";
			}
			else
			{
				model.addAttribute("message","Something went wrong");
				return "failure2";
			}
		}
	}
	@GetMapping(value="/lodge")
	public String lodge(Model model)
	{
		model.addAttribute("message","After logging in,you will find a lodge complaint option in right top corner.Clicking on it will redirect to lodge complaint page.");
		return "failure2";
	}
	@GetMapping(value="/status")
	public String status(Model model)
	{
		model.addAttribute("message","After logging in,you will find a status of complaint option in right top corner.Clicking on it will redirect to a page where you can check status of your complaint");
		return "failure2";
	}	

	
	@GetMapping("/cforgotuid")
	public String fid(Model model){
		model.addAttribute("name",new ForgotUid());
		return "CusForgotid";
	}
	@PostMapping("/cforgotuid1")
	public String fid1(@ModelAttribute("name") ForgotUid fid,Customer customer,Model model)
	{
		String b=cusservices.fid(fid);
		if(b!=null)
		{
	  	model.addAttribute("message",b+" is your id");
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
		}
		return "CusForgotid";
	}
	@GetMapping("/cforgotpswd")
	public String fpwd(Model model){
		model.addAttribute("name1",new ForgotUid());
		return "CusForgotPwd";
	}
	@PostMapping("/cforgotpwd1")
	public String fpwd1(@ModelAttribute("name1") ForgotUid fid,Model model)
	{
		boolean b=cusservices.fpwd(fid);
		if(b==true)
		{
	  	  return "CusResetPwd";
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
			return "CusResetPwd";
		}
	}
	@PostMapping("/cupdatepwd")
	public String updatePassword(@ModelAttribute("name1") ForgotUid forgetUID,Model model)
	{
		Customer cd =dao.findBycusId(forgetUID.getUid());
		cd.setPassword(forgetUID.getPwd());
		dao.save(cd);
		model.addAttribute("message","your password has been updated");
		return "CusResetPwd";
	}

	@PostMapping("/dblodge")
	public String dbLodge(@ModelAttribute("lc") LodgeComplaint lodgecomplaint,BindingResult result,Model model)
	{
		
		//long bankacono= lodgeservices.createComplaint(Customer customer);
		

		int res = cusservices.createComplaint(lodgecomplaint);
		if(res==0)
		{
			model.addAttribute("message", lodgecomplaint.getFirstname().concat(lodgecomplaint.getLastname()).toUpperCase()+" You have already raised a complaint");
			return "LodgeComplaintHome";
		
		}else if(res==1)
		{
			model.addAttribute("message",lodgecomplaint.getFirstname().concat(lodgecomplaint.getLastname()).toUpperCase()+" Complaint Raised successfully");
			return "failure2";
		
		}
		else
		{
			return "failure2";
		}
		
	}@GetMapping("/helpRequests")
	public String helprqsts(@RequestParam("req") String name,Model model)
	{	
		List<Help> h=hdao.findAll();
		List<Help> list=new ArrayList();
	
		for(Help e:h)
		{ 
			if(e.getUserId().equals(name))
			{
				
				list.add(e);
				System.out.println(list);	
			}
			
		}
		model.addAttribute("h1", list);
		return "HelpRequests";
	}
	
	@GetMapping("/trackstatus")
	public String trackstatus(Model model,HttpSession session)
	{
		long cid=(long)session.getAttribute("customerid");
		List<LodgeComplaint> status=ldao.findAll();
		List<LodgeComplaint> list=new ArrayList();
		for(LodgeComplaint e:status)
		{
			if((e.getCustomerid())==cid)
			{
				list.add(e);
			}
		}
		model.addAttribute("status",list);
		return "complaintlist";
	}
   @GetMapping("/checkstatus")
   public String Checkstatus(@RequestParam("stat") String tid,Model model)
   {
	  LodgeComplaint lc=ldao.findBytransactionid(tid);
	  model.addAttribute("status",lc.getStatus());
	  return "complaintstatus";
   }
   @GetMapping("/feedback1")
	public String feedback1(Model model,HttpSession session)
	{
		Feedbackquestions f=new Feedbackquestions();
		model.addAttribute("feedbk", f);
		return "FeedBackpage";
	}
   @PostMapping(value="/feedbackques")
	public String feedback(@ModelAttribute("feedbk")Feedbackquestions fdq,BindingResult result,Model model) {
		if(result.hasErrors())
		{
			return "FeedBackpage";
			
		}
		else {
			int res=cusservices.CreateFeedback(fdq);
			if(res==0)
			{
				
				model.addAttribute("message",fdq.getCustomerId()+" you are already submitted the feedback");
				return "FeedBackpage";
			}
			else if(res==1)
			{
				model.addAttribute("message",fdq.getCustomerId()+" you are successfully submitted the feedback");
				return "FeedBackpage";
			}
			else {
				model.addAttribute("message","something went wrong");
				return "FeedBackpage";
			}
		}
	}
   @GetMapping("/notification")
   public String Notify(@RequestParam("msg") long cid,Model model)
   {
	   LodgeComplaint l=ldao.findBycustomerid(cid);
	   long f=l.getCustomerid();
	   if(f==cid)
        {  
		   String g=l.getView();
        	if(g.equalsIgnoreCase("unseen"))
        	{
        		l.setView("seen");
        		ldao.save(l);
        		return "notify";
        	}
        }
        model.addAttribute("message","You have no new notifications");
        return "failure2";
	   
   }
	
   
	@GetMapping(value="/cuslogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
	
	


}










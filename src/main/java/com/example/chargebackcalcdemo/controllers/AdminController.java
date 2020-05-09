package com.example.chargebackcalcdemo.controllers;


import java.util.ArrayList;
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

import com.example.chargebackcalcdemo.dao.AdminDao;
import com.example.chargebackcalcdemo.dao.HelpDao;
import com.example.chargebackcalcdemo.dao.feedbackdao;
import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.AdminLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.Feedbackquestions;
import com.example.chargebackcalcdemo.models.ForgotUid;
import com.example.chargebackcalcdemo.models.Help;
import com.example.chargebackcalcdemo.models.Reply1;
import com.example.chargebackcalcdemo.services.AdminServices;
import com.example.chargebackcalcdemo.services.CusServices;
import com.example.chargebackcalcdemo.services.EmpServices;
import com.example.chargebackcalcdemo.services.HelpService;
import com.example.chargebackcalcdemo.services.feed;


@Controller
public class AdminController {
	@Autowired
	private AdminServices adminservices;
	@Autowired
	private HelpService helpservice;
	@Autowired
	private CusServices cusservice;
	@Autowired
	private EmpServices empservice;
	@Autowired
	private feed fser;
	
	@Autowired
	private AdminDao dao;
	@Autowired
	private HelpDao hdao;
	@Autowired
	private feedbackdao fdao;
	
	@GetMapping("/Adminhome")
	public String h()
	{
		return "adminhome";
	}
	
	@GetMapping(value="/admin")
	 public String admin(Model model) {
		 model.addAttribute("admin",new Admin());
		 return "AdminRegistration";
	 }
	
	
	@PostMapping(value="/adminreg")
	public String adminreg(@ModelAttribute("admin") Admin ad,BindingResult result,Model model) {
		if(result.hasErrors())
		{
			return "AdminRegistration";
		}
		
		else {
			
			model.addAttribute("ad",new AdminLogin());
		
		int res = adminservices.CreateAd(ad);
		if(res==0)
		{
			model.addAttribute("message", ad.getFirstName().concat(ad.getLastName()).toUpperCase()+" You are already registered");
			return "AdminRegistration";
		
		}
		else if(res==1)
		{
			model.addAttribute("message", ad.getFirstName().concat(ad.getLastName()).toUpperCase()+" Congrats your registration is successfull");
			return "AdminRegistration";
		
		}
		else
		{
			model.addAttribute("message", "Some thing went wrong");
			return "failure";
		}
		
		}
	
	}
	@GetMapping(value="/adminlogin")
	public String adminlogin(Model model) {
		model.addAttribute("adminlogin", new AdminLogin());
		return "AdminLogin";
	}
	
	@PostMapping(value="/loginverify")
	public String loginverify(@ModelAttribute("adminlogin") AdminLogin adminlogin,BindingResult result,Model model,HttpSession session) {
		if(result.hasErrors())
		{
			return "AdminLogin";
		}
		else {
			int status = adminservices.login(adminlogin);
			
			if(status==1)
			{
				model.addAttribute("message","you are not registered");
				return "failure";
		    }
			else if(status==2)
			{
				session.setAttribute("name",adminlogin.getAdminId());
				return "adminhome";
			}
			else
			{
				model.addAttribute("message","Invalid Username OR password");
				return "failure";
			}
			
			}
	
	}
	@GetMapping("/reply")
	public String Reply(@RequestParam("msg") long hid,Model model,HttpSession session)
	{
		session.setAttribute("name",hid);
		model.addAttribute("rep",new Reply1());
		return "Reply";
	}
	@PostMapping("/replyaction")
	public String ReplyAction(@ModelAttribute("rep") Reply1 reply,Model model)
	{
		Help hd =hdao.findByhelpId(reply.getHid());
		hd.setStatus(reply.getReply());
		hdao.save(hd);
		model.addAttribute("message","Issue has been addressed");
		return "Reply";
	
	}
	
	@GetMapping("/helpreq")
	public String getreq(Model model)
	{
		List<Help> helpList=helpservice.helplist();
		model.addAttribute("helpList", helpList);
		//System.out.println(helpList);
		return "HelpList";
		
	}
	/*@GetMapping(value="/getDetails")
	public String getCustDetails(@RequestParam("help") long hid ,Model model)
	{
	    Help h=adminservices.searchByhelpId(hid);
		model.addAttribute("h1",h);
		return "HelpList1";
		
	}*/
	@GetMapping("/forgotuid")
	public String fid(Model model){
		model.addAttribute("name",new ForgotUid());
		return "forgotid";
	}
	@PostMapping("/forgotuid1")
	public String fid1(@ModelAttribute("name") ForgotUid fid,Model model)
	{
		String b=adminservices.fid(fid);
		if(b!=null)
		{
	  	model.addAttribute("message",b+" is your id");
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
		}
		return "forgotid";
	}
	@GetMapping("/forgotpswd")
	public String fpwd(Model model){
		model.addAttribute("name1",new ForgotUid());
		return "forgotpwd";
	}
	@PostMapping("/forgotpwd1")
	public String fpwd1(@ModelAttribute("name1") ForgotUid fid,Model model)
	{
		boolean b=adminservices.fpwd(fid);
		if(b==true)
		{
	  	  return "resetPwd";
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
			return "resetPwd";
		}
	}
	@PostMapping("/updatepwd")
	public String updatePassword(@ModelAttribute("name1") ForgotUid forgetUID,Model model)
	{
		Admin ad =dao.findByadminId(forgetUID.getUid());
		ad.setPassword(forgetUID.getPwd());
		dao.save(ad);
		model.addAttribute("message","your password has been updated");
		return "resetPwd";
	}
	
	@GetMapping("/acceptuserregisteration")
	public String showUsers(Model m)
	{
		List<Customer> cusList=cusservice.cusList();
		List<Customer> list=new ArrayList<Customer>();
		for(Customer c:cusList)
		{
			String a=c.getStatus();
			if(a.equalsIgnoreCase("Wait for Admin acceptance"))
			{
				list.add(c);
			}
		}
		m.addAttribute("cusList", list);
		//System.out.println(list);
		return "Customers";
	}
	@GetMapping("activate")
	public String activate(@RequestParam("id")String custId,Model model) {
		boolean b1=adminservices.activate(custId);
		if(b1)
		{
			model.addAttribute("message","Accepted");
			return "failure";
		}
		model.addAttribute("message","Already accepted");
		return "failure";
	}
	@GetMapping("deactivate")
	public String deactivate(@RequestParam("id")String username,Model model) {
		boolean b1=adminservices.deactivate(username);
		if(b1)
		{
			model.addAttribute("message","Rejected");
			return "failure";
		
		}
		model.addAttribute("message","Already rejected");
		return "failure";
	}
	@GetMapping("/employees")
	public String showEmp(Model m)
	{
		List<Employee> empList=empservice.empList();
		List<Employee> list=new ArrayList<Employee>();
		for(Employee e:empList)
		{
			String a=e.getStatus();
			if(a.equalsIgnoreCase("Wait for Admin acceptance"))
			{
				list.add(e);
			}
		}
		m.addAttribute("empList", list);
		return "Employees";
	}
	@GetMapping("accept")
	public String accept(@RequestParam("id")String empId,Model model) {
		boolean b1=adminservices.accept(empId);
		if(b1)
		{
			model.addAttribute("message","Accepted");
			return "failure";
		}
		model.addAttribute("message","Already accepted");
		return "failure";
	}
	@GetMapping("reject")
	public String reject(@RequestParam("id")String username,Model model) {
		boolean b1=adminservices.reject(username);
		if(b1)
		{
			model.addAttribute("message","Rejected");
			return "failure";
		
		}
		model.addAttribute("message","Already Rejected");
		return "failure";
	}

	@GetMapping("/feedbkcustomers")
	public String getAllfeedbacks(Model model,HttpSession session)
	{
		List<Feedbackquestions> cusList=adminservices.feedbackList();
		model.addAttribute("feedlist", cusList);
		return "feed";
	}
	@GetMapping("/getfeedDetails")
	public String getFeed(@RequestParam("cust") long fid,Model model)
	{
		Feedbackquestions fb=fser.searchByfid(fid);
		model.addAttribute("feed",fb);
		return "feed1";
	}
	
	@GetMapping(value="/adminlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
@GetMapping("/pie")
public String pie(Model model)
{
     List<Feedbackquestions> list=fdao.findAll();	
     int a1[]=new int[5];
     int a2[]=new int[5];
     int a3[]=new int[5];
     int a4[]=new int[5];
     int a5[]=new int[5];
     for(Feedbackquestions f:list)
     {
    	  a1=fser.findByans1();
    	  a2=fser.findByans2(); 
    	  a3=fser.findByans3();
    	  a4=fser.findByans4();
    	  a5=fser.findByans5();
    	 
     }
     List list1=new ArrayList();
     for(int i=0;i<5;i++)
     {
    	
    	list1.add(a1[i]);
    	list1.add(a2[i]);
    	list1.add(a3[i]);
    	list1.add(a4[i]);
    	list1.add(a5[i]);
    	
     }
     
     model.addAttribute("last",list1);
	return "feed";
}
	
	
	

}

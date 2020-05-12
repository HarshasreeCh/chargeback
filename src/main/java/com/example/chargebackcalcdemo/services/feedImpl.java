package com.example.chargebackcalcdemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.chargebackcalcdemo.dao.feedbackdao;
import com.example.chargebackcalcdemo.models.Feedbackquestions;
@Service
@Component
public class feedImpl implements feed {

	@Autowired
	private feedbackdao fdao;
	
	@Override
	public int[] findByans1() {
		int agree=0;
		int dagree=0;
		int sagree=0;
		int sdagree=0;
		int nagree=0;
		
		List<Feedbackquestions> list=fdao.findAll();	
		for(Feedbackquestions f:list)
		{
			String f1=f.getAns1();
			if(f1.equals("Agree"))
			{
				agree++;
			}else if(f1.equals("Disagree"))
			{
				dagree++;
			}else if(f1.equals("Stronglyagree"))
			{
				sagree++;
			}else if(f1.equals("Stronglydisagree"))
			{
				sdagree++;
			}else if(f1.equals("None"))
			{
				nagree++;
			}
		}
		int a[]=new int[5];
		a[0]=agree;
		a[1]=dagree;
		a[2]=sagree;
		a[3]=sdagree;
		a[4]=nagree;
	
		return a;

	}


	@Override
	public int[] findByans2() {
		int agree=0;
		int dagree=0;
		int sagree=0;
		int sdagree=0;
		int nagree=0;
		
		List<Feedbackquestions> list=fdao.findAll();	
		for(Feedbackquestions f:list)
		{
			String f1=f.getAns2();
			if(f1.equals("Agree"))
			{
				agree++;
			}else if(f1.equals("Disagree"))
			{
				dagree++;
			}else if(f1.equals("Stronglyagree"))
			{
				sagree++;
			}else if(f1.equals("Stronglydisagree"))
			{
				sdagree++;
			}else if(f1.equals("None"))
			{
				nagree++;
			}
		}
		int a[]=new int[5];
		a[0]=agree;
		a[1]=dagree;
		a[2]=sagree;
		a[3]=sdagree;
		a[4]=nagree;
		return a;
	}



	@Override
	public int[] findByans3() {
		int agree=0;
		int dagree=0;
		int sagree=0;
		int sdagree=0;
		int nagree=0;
		
		List<Feedbackquestions> list=fdao.findAll();	
		for(Feedbackquestions f:list)
		{
			String f1=f.getAns3();
			if(f1.equals("Agree"))
			{
				agree++;
			}else if(f1.equals("Disagree"))
			{
				dagree++;
			}else if(f1.equals("Stronglyagree"))
			{
				sagree++;
			}else if(f1.equals("Stronglydisagree"))
			{
				sdagree++;
			}else if(f1.equals("None"))
			{
				nagree++;
			}
		}
		int a[]=new int[5];
		a[0]=agree;
		a[1]=dagree;
		a[2]=sagree;
		a[3]=sdagree;
		a[4]=nagree;
		return a;
	}


	@Override
	public int[] findByans4() {
		int agree=0;
		int dagree=0;
		int sagree=0;
		int sdagree=0;
		int nagree=0;
		
		List<Feedbackquestions> list=fdao.findAll();	
		for(Feedbackquestions f:list)
		{
			String f1=f.getAns4();
			if(f1.equals("Agree"))
			{
				agree++;
			}else if(f1.equals("Disagree"))
			{
				dagree++;
			}else if(f1.equals("Stronglyagree"))
			{
				sagree++;
			}else if(f1.equals("Stronglydisagree"))
			{
				sdagree++;
			}else if(f1.equals("None"))
			{
				nagree++;
			}
		}
		int a[]=new int[5];
		a[0]=agree;
		a[1]=dagree;
		a[2]=sagree;
		a[3]=sdagree;
		a[4]=nagree;
		return a;
	}



	@Override
	public int[] findByans5() {
		int agree=0;
		int dagree=0;
		int sagree=0;
		int sdagree=0;
		int nagree=0;
		
		List<Feedbackquestions> list=fdao.findAll();	
		for(Feedbackquestions f:list)
		{
			String f1=f.getAns5();
			if(f1.equals("Agree"))
			{
				agree++;
			}else if(f1.equals("Disagree"))
			{
				dagree++;
			}else if(f1.equals("Stronglyagree"))
			{
				sagree++;
			}else if(f1.equals("Stronglydisagree"))
			{
				sdagree++;
			}else if(f1.equals("None"))
			{
				nagree++;
			}
		}
		int a[]=new int[5];
		a[0]=agree;
		a[1]=dagree;
		a[2]=sagree;
		a[3]=sdagree;
		a[4]=nagree;
		return a;
	}


	@Override
	public Feedbackquestions searchByfid(long fid) {
		return fdao.findByfid(fid);
	}
}



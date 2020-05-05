package com.example.chargebackcalcdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.chargebackcalcdemo.dao.HelpDao;
import com.example.chargebackcalcdemo.models.Help;
@Service
@Component
public class HelpServicesImpl implements HelpService {
     @Autowired
     private HelpDao dao;
	@Override
	public List<Help> helplist() {
		
		return dao.findAll();
	}

}

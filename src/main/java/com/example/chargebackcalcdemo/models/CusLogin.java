package com.example.chargebackcalcdemo.models;

import javax.validation.constraints.NotEmpty;

public class CusLogin {
	private String cusId;
	private String password3;
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getPassword3() {
		return password3;
	}
	public void setPassword3(String password3) {
		this.password3 = password3;
	}
	@Override
	public String toString() {
		return "CusLogin [cusId=" + cusId + ", password3=" + password3 + "]";
	}
	

}

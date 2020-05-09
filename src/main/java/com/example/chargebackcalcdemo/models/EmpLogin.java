package com.example.chargebackcalcdemo.models;

import javax.validation.constraints.NotEmpty;

public class EmpLogin {
	private String empId;
	private String password2;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	@Override
	public String toString() {
		return "EmpLogin [empId=" + empId + ", password2=" + password2 + "]";
	}
	}

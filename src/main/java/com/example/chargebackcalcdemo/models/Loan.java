package com.example.chargebackcalcdemo.models;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="loan")
public class Loan {
	@Id
	@SequenceGenerator(name = "loanSequence", initialValue = 100, allocationSize = 1, sequenceName = "LOAN_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loanSequence")
	private String loanId;
 @Column
 private String emi;
 @Column
 private String duedate;
 @Column
 private String loanname;
 @Column
 private String lateCharge;
 @Column
 private String loandate;
 @Column
 private String emiMonths;
 
public String getEmiMonths() {
	return emiMonths;
}
public void setEmiMonths(String emiMonths) {
	this.emiMonths = emiMonths;
}
public String getLoandate() {
	return loandate;
}
public void setLoandate(String loandate) {
	this.loandate = loandate;
}
public String getLoanId() {
	return loanId;
}
public void setLoanId(String loanId) {
	this.loanId = loanId;
}
public String getEmi() {
	return emi;
}
public void setEmi(String emi) {
	this.emi = emi;
}
public String getDuedate() {
	return duedate;
}
public void setDuedate(String duedate) {
	this.duedate = duedate;
}
public String getLoanname() {
	return loanname;
}
public void setLoanname(String loanname) {
	this.loanname = loanname;
}
public String getLateCharge() {
	return lateCharge;
}
public void setLateCharge(String lateCharge) {
	this.lateCharge = lateCharge;
}
@Override
public String toString() {
	return "Loan [loanId=" + loanId + ", emi=" + emi + ", duedate=" + duedate + ", loanname=" + loanname
			+ ", lateCharge=" + lateCharge + ", loandate=" + loandate + ", emiMonths=" + emiMonths + "]";
}
 
}

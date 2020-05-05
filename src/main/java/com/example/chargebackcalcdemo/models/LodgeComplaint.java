package com.example.chargebackcalcdemo.models;


import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lodgecomplaint")

public class LodgeComplaint {

		
	@Generated(value = "assigned")
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String contactnumber;
	@Column
	private String emailid;
	@Id 
	@Column
	private String bankaccountnumber;
	@Column
	private String branchname;
	@Column
	private String transactionid;
	@Column
	private long customerid;
	@Column
	private String chargebackamount;
	@Column
	private String date;
	@Column
	private String reason;
	@Column
	private String status="new";
	@Column
	private String view;
	@Override
	public String toString() {
		return "LodgeComplaint [firstname=" + firstname + ", lastname=" + lastname + ", contactnumber=" + contactnumber
				+ ", emailid=" + emailid + ", bankaccountnumber=" + bankaccountnumber + ", branchname=" + branchname
				+ ", transactionid=" + transactionid + ", customerid=" + customerid + ", chargebackamount="
				+ chargebackamount + ", date=" + date + ", reason=" + reason + ", status=" + status + ", view=" + view
				+ "]";
	}
	
	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getBankaccountnumber() {
		return bankaccountnumber;
	}
	public void setBankaccountnumber(String bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getChargebackamount() {
		return chargebackamount;
	}
	public void setChargebackamount(String chargebackamount) {
		this.chargebackamount = chargebackamount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	
	
}

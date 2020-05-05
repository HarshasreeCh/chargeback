package com.example.chargebackcalcdemo.models;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankdetails")

public class BankDetails implements Serializable{
	
	@Id
	@Generated(value ="assigned")
	@Column
	private long bankaccountnumber;
	@Column
	private String branchaddress;
	@Column
	private String branchname;
	
	
	public long getBankaccountnumber() {
		return bankaccountnumber;
	}
	public void setBankaccountnumber(long bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}
	public String getBranchaddress() {
		return branchaddress;
	}
	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public BankDetails(long bankaccountnumber, String branchaddress, String branchname) {
		super();
		this.bankaccountnumber = bankaccountnumber;
		this.branchaddress = branchaddress;
		this.branchname = branchname;
	}
	public BankDetails() {
		super();
	}
	@Override
	public String toString() {
		return "BankDetails [bankaccountnumber=" + bankaccountnumber + ", branchaddress=" + branchaddress
				+ ", branchname=" + branchname + "]";
	}
	

}

package com.example.chargebackcalcdemo.models;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bankinfo")
public class Bank
{
	
	@Id
	@Generated("assigned")
	private String bankacno;
	@Column
	private String branchname;
	@Column
	private String branchaddress;
	@Column
	private double avlbal;
	@Override
	public String toString() {
		return "Bank [bankacno=" + bankacno + ", branchname=" + branchname + ", branchaddress=" + branchaddress
				+ ", avlbal=" + avlbal + ", loanList=" + loanList + "]";
	}
	public String getBankacno() {
		return bankacno;
	}
	public void setBankacno(String bankacno) {
		this.bankacno = bankacno;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getBranchaddress() {
		return branchaddress;
	}
	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	public double getAvlbal() {
		return avlbal;
	}
	public void setAvlbal(double avlbal) {
		this.avlbal = avlbal;
	}
		
	@OneToMany(targetEntity=Loan.class ,cascade = CascadeType.ALL)
	  
	  @JoinColumn(name="bankacno", referencedColumnName ="bankacno" )
	 	
	
	 private List<Loan> loanList;
	public List<Loan> getLoanList() {
		return loanList;
	}
	public void setLoanList(List<Loan> loanList) {
		this.loanList = loanList;
	}


}



package com.example.chargebackcalcdemo.models;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="transactions")

public class Transactions implements Serializable {
	
	@Id
	@Generated(value = "assigned")
	private long transactionid;
	@Column
	private Date transactiondate;
	@Column
	private long transationamount;
	@Column
	private String transactionBy;
	
	public String getTransactionBy() {
		return transactionBy;
	}
	public void setTransactionBy(String transactionBy) {
		this.transactionBy = transactionBy;
	}
	public long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}
	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}
	public long getTransationamount() {
		return transationamount;
	}
	public void setTransationamount(long transationamount) {
		this.transationamount = transationamount;
	}
	
	
	
	public Transactions(long transactionid, Date transactiondate, long transationamount) {
		super();
		this.transactionid = transactionid;
		this.transactiondate = transactiondate;
		this.transationamount = transationamount;
	}
	public Transactions() {
		super();
	}
	
	@Override
	public String toString() {
		return "Transactions [transactionid=" + transactionid + ", transactiondate=" + transactiondate
				+ ", transationamount=" + transationamount + ", transactionBy=" + transactionBy + "]";
	}
	
	

}

package com.example.chargebackcalcdemo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	@Id
	@SequenceGenerator(name = "custSequence", initialValue = 10001, allocationSize = 1, sequenceName = "CUSTOMER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custSequence")
	private long customerId;
	@Column(unique = true)
	private String cusId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String dob;
	@Column
	private String gender;
	@Column
	private String contactNumber;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zipcode;
	@Column
	private String password;
	 @Column
	  private String status="no";
	 @Column
	 private String secretquestion1;
	@Column
	private String answer1;
	@Column
	private String secretquestion2;
	@Column
	private String answer2;
	@Column
	private String secretquestion3;
	@Column
	private String answer3;
				
	 
     
		 
	  @OneToMany(targetEntity=Transactions.class ,cascade = CascadeType.ALL)
	  
	  @JoinColumn(name="customer_id", referencedColumnName ="customerid" )
	 	
	
	 private List<Transactions> transacList;
	  
 @OneToMany(targetEntity=Loan.class ,cascade = CascadeType.ALL)
	  
	  @JoinColumn(name="customer_id", referencedColumnName ="customerid" )
	 	
	
	 private List<Loan> loanList;


	  public List<Loan> getLoanList() {
	return loanList;
}

public void setLoanList(List<Loan> loanList) {
	this.loanList = loanList;
}

	@OneToMany(targetEntity=Bank.class ,cascade = CascadeType.ALL)
	  
	  @JoinColumn(name="customer_id", referencedColumnName ="customerid" )
	 	
	
	 private List<Bank> bankinfoo; 
	  

	  @OneToMany(targetEntity=Help.class ,cascade = CascadeType.ALL)
	  
	  @JoinColumn(name="customer_id", referencedColumnName ="customerId" )

	  private List<Help> helpList;
	public List<Bank> getBankinfoo() {
		return bankinfoo;
	}

	public void setBankinfoo(List<Bank> bankinfoo) {
		this.bankinfoo = bankinfoo;
	}

	public List<Transactions> getTransacList() {
		return transacList;
	}

	public void setTransacList(List<Transactions> transacList) {
		this.transacList = transacList;
	}
	

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecretquestion1() {
		return secretquestion1;
	}

	public void setSecretquestion1(String secretquestion1) {
		this.secretquestion1 = secretquestion1;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getSecretquestion2() {
		return secretquestion2;
	}

	public void setSecretquestion2(String secretquestion2) {
		this.secretquestion2 = secretquestion2;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getSecretquestion3() {
		return secretquestion3;
	}

	public void setSecretquestion3(String secretquestion3) {
		this.secretquestion3 = secretquestion3;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

		public List<Help> getHelpList() {
		return helpList;
	}

	public void setHelpList(List<Help> helpList) {
		this.helpList = helpList;
	}
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", cusId=" + cusId + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender + ", contactNumber="
					+ contactNumber + ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode="
					+ zipcode + ", password=" + password + ", status=" + status + ", secretquestion1=" + secretquestion1
					+ ", answer1=" + answer1 + ", secretquestion2=" + secretquestion2 + ", answer2=" + answer2
					+ ", secretquestion3=" + secretquestion3 + ", answer3=" + answer3 + ", transacList=" + transacList
					+ ", loanList=" + loanList + ", bankinfoo=" + bankinfoo + ", helpList=" + helpList + "]";
		}

		
	
}

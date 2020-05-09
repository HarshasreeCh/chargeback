package com.example.chargebackcalcdemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="feedbackTable")
public class Feedbackquestions {
	@Id
	@SequenceGenerator(name = "feedSequence", initialValue = 1000, allocationSize = 1, sequenceName = "FEED_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedSequence")
	private long fid;
	@Column
	private String customerId;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Column
	private String ans1;
	@Column
	private String ans2;
	@Column
	private String ans3;
	@Column
	private String ans4;
	@Column
	private String ans5;
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	public String getAns5() {
		return ans5;
	}
	public void setAns5(String ans5) {
		this.ans5 = ans5;
	}
	
	public long getFid() {
		return fid;
	}
	public void setFid(long fid) {
		this.fid = fid;
	}
	@Override
	public String toString() {
		return "Feedbackquestions [fid=" + fid + ", customerId=" + customerId + ", ans1=" + ans1 + ", ans2=" + ans2
				+ ", ans3=" + ans3 + ", ans4=" + ans4 + ", ans5=" + ans5 + "]";
	}
	
	

}

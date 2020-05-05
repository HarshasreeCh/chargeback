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
@Table(name="help")

public class Help {
	@Id
	@SequenceGenerator(name = "helpSequence", initialValue = 1000, allocationSize = 1, sequenceName = "HELP_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "helpSequence")
	private long helpId;
	@Column
   private String userId;
   @Column
   private String issue;
   @Column 
   private String description;
   @Column
   private String status="new";
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getIssue() {
	return issue;
}
public void setIssue(String issue) {
	this.issue = issue;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

public long getHelpId() {
	return helpId;
}
public void setHelpId(long helpId) {
	this.helpId = helpId;
}
@Override
public String toString() {
	return "Help [helpId=" + helpId + ", userId=" + userId + ", issue=" + issue + ", description=" + description
			+ ", status=" + status + "]";
}
   
}

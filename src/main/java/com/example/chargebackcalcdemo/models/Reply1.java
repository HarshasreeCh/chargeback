package com.example.chargebackcalcdemo.models;

public class Reply1 {
	private long hid;
	private String reply;
	public long getHid() {
		return hid;
	}
	public void setHid(long hid) {
		this.hid = hid;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	@Override
	public String toString() {
		return "Reply1 [hid=" + hid + ", reply=" + reply + "]";
	}
	

}

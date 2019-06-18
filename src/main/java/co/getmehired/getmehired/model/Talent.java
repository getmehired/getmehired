package co.getmehired.getmehired.model;

import java.util.Date;

public class Talent {
	
	private String name; 
	private Integer phoneNumber;
	private String emailAddress;
	private Timezone timezone;
	private String immigrationExpiaryStr;
	private Date immigrationExpiary;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Timezone getTimezone() {
		return timezone;
	}
	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}
	public Date getImmigrationExpiary() {
		return immigrationExpiary;
	}
	public void setImmigrationExpiary(Date immigrationExpiary) {
		this.immigrationExpiary = immigrationExpiary;
	}
	public String getImmigrationExpiaryStr() {
		return immigrationExpiaryStr;
	}
	public void setImmigrationExpiaryStr(String immigrationExpiaryStr) {
		this.immigrationExpiaryStr = immigrationExpiaryStr;
	}

	
}

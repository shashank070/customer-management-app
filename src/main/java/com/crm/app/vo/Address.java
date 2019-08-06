package com.crm.app.vo;

import org.springframework.stereotype.Component;


public class Address {
	
	private String type;
	
	private String addrLine1;

	private String addrLine2;
	
	private String addrLine3;
	
	private String addrLine4;
	
	private String countryCode;
	
	private String zip;
	
	private String state;
	
	private String city;
	
	

	public Address(String type, String addrLine1, String addrLine2, String addrLine3, String addrLine4,
			String countryCode, String zip, String state, String city) {
		super();
		this.type = type;
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.addrLine3 = addrLine3;
		this.addrLine4 = addrLine4;
		this.countryCode = countryCode;
		this.zip = zip;
		this.state = state;
		this.city = city;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getAddrLine3() {
		return addrLine3;
	}

	public void setAddrLine3(String addrLine3) {
		this.addrLine3 = addrLine3;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddrLine4() {
		return addrLine4;
	}

	public void setAddrLine4(String addrLine4) {
		this.addrLine4 = addrLine4;
	}
	
}

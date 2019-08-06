package com.crm.app.vo;

import java.util.List;

import org.springframework.stereotype.Component;


public class CustomerDetail {
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String dateOfBirth;
	
	private String mobileNumber;
	
	private String gender;
	
	private String customerNumber;
	
	private String countryOfBirth;
	
	private String countryOfResidence;
	
	private String customerSegmant;
	
	private List<Address> addresses;
	
	

	public CustomerDetail(String firstName, String middleName, String lastName, String dateOfBirth, String mobileNumber,
			String gender, String customerNumber, String countryOfBirth, String countryOfResidence,
			String customerSegmant, List<Address> addresses) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.customerNumber = customerNumber;
		this.countryOfBirth = countryOfBirth;
		this.countryOfResidence = countryOfResidence;
		this.customerSegmant = customerSegmant;
		this.addresses = addresses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	public String getCustomerSegmant() {
		return customerSegmant;
	}

	public void setCustomerSegmant(String customerSegmant) {
		this.customerSegmant = customerSegmant;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}

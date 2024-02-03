package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCustomer {

	@JsonProperty("accNo")
	private int accNo;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("age")
	private int age;
	
	@JsonProperty("dob")
	private String dob;
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@JsonProperty("phoneNumber")
	private String phoneNumber;
	
	@JsonProperty("AddressType")
	private AddressType addressType;
	
	@JsonProperty("CardDetails")
	private CardDetails cardDetails;

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public CardDetails getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}

	@Override
	public String toString() {
		return "NewCustomer [accNo=" + accNo + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber
				+ ", addressType=" + addressType + ", cardDetails=" + cardDetails + "]";
	}
	
	
}

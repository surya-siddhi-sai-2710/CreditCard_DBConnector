package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

	@JsonProperty("accNo")
	private int accNo;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("age")
	private int age;
	
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	
	@JsonProperty("Address")
	private AddressType addressType;

	// Getters and Setters
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

	// Constructor
	public Customer(int accNo, String name, int age, String phoneNumber, AddressType addressType) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.addressType = addressType;
	}

	public Customer() {
		super();
	}

	// toString() method
	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber
				+ ", addressType=" + addressType + "]";
	}

}

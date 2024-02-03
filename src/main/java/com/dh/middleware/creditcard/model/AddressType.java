package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressType {

	@JsonProperty("city")
	private String city;
	
	@JsonProperty("pincode")
	private String pincode;

	// Getters and Setters
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	// Constructors
	public AddressType(String city, String pincode) {
		super();
		this.city = city;
		this.pincode = pincode;
	}

	public AddressType() {
		super();
	}

	// toString() method
	@Override
	public String toString() {
		return "AddressType [city=" + city + ", pincode=" + pincode + "]";
	}

}

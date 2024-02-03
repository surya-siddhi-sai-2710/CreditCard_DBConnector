package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCreditCardRequest {



	@JsonProperty("NewCustomer")
	private NewCustomer newCustomer;
//	
//	@JsonProperty("NewCreditCardDetails")
//	private NewCreditCardDetails newCreditCardDetails;
//
//	public NewCreditCardDetails getNewCreditCardDetails() {
//		return newCreditCardDetails;
//	}
//
//	public void setNewCreditCardDetails(NewCreditCardDetails newCreditCardDetails) {
//		this.newCreditCardDetails = newCreditCardDetails;
//	}
////	
	public NewCustomer getNewCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(NewCustomer newCustomer) {
		this.newCustomer = newCustomer;
	}
//
//	public NewCreditCardRequest() {
//		super();
//	}
//
//	public NewCreditCardRequest(NewCustomer newCustomer, NewCreditCardDetails newCreditCardDetails) {
//		super();
//		this.newCustomer = newCustomer;
//		this.newCreditCardDetails = newCreditCardDetails;
//	}
//
//	@Override
//	public String toString() {
//		return "NewCreditCardRequest [newCreditCardDetails=" + newCreditCardDetails + "]";
//	}
	
	
}

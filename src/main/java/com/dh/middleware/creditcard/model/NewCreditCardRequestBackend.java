package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCreditCardRequestBackend {

	@JsonProperty("NewCreditCardRequest")
	private NewCreditCardRequest oNewCreditCardRequest;

	public NewCreditCardRequest getoNewCreditCardRequest() {
		return oNewCreditCardRequest;
	}

	public void setoNewCreditCardRequest(NewCreditCardRequest oNewCreditCardRequest) {
		this.oNewCreditCardRequest = oNewCreditCardRequest;
	}

	@Override
	public String toString() {
		return "NewCreditCardRequestBackend [oNewCreditCardRequest=" + oNewCreditCardRequest + "]";
	}
	
	
//	
//	
//	
}

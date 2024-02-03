package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCardRequest {

	@JsonProperty("CreditCardDetailsRequest")
	private CreditCardDetailsRequest creditCardDetailsRequest;

	public CreditCardDetailsRequest getCreditCardDetailsRequest() {
		return creditCardDetailsRequest;
	}

	public void setCreditCardDetailsRequest(CreditCardDetailsRequest creditCardDetailsRequest) {
		this.creditCardDetailsRequest = creditCardDetailsRequest;
	}

	@Override
	public String toString() {
		return "CreditCardRequest [creditCardDetailsRequest=" + creditCardDetailsRequest + "]";
	}

}

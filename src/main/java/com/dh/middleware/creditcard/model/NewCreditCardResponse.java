package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCreditCardResponse {

	@JsonProperty("NewCreditCardResponse")
	private NewCreditCardDetailsResponse oNewCreditCardDetailsResponse;

	public NewCreditCardDetailsResponse getoNewCreditCardDetailsResponse() {
		return oNewCreditCardDetailsResponse;
	}

	public void setoNewCreditCardDetailsResponse(NewCreditCardDetailsResponse oNewCreditCardDetailsResponse) {
		this.oNewCreditCardDetailsResponse = oNewCreditCardDetailsResponse;
	}

	@Override
	public String toString() {
		return "NewCreditCardResponse [oNewCreditCardDetailsResponse=" + oNewCreditCardDetailsResponse + "]";
	}
	
	
}

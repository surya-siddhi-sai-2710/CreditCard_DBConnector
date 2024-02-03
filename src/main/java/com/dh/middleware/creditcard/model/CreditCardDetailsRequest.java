package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCardDetailsRequest {

	@JsonProperty("cardNumber")
	private Long cardNumber;
	
	@JsonProperty("cardType")
	private String cardType;

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	public String toString() {
		return "CreditCardDetailsRequest [cardNumber=" + cardNumber + ", cardType=" + cardType + "]";
	}
	
	
}

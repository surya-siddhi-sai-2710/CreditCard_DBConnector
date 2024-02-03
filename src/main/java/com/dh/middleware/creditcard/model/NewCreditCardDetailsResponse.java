package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCreditCardDetailsResponse {

	@JsonProperty("accNO")
	private int accNo;
	
	@JsonProperty("cardNumber")
	private Long cardNumber;
	
	@JsonProperty("cardType")
	private String cardType;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("response")
	private String response;

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "NewCreditCardResponse [accNo=" + accNo + ", cardNumber=" + cardNumber + ", cardType=" + cardType
				+ ", status=" + status + ", response=" + response + "]";
	}
	
	
}

package com.dh.middleware.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDetails {

	@JsonProperty("cardNumber")
	private Long cardNumber;
	
	@JsonProperty("cardType")
	private String cardType;

	@JsonProperty("branchNo")
	private int branchNo;
	
	@JsonProperty("creditLimit")
	private String creditLimit;
	
	@JsonProperty("holderName")
	private String holderName;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("cibilScore")
	private int cibilScore;
	
	@JsonProperty("deliveryMethod")
	private String deliveryMethod;
	
	@JsonProperty("employeeId")
	private int employeeId;
	
	@JsonProperty("salary")
	private int salary;
	
	@JsonProperty("response")
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public CardDetails(Long cardNumber, String cardType, int branchNo, String creditLimit, String holderName,
			String status, int cibilScore, String deliveryMethod, int employeeId, int salary) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.branchNo = branchNo;
		this.creditLimit = creditLimit;
		this.holderName = holderName;
		this.status = status;
		this.cibilScore = cibilScore;
		this.deliveryMethod = deliveryMethod;
		this.employeeId = employeeId;
		this.salary = salary;
	}

	public CardDetails() {
		super();
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

	public int getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "CardDetails [cardNumber=" + cardNumber + ", cardType=" + cardType + ", branchNo=" + branchNo
				+ ", creditLimit=" + creditLimit + ", holderName=" + holderName + ", status=" + status + ", cibilScore="
				+ cibilScore + ", deliveryMethod=" + deliveryMethod + ", employeeId=" + employeeId + ", salary="
				+ salary + "]";
	}

	
	
}

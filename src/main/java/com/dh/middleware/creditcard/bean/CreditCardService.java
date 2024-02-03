package com.dh.middleware.creditcard.bean;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dh.middleware.creditcard.model.NewCreditCardDetailsResponse;
import com.dh.middleware.creditcard.model.NewCreditCardRequest;
import com.dh.middleware.creditcard.model.NewCreditCardRequestBackend;
import com.dh.middleware.creditcard.model.NewCreditCardResponseBackend;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class CreditCardService {

	@Autowired
	ObjectMapper objectMapper;
	
	public NewCreditCardRequest oNewCreditCardRequest;
	
	String response = null;
	Boolean cibilScore;
	String cardTypeString;
	Boolean ageBoolean;
	int creditLimit;
	String ststuString;
	
	public NewCreditCardRequest setNewCreditCardRequestBackend(
			NewCreditCardRequestBackend oNewcreditCardRequestBackend, Exchange ex) throws Exception{
		
		oNewCreditCardRequest = oNewcreditCardRequestBackend.getoNewCreditCardRequest();
		System.out.println(oNewCreditCardRequest.getNewCustomer());
		return oNewCreditCardRequest;
	}
	
	public void checkCibilScoreAndAge() throws Exception{
		
		int cibilscore = oNewCreditCardRequest.getNewCustomer().getCardDetails().getCibilScore();
		if (cibilscore > 600) {
			cibilScore = true;
		}else {
			cibilScore = false;
		}
		
		int age = oNewCreditCardRequest.getNewCustomer().getAge();
		if(age>18) {
			ageBoolean = true;
		}
		else {
			ageBoolean = false;
		}
	}
	
	public void assignCardBasedOnSalary() throws Exception{
		
		int salary = oNewCreditCardRequest.getNewCustomer().getCardDetails().getSalary();
		
		
		if(salary < 25000) {
			cardTypeString = "HDFC_MoneyBack_creditCard";
			creditLimit = 10000;
		}
		else if (salary > 25000 && salary < 35000 || salary < 50000) {
			cardTypeString = "AmazonPay_ICICI_CreditCard";
			creditLimit = 20000;
		}else if (salary > 50000 && salary < 100000) {
			cardTypeString = "American_Express_Platinium_CreditCard";
			creditLimit = 35000;
		}else if (salary > 100000) {
			cardTypeString = "Axis_Bank_Magnus_Credit_Card";
			creditLimit = 70000;
		}
		
		
	}
	
	public void getNewCreditCardEligibility() throws Exception{
		
		if(cibilScore && ageBoolean) {
			response = "Approved";
			ststuString = "Active";
		}
		else {
			response = "Declined";
			ststuString = "InActive";
		}
		
	}
	
	public JsonNode prepareNewCreditCardRequest() throws Exception{
		
		ObjectNode oNewCreditCardObjectNode = JsonNodeFactory.instance.objectNode();
		ObjectNode oNewCreditCardDetails = oNewCreditCardObjectNode.putObject("NewCreditCardDetails");
		ObjectNode oNewCustomerNode = oNewCreditCardDetails.putObject("NewCustomer");
		
		
		oNewCustomerNode.put("accNo", oNewCreditCardRequest.getNewCustomer().getAccNo());
		oNewCustomerNode.put("name", oNewCreditCardRequest.getNewCustomer().getName());
		oNewCustomerNode.put("age", oNewCreditCardRequest.getNewCustomer().getAge());
		oNewCustomerNode.put("phoneNumber", oNewCreditCardRequest.getNewCustomer().getPhoneNumber());
		oNewCustomerNode.put("dob", oNewCreditCardRequest.getNewCustomer().getDob());
		
		ObjectNode oAddressTypeNode = oNewCustomerNode.putObject("AddressType");
		
		oAddressTypeNode.put("city", oNewCreditCardRequest.getNewCustomer().getAddressType().getCity());
		oAddressTypeNode.put("pincode", oNewCreditCardRequest.getNewCustomer().getAddressType().getPincode());
		
		ObjectNode oCardDetailsNode = oNewCustomerNode.putObject("CardDetails");
		
//		oCardDetailsNode.put("cardNumber", null)
		oCardDetailsNode.put("cardType", cardTypeString);
		oCardDetailsNode.put("branchNo", oNewCreditCardRequest.getNewCustomer().getCardDetails().getBranchNo());
		oCardDetailsNode.put("creditLimit", creditLimit);
		oCardDetailsNode.put("holderName", oNewCreditCardRequest.getNewCustomer().getCardDetails().getHolderName());
		oCardDetailsNode.put("status", ststuString);
		oCardDetailsNode.put("cibilScore", oNewCreditCardRequest.getNewCustomer().getCardDetails().getCibilScore());
		oCardDetailsNode.put("deliveryMethod", oNewCreditCardRequest.getNewCustomer().getCardDetails().getDeliveryMethod());
		oCardDetailsNode.put("employeeId", oNewCreditCardRequest.getNewCustomer().getCardDetails().getEmployeeId());
		oCardDetailsNode.put("salary", oNewCreditCardRequest.getNewCustomer().getCardDetails().getSalary());
		oCardDetailsNode.put("response", response);
		
		return oNewCreditCardObjectNode;

	}
	
	public NewCreditCardResponseBackend prepareNewCreditCardResponse(@Body JsonNode body, Exchange ex) throws Exception{
		
		JsonNode oNewCreditCardDetailsNode = body.get("NewCreditCardResponse");
		
		
		NewCreditCardResponseBackend oNewCreditCardResponseBackend = new NewCreditCardResponseBackend();
		
//		NewCreditCardResponse oNewCreditCardResponse = new NewCreditCardResponse();
		
		NewCreditCardDetailsResponse oNewCreditCardDetailsResponse = new NewCreditCardDetailsResponse();
		
		oNewCreditCardDetailsResponse.setAccNo(oNewCreditCardDetailsNode.path("accNo").asInt());
		oNewCreditCardDetailsResponse.setCardNumber(oNewCreditCardDetailsNode.path("cardNumber").asLong());
		oNewCreditCardDetailsResponse.setCardType(oNewCreditCardDetailsNode.path("cardType").asText());
		oNewCreditCardDetailsResponse.setStatus(oNewCreditCardDetailsNode.path("status").asText());
		oNewCreditCardDetailsResponse.setResponse(oNewCreditCardDetailsNode.path("response").asText());
		
		oNewCreditCardResponseBackend.setoNewCreditCardDetailsResponse(oNewCreditCardDetailsResponse);
		
		return oNewCreditCardResponseBackend;
	}
	
}

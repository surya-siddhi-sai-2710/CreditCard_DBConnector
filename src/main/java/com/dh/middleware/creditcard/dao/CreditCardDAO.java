package com.dh.middleware.creditcard.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dh.middleware.creditcard.model.CreditCardRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

@Component
public class CreditCardDAO {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public ObjectNode getCreditCardDetailsFromDB(CreditCardRequest creditCardRequest) throws Exception{
		
		Long cardNumber = creditCardRequest.getCreditCardDetailsRequest().getCardNumber();
		String cardType = creditCardRequest.getCreditCardDetailsRequest().getCardType();
		
		Connection conn = null;
		CallableStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = dataSource.getConnection();
			String strProcedure = "CALL GET_CREDIT_CARD_DETAILS(?,?,?)";
			pstmt = conn.prepareCall(strProcedure);
			pstmt.setLong(1, cardNumber);
			pstmt.setString(2, cardType);
			pstmt.registerOutParameter(3, OracleTypes.CURSOR);
			pstmt.execute();
			rs = (ResultSet) pstmt.getObject(3);
			
			if(rs.next()) {
				
//				ObjectNode getCreditCardDetails = JsonNodeFactory.instance.objectNode();
				ObjectNode getCreditCardDetails = objectMapper.createObjectNode();
				ObjectNode oGetCreditCardDetailsNode = getCreditCardDetails
						.putObject("CreditCardResponse");
				
				oGetCreditCardDetailsNode.put("accno", rs.getInt(1));
				oGetCreditCardDetailsNode.put("name", rs.getString(2));
				oGetCreditCardDetailsNode.put("age", rs.getInt(3));
				oGetCreditCardDetailsNode.put("phonenumber", rs.getString(4));
				oGetCreditCardDetailsNode.put("dob", rs.getString(5));
				oGetCreditCardDetailsNode.put("city", rs.getString(6));
				oGetCreditCardDetailsNode.put("pincode", rs.getString(7));
				oGetCreditCardDetailsNode.put("cardnumber", rs.getLong(8));
				oGetCreditCardDetailsNode.put("cardtype", rs.getString(9));
				oGetCreditCardDetailsNode.put("creditlimit", rs.getInt(10));
				oGetCreditCardDetailsNode.put("holdername", rs.getString(11));
				oGetCreditCardDetailsNode.put("status", rs.getString(12));
				oGetCreditCardDetailsNode.put("cibilscore", rs.getInt(13));
				oGetCreditCardDetailsNode.put("branchno", rs.getInt(14));
				oGetCreditCardDetailsNode.put("deliverymethod", rs.getString(15));
				oGetCreditCardDetailsNode.put("employeeid", rs.getInt(16));
				oGetCreditCardDetailsNode.put("salary", rs.getInt(17));
				oGetCreditCardDetailsNode.put("response", rs.getString(18));
				
				return getCreditCardDetails;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {

				if (rs != null) {
					rs.close();
				}
				if (null != conn)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void newCreditCardCustomer(@Body JsonNode body, Exchange ex) throws Exception{
		
		JsonNode newCreditCardDetailsNode = body.get("NewCreditCardDetails");
		JsonNode newCustomerNode = newCreditCardDetailsNode.get("NewCustomer");
		JsonNode addressTypeNode = newCustomerNode.get("AddressType");
		JsonNode cardDetailsNode = newCustomerNode.get("CardDetails");
		
		Connection conn = null;
		
		OracleCallableStatement ocStatement = null;
		ResultSet rs = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			String strProcedure = "CALL NEW_CREDIT_CARD_CUSTOMER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ocStatement = (OracleCallableStatement) conn.prepareCall(strProcedure);
			
			ocStatement.setInt(1, newCustomerNode.path("accNo").asInt());
			ocStatement.setString(2, newCustomerNode.path("name").asText());
			ocStatement.setInt(3, newCustomerNode.path("age").asInt());
			ocStatement.setString(4, newCustomerNode.path("phoneNumber").asText());
			ocStatement.setString(5, newCustomerNode.path("dob").asText());
			ocStatement.setString(6, addressTypeNode.path("city").asText());
			ocStatement.setString(7, addressTypeNode.path("pincode").asText());
//			ocStatement.setLong(8, cardDetailsNode.path("cardNumber").asLong());
			ocStatement.setString(8, cardDetailsNode.path("cardType").asText());
			ocStatement.setInt(9, cardDetailsNode.path("creditLimit").asInt());
			ocStatement.setString(10, cardDetailsNode.path("holderName").asText());
			ocStatement.setString(11, cardDetailsNode.path("status").asText());
			ocStatement.setInt(12, cardDetailsNode.path("cibilScore").asInt());
			ocStatement.setInt(13, cardDetailsNode.path("branchNo").asInt());
			ocStatement.setString(14, cardDetailsNode.path("deliveryMethod").asText());
			ocStatement.setInt(15, cardDetailsNode.path("employeeId").asInt());
			ocStatement.setInt(16, cardDetailsNode.path("salary").asInt());
			ocStatement.setString(17, cardDetailsNode.path("response").asText());
			
			ocStatement.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ex.getIn().setBody(e.getMessage());
		}finally {
			try {

				if (rs != null) {
					rs.close();
				}
				if (ocStatement != null) {
					ocStatement.close();
				}

				if (null != conn)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
				ex.getIn().setBody(e.getMessage());
			}
		}
		
		
	}
	
	public JsonNode getNewCreditCardDetails(@Body JsonNode body, Exchange ex) throws Exception {
		
//		JsonNode oNewCreditCardNode = body.get("NewCreditCardDetails");
		
		JsonNode oNewCreditCardNode = body.get("NewCreditCardDetails");
		
		JsonNode oNewCustomerJsonNode = oNewCreditCardNode.get("NewCustomer");
		
		System.out.println(oNewCreditCardNode.get("NewCreditCardDetails"));
		
		Connection conn = null;

		OracleCallableStatement ocStatement = null;
		ResultSet rs = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			String strProcedure = "CALL GET_CREDIT_CARD_INFO(?,?,?)";
			ocStatement = (OracleCallableStatement) conn.prepareCall(strProcedure);
			
			ocStatement.setInt(1, oNewCustomerJsonNode.path("accNo").asInt());
			ocStatement.setString(2, oNewCustomerJsonNode.path("name").asText());
			ocStatement.registerOutParameter(3, OracleTypes.CURSOR);
			
			ocStatement.execute();
			
			ObjectNode ogetNewCreditCardDetailsObjectNode = JsonNodeFactory.instance.objectNode();
			ObjectNode ogetNewCreditCardDetails = ogetNewCreditCardDetailsObjectNode
					.putObject("NewCreditCardResponse");
			
			rs = (ResultSet) ocStatement.getObject(3);
			
			while(rs.next()) {
				
				ogetNewCreditCardDetails.put("accNo", rs.getInt(1));
				ogetNewCreditCardDetails.put("cardNumber", rs.getLong(8));
				ogetNewCreditCardDetails.put("cardType", rs.getString(9));
				ogetNewCreditCardDetails.put("status", rs.getString(12));
				ogetNewCreditCardDetails.put("response", rs.getString(18));
				
			}
			
			System.out.println(ogetNewCreditCardDetailsObjectNode.get("NewCreditCardResponse"));
			
			return ogetNewCreditCardDetailsObjectNode;
			
		} catch (Exception e) {
			// TODO: handle exception
			ex.getIn().setBody(e.getMessage());
		}finally {
			try {

				if (rs != null) {
					rs.close();
				}
				if (ocStatement != null) {
					ocStatement.close();
				}

				if (null != conn)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
				ex.getIn().setBody(e.getMessage());
			}
		}
		return null;
	}
}

package com.dh.middleware.creditcard.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.middleware.creditcard.model.CreditCardRequest;

@Component
public class GetCreditCardDetailsRoute extends RouteBuilder{

	@Override
	public void configure() {
		
		restConfiguration()
		.bindingMode(RestBindingMode.json);
		rest()
		.post("/getdetails")
		.type(CreditCardRequest.class)
//		.outType(getClass())
		.consumes("application/json")
		.to("direct:get-credit-card-details");
		
		from("direct:get-credit-card-details")
		.to("bean:creditCardDAO?method=getCreditCardDetailsFromDB")
		.log("${body}");
		
	}
}

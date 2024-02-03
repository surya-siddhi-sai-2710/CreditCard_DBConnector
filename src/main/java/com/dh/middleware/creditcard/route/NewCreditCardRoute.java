package com.dh.middleware.creditcard.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.middleware.creditcard.model.NewCreditCardRequestBackend;

@Component
public class NewCreditCardRoute extends RouteBuilder{

	@Override
	public void configure() {
		
		restConfiguration()
		.bindingMode(RestBindingMode.json);
		rest()
		.post("/newcreditcard")
		.type(NewCreditCardRequestBackend.class)
//		.outType(NewCreditCardResponse.class)
		.consumes("application/json")
		.to("direct:new-credit-card");
		
		from("direct:new-credit-card")
		.log("${body}")
		
		.to("bean:creditCardService?method=setNewCreditCardRequestBackend")
		.log("${body}")
		
		.to("bean:creditCardService?method=checkCibilScoreAndAge")
		.log("Log3 - ${body}")
		.to("bean:creditCardService?method=assignCardBasedOnSalary")
		.log("log 4- ${body}")
		.to("bean:creditCardService?method=getNewCreditCardEligibility")
		.log("log5- ${body}")
		.to("bean:creditCardService?method=prepareNewCreditCardRequest")
		.log("log6 - ${body}")
		.to("bean:creditCardDAO?method=newCreditCardCustomer")
		.log("Log7 - ${body}")
		.to("bean:creditCardDAO?method=getNewCreditCardDetails")
		.log("Log8 - ${body}")
		.to("bean:creditCardService?method=prepareNewCreditCardResponse")
		
	
		.log("${body}");
	}
}

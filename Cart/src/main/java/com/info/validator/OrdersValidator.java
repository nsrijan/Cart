package com.info.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.info.model.Orders;

@Component
public class OrdersValidator implements Validator {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public boolean supports(Class<?> clazz) {

		return Orders.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		Orders orders = (Orders)obj;
	//	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.name");
		if(!orders.getBuyerEmail().matches(EMAIL_PATTERN)) {
			errors.rejectValue("buyerEmail","Please enter valid email","Please enter valid email");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "buyerName", "buyerName Should not contain any character except - ","buyerName Should not contain any character except - ");
		
		
	}
}

package com.info.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.info.model.CustomerReview;

@Component
public class ReviewValidator implements Validator {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PHONE_PATTERN = "^(?!\\s*$)[0-9\\s]{10}$";
	
	public boolean supports(Class<?> clazz) {

		return CustomerReview.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		CustomerReview customerReview = (CustomerReview)obj;
		
		if(!customerReview.getRemail().matches(EMAIL_PATTERN)) {
			errors.rejectValue("remail","Please enter valid email","Please enter valid email");
		}
		
		if(!customerReview.getRphone().matches(PHONE_PATTERN)) {
			errors.rejectValue("remail","Please enter valid phone No.","Please enter valid phone No.");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remail", "Email is required",
				"Email is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rname", "Name Should not be empty and should not contain any symbolic character",
				"Name Should not be empty and should not contain any symbolic character");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rphone", "Phone No. Should not be empty and should not contain any character",
				"Phone No. Should not be empty and should not contain any character");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rdescription", "Description cannot be empty",
				"Description cannot be empty");
		
		
	}

}

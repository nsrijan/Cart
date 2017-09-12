package com.info.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.info.model.Category;

@Component
public class CategoryValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {

		return Category.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		Category category = (Category)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cname", "Name Should not be empty", "Name Should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cdescription", "Description Should not be empty", "Description Should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cimage", "Image Should not be empty", "Image Should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publish", "publish should be either true or false", "publish should be either true or false");
		
		
		
	}

}

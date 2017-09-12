package com.info.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.info.model.Product;

@Component
public class ProductValidator implements Validator {

	public boolean supports(Class<?> clazz) {

		return Product.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {

		Product product = (Product)obj;

	/*	if (product.getPimages().getSize() == 0) {
			errors.rejectValue("pimages", " Please select a file", " Please select a file");
		}
*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pname", "Name Should not contain any character except - ","Name Should not contain any character except - ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pdescription", "pdescription Should not be empty", "pdescription Should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pprice", "pprice Should not be empty", "pprice Should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pofferprice", "pofferprice Should not be empty", "pofferprice Should not be empty");
	//	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pimages", "pimages Should not be empty", "pimages Should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publish", "Either publish it or unpublish", "Either publish it or unpublish");






	}

}

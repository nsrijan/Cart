package com.info.service;

import java.util.List;

import com.info.model.CustomerReview;

public interface ReviewService {
	
	void addCustomerReview(CustomerReview customerReview);
	List<CustomerReview> getAllReviews();
	Long getTotalReviewRecs();

}

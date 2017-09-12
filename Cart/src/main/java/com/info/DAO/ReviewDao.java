package com.info.DAO;

import java.util.List;

import com.info.model.CustomerReview;

public interface ReviewDao {
	
	void addCustomerReview(CustomerReview customerReview);
	List<CustomerReview> getAllReviews();
	Long getTotalReviewRecs();
	

}

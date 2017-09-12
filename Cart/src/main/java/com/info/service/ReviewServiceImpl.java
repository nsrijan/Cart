package com.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.DAO.ReviewDao;
import com.info.model.CustomerReview;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewDao rdao;
	
	public void addCustomerReview(CustomerReview customerReview) {
		
		rdao.addCustomerReview(customerReview);		
	}

	public List<CustomerReview> getAllReviews() {

		return rdao.getAllReviews();		
	}

	public Long getTotalReviewRecs() {
		
		return rdao.getTotalReviewRecs();
	}

}

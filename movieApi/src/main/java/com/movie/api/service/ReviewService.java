package com.movie.api.service;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.movie.api.document.Movies;
import com.movie.api.document.Reviews;
import com.movie.api.repository.MovieRepo;
import com.movie.api.repository.ReviewRepo;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	// Creating new review
	public Reviews createreview(String reviewBody, String imdbId) {

		Reviews re = reviewRepo.insert(new Reviews(reviewBody));

		
		//Using template to perform update on movie class
		mongoTemplate.update(Movies.class)
			//matching the user input id with the available imdbId
			.matching(Criteria.where("imdbId").is(imdbId))
			//Applying the update
			.apply(new Update().push("reviewIds").value(re))
			.first();

		return re;
	}
}

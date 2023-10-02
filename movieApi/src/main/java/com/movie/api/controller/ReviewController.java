package com.movie.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.api.document.Reviews;
import com.movie.api.service.ReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping("")
	public ResponseEntity<Reviews> createReview(@RequestBody Map<String, String> payload) {

		return new ResponseEntity<Reviews>(reviewService.createreview(payload.get("reviewBody"), payload.get("imdbId")),
				HttpStatus.CREATED);
	}
}

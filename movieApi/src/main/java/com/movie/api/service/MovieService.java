package com.movie.api.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.api.document.Movies;
import com.movie.api.repository.MovieRepo;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepo movieRepo;

	//Getting all movies
	public List<Movies> getAllMovies() {
		List<Movies> findAll = movieRepo.findAll();
		return findAll;
	}
	
	
	//Getting single movie
	public Movies getSingleMovie(String imdbId) {
		 Movies singleMovie = this.movieRepo.findByImdbId(imdbId).orElseThrow(()->new InvalidParameterException("Invalid parameter value: " + imdbId));
		return singleMovie;
	}
	
	
}

package com.movie.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.api.document.Movies;
import com.movie.api.service.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	
	
	//Getting all movies
	@GetMapping("")
	public ResponseEntity<List<Movies>> getAllMovies() {
		List<Movies> allMovies = this.movieService.getAllMovies();
		return ResponseEntity.status(HttpStatus.OK).body(allMovies);
	}
	
	
	
	//Getting single movie
	@GetMapping("/{imdbId}")
	public ResponseEntity<Movies> getSingleMovie(@PathVariable String imdbId ) {
		Movies singleMovie = this.movieService.getSingleMovie(imdbId);
		return ResponseEntity.status(HttpStatus.OK).body(singleMovie);
	}
	
	
	
	//
	
}

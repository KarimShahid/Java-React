package com.movie.api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.api.document.Movies;
import java.util.List;
import java.util.Optional;


public interface MovieRepo extends MongoRepository<Movies, ObjectId>{

	Optional<Movies> findByImdbId(String imdbId);
}

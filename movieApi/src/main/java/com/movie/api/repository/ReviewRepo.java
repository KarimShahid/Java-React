package com.movie.api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.api.document.Reviews;

public interface ReviewRepo extends MongoRepository<Reviews, ObjectId>{

}

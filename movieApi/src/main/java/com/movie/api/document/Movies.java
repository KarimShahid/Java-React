package com.movie.api.document;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "movies")
public class Movies {

	@Id
	private ObjectId id;
	private String imdbId;
	private String title;
	private String releaseDate;
	
	private String trailerDate;
	private String poster;
	private List<String> genres;
	private List<String> backdrops;
	
	@DocumentReference
	private List<Reviews> reviewIds;
}

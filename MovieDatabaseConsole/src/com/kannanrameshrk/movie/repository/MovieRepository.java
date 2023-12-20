package com.kannanrameshrk.movie.repository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kannanrameshrk.movie.dto.Movie;

public class MovieRepository {
	private static  MovieRepository repository;
	 private static final String FILE_PATH = "C:\\Users\\kanna\\git\\MoviesDatabaseConsole\\MovieDatabaseConsole\\src\\movieData.json";
	 private Map<String, Movie> movies;
	 
	private MovieRepository() {
		movies = new HashMap<>();
	}
	
	public static  MovieRepository getInstance() {
		if( repository == null) {
			repository = new  MovieRepository();
		}
		return repository;
	}

	public boolean insertData(Movie movie) {
		 ObjectMapper mapper = new ObjectMapper();
	        mapper.enable(SerializationFeature.INDENT_OUTPUT);
	        try {
	            File file = new File(FILE_PATH);

	            if (!file.exists() || file.length() == 0) {
	                movies.put(movie.getMovieName(), movie);
	            } else {
	                movies = mapper.readValue(file, new TypeReference<Map<String, Movie>>() {});
	                movies.put(movie.getMovieName(), movie);
	            }
	            mapper.writeValue(file, movies);
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	}

	public Movie searchMovieName(String searchMovie) {
		 ObjectMapper mapper = new ObjectMapper();
	        File file = new File(FILE_PATH);

	        try {
	        	Map<String, Movie> movieMap = mapper.readValue(
	        		    file,
	        		    new TypeReference<Map<String, Movie>>() {}
	        		);

	            if (movieMap.containsKey(searchMovie)) {
	                return movieMap.get(searchMovie);
	            } else {
	                return null;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	}
}
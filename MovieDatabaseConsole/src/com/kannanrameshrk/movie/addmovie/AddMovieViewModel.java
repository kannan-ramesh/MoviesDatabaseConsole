package com.kannanrameshrk.movie.addmovie;

import com.kannanrameshrk.movie.dto.Movie;
import com.kannanrameshrk.movie.repository.MovieRepository;

class AddMovieViewModel {
	private  AddMovieView  addmovieview;
	
	public  AddMovieViewModel(AddMovieView addmovieview) {
		this.addmovieview= addmovieview;
	}

	public void validate(Movie movie) {
		boolean actor=actorIsValid(movie.getActor());
		boolean director=directorIsValid(movie.getDirector());
		boolean year=yearIsValid(movie.getYear());
		boolean genre=genreIsValid(movie.getGenre());
		
		if (actor && director && year && genre) {
			if(MovieRepository.getInstance().insertData(movie)) {
        		addmovieview.onSuccess("Successfully insert data..");
        	}else {
        		addmovieview.showError("Failure to stored data");
        	}
        }else {
        	addmovieview.showError("Invalid movie data.");
        }
		
	}

	private boolean genreIsValid(String genre) {
		if(genre != null && !genre.isEmpty() && genre.matches("^[a-zA-Z]+$")) {
			return true;
		}
		 addmovieview.showError("Invalid genres...");
		return false;
	}

	private boolean yearIsValid(int year) {
		 int currentYear = java.time.LocalDate.now().getYear();
	      if(year >= 1900 && year <= currentYear) {
	    	  return true;
	      }
	      addmovieview.showError("Invalid year..year is 4 digit");
	     return false;
	}

	private boolean directorIsValid(String director) {
		if(director != null && !director.isEmpty() && !director.matches(".*\\d.*")) {
			return true;
		}
		addmovieview.showError("Invalid director name..");
		return false;
	}

	private boolean actorIsValid(String actor) {
		if(actor != null && !actor.isEmpty() && !actor.matches(".*\\d.*")) {
			return true;
		}
		addmovieview.showError("Invalid actor name..");
		return false;
	}
}

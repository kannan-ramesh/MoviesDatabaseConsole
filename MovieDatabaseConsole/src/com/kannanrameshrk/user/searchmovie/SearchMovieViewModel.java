package com.kannanrameshrk.user.searchmovie;

import com.kannanrameshrk.movie.dto.Movie;
import com.kannanrameshrk.movie.repository.MovieRepository;

class SearchMovieViewModel {
	private SearchMovieView searchmovieview;
	
	public SearchMovieViewModel(SearchMovieView searchmovieview) {
		this.searchmovieview=searchmovieview;
	}

	public void searchMovie(String searchMovie) {
		Movie movie=MovieRepository.getInstance().searchMovieName(searchMovie);
		
		if(movie==null) {
			searchmovieview.showError("Not Movie Found this data..");
		}else {
			searchmovieview.showMovieDetails(movie);
		}
	}
}

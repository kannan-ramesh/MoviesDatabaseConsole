package com.kannanrameshrk.user.searchmovie;

import java.util.Scanner;

import com.kannanrameshrk.Main;
import com.kannanrameshrk.movie.dto.Movie;

public class SearchMovieView {
	private SearchMovieViewModel searchmovieviewModel;
	
	public SearchMovieView() {
		this.searchmovieviewModel=new SearchMovieViewModel(this);
	}

	@SuppressWarnings("static-access")
	public void start() {
		System.out.println("IMDB User page");
		System.out.println("-----------");
		boolean loop=true;
		while(loop) {
			System.out.println(" 1.Search Movie\n 2.Back");
			@SuppressWarnings("resource")
			Scanner input=new Scanner(System.in);
			
			System.out.println("Enter your option:");
			int choice=input.nextInt();
			input.nextLine();
			switch(choice) {
				case 1:{
					System.out.println("Enter Movie Name:");
					String searchMovie=input.nextLine();
					searchmovieviewModel.searchMovie(searchMovie);
					break;
				}
				case 2:{
					Main main=new Main();
					loop=false;
					main.init();
					break;
				}
				default:{
					System.out.println("Invalid choice..");
					break;
				}
			}
		}
	}

	public void showError(String showErr) {
		System.out.println(showErr);
	}

	public void showMovieDetails(Movie movie) {
		System.out.println("*******************************");
		System.out.println("Movie Name:"+movie.getMovieName());
		System.out.println("Actor     :"+movie.getActor());
		System.out.println("Director  :"+movie.getDirector());
		System.out.println("Year      :"+movie.getYear());
		System.out.println("Genre     :"+movie.getGenre());
		System.out.println("*******************************");
	}

	
}

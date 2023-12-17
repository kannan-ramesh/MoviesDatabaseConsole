package com.kannanrameshrk.movie.dto;

public class Movie {
	private String movieName;
	private String actor;
	private String director;
	private int year;
	private String genre;
	
	
	public Movie(String movieName, String actorName, String directorName, int year, String genre) {
		this.movieName=movieName;
		this.actor=actorName;
		this.director=directorName;
		this.year=year;
		this.genre=genre;
	}
	public Movie() {
	   
	}

	
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
}

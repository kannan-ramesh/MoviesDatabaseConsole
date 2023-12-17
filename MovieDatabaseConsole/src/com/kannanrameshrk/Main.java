package com.kannanrameshrk;

import java.util.Scanner;

import com.kannanrameshrk.movie.addmovie.AddMovieView;
import com.kannanrameshrk.user.searchmovie.SearchMovieView;

public class Main {

	public static void main(String[] args) {
		Main main=new Main();
		main.init();
	}

	public static void init() {
		boolean loop=true;
		while(loop) {
			System.out.println("IMDB Application");
			System.out.println("------------------");
			System.out.println(" 1.Admin\n 2.User\n 3.Exit");
			
			System.out.println("Enter your option:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			input.nextLine();
			switch(choice) {
			case 1:{
				AddMovieView addmovieview=new  AddMovieView();
				addmovieview.start();
				break;
			}
			case 2:{
				SearchMovieView searchmovieview=new SearchMovieView();
				searchmovieview.start();
				break;
			}
			case 3:{
				loop=false;
				break;
			}
			default:{
				System.out.println("Invalid choice");
				break;
			}
			}
		}
	}

}

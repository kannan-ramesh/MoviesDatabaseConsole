package com.kannanrameshrk.movie.addmovie;

import java.util.Scanner;

import com.kannanrameshrk.movie.dto.Movie;

public class AddMovieView {
	private AddMovieViewModel addmovieviewmodel;
	String userName = "kannanramesh";
	String pwd = "12345";

	public AddMovieView() {
		this.addmovieviewmodel = new AddMovieViewModel(this);
	}

	public void start(Scanner input) {
		boolean loop = true;
		while (loop) {
			System.out.println("Admin page...");
			System.out.println("-------------");
			System.out.println("Enter User Name:");
			String uname = input.next();
			System.out.println("Enter Password:");
			String pass = input.next();

			if (uname.equals(userName) && pass.equals(pwd)) {
				System.out.println(" 1.Add Movie\n 2.Back\n");
				System.out.println("Enter your option:");
				int choice = input.nextInt();
				input.nextLine();

				switch (choice) {
				case 1: {

					System.out.println("Enter movie name:");
					String movieName = input.nextLine();
					System.out.print("Enter Actor Name:");
					String actorName = input.nextLine();
					System.out.println("Enter director Name:");
					String directorName = input.nextLine();
					System.out.println("Enter movie year:");
					int year = input.nextInt();
					System.out.println("Enter Movie Genre:");
					String genre = input.next();

					Movie movie = new Movie(movieName, actorName, directorName, year, genre);
					addmovieviewmodel.validate(movie);
					break;
				}
				case 2: {
					loop = false;
					break;
				}
				default: {
					System.out.println("Invalid choice");
					break;
				}
				}
			} else {
				System.out.println("Invalid Username ,Password...");
				return;
			}
		}
	}

	public void showError(String errMessage) {
		System.out.println(errMessage);

	}

	public void onSuccess(String onSucess) {
		System.out.println(onSucess);
	}
}
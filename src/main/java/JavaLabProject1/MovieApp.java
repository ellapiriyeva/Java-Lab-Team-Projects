package JavaLabProject1;

import java.util.Scanner;


public class MovieApp {
    Scanner sc = new Scanner(System.in);
    Movie[] movies = new Movie[0];


    public void resizeMoviesArray(int additionalSize) {
        Movie[] newMovies = new Movie[movies.length + additionalSize];
        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i];
        }
        movies = newMovies;
    }


    public void inputMoviesAndRatings() {
        System.out.println("Input 3 movies:");
        resizeMoviesArray(3); // Ensure this method correctly resizes the movies array.
        for (int i = movies.length - 3; i < movies.length; i++) {
            System.out.print((i + 1) + ". Movie Name: ");
            String name = sc.next();
            double rating;
            while (true) {
                System.out.print("Rating (0-10): ");
                rating = sc.nextDouble();
                if (rating >= 0 && rating <= 10) {
                    break; // Exit the loop if the rating is valid.
                } else {
                    System.out.println("Invalid rating. Please enter a value between 0 and 10.");
                }
            }
            movies[i] = new Movie(name, rating);
        }
    }



    public void inputMoreMoviesAndRatings() {
        System.out.println("How many movies do you want to add?");
        int count = sc.nextInt();
        resizeMoviesArray(count);

        for (int i = movies.length - count; i < movies.length; i++) {
            System.out.print((i + 1) + ". Movie Name: ");
            String name = sc.next();
            System.out.print("Rating(0-10): ");
            double rating = sc.nextDouble();
            movies[i] = new Movie(name, rating);
        }
    }


    public void displayMoviesAndRatings() {
        if (movies.length == 0) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies and Ratings:");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i].name + " - " + movies[i].rating);
        }
    }

    public void calculateAndDisplay() {
        double sum = 0.0;
        Movie[] minRatingMovies;
        Movie[] maxRatingMovies;
        for (int i = 0; i < movies.length; i++) {
            sum += movies[i].rating;
        }
        //Average
        System.out.println("Average: " + sum / movies.length);
        int indexMax = 0, indexMin = 0;
        double max = movies[0].rating, min = movies[0].rating;
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].rating > max) {
                max = movies[i].rating;
                indexMax = i;
                break;
            }
        }
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].rating < min) {
                min = movies[i].rating;
                indexMin = i;
                break;
            }
        }
        System.out.println("The movies with the min rating: ");
        for (int i = indexMin; i < movies.length; i++){
            if (movies[i].rating == movies[indexMin].rating){
                System.out.println("Minimum: " + min + " Name: " + movies[indexMin].name + "\n");
            }
        }
        System.out.println("The movies with the max rating: ");
        for (int i = indexMax; i < movies.length; i++) {
            if (movies[i].rating == movies[indexMax].rating){
                System.out.println("Maximum: " + max + " Name: " + movies[indexMax].name + "\n");
            }
        }

    }



    public void searchMovies() {
        boolean found = false;
        System.out.println("Enter movie name:");
        String name = sc.next();
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].name.equals(name)) {
                found = true;
                System.out.println("Movie Rating: " + movies[i].rating);
            }
        }
        if (!found) {
            System.out.println("Movie Not Found.");
        }
    }

    public void updateRatings() {
        System.out.println("Enter movie name:");
        String name = sc.next();
        boolean found = false;
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].name.equals(name)) {
                movies[i].rating = sc.nextDouble();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Movie Not Found.");
        }
    }
    public void deleteMovies() {
        System.out.println("Enter movie name:");
        String name = sc.next();

        int count = 0;
        for (Movie movie : movies) {
            if (!movie.name.equals(name)) {
                count++;
            }
        }

        Movie[] newMovies = new Movie[count];
        int index = 0;

        for (Movie movie : movies) {
            if (!movie.name.equals(name)) {
                newMovies[index++] = movie;
            }
        }

        movies = newMovies;

        System.out.println("Movies with the name \"" + name + "\" have been deleted.");
    }


    public void sortMovies() {
        for (int i = movies.length - 1; i >= 0; i--) {
            for (int j = movies.length - 1; j >= i + 1; j--) {
                if (movies[i].rating < movies[j].rating) {
                    Movie temp = movies[i];
                    movies[i] = movies[j];
                    movies[j] = temp;
                }
            }
        }
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i].name + " - " + movies[i].rating);
        }
    }

    public static void main(String[] args) {
        MovieApp app = new MovieApp();
        int operand;

        do {
            System.out.println("""
                    Press 1 to input 3 new movies
                    Press 2 to display movies and ratings
                    Press 3 to input more movies
                    Press 4 to find statistics
                    Press 5 to search for a movie
                    Press 6 to update movie ratings
                    Press 7 to delete movie ratings
                    Press 8 to sort movies
                    Press 0 to exit""");
            operand = app.sc.nextInt();
            switch (operand) {
                case 1:
                    app.inputMoviesAndRatings();
                    break;
                case 2:
                    app.displayMoviesAndRatings();
                    break;
                case 3:
                    app.inputMoreMoviesAndRatings();
                    break;
                case 4:
                    app.calculateAndDisplay();
                    break;
                case 5:
                    app.searchMovies();
                    break;
                case 6:
                    app.updateRatings();
                    break;
                case 7:
                    app.deleteMovies();
                    break;
                case 8:
                    app.sortMovies();
                    break;
                case 0:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (operand != 0);
    }
}
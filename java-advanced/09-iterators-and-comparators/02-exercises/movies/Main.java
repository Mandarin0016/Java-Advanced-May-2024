package movies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Movie> movies = new ArrayList<>();

        Movie movie1 = new Movie("Furiosa: A Mad Max Saga", 70, 7.9);
        Movie movie2 = new Movie("Civil War", 2, 7.2);
        Movie movie3 = new Movie("Dune: Part Two", 45, 8.6);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        // За да може списък с обекти да се сортира, тези обекти трябва да бъдат СРАВНИМИ
        // implements Comparable<Клас на обект с който ще сравнявам> -> Сравним
        Collections.sort(movies, new MovieRatingComparator().reversed());

        movies.forEach(System.out::println);
    }
}

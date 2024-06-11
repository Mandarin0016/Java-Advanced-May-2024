package movies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Movie> movies = new ArrayList<>();

        Movie movie1 = new Movie("Furiosa: A Mad Max Saga", 70.00, 7.9);
        Movie movie2 = new Movie("Kingdom of the Planet of the Apes", 2.00, 7.2);
        Movie movie3 = new Movie("Dune: Part Two", 45.00, 9.8);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        // Подреди филмите по бюджет (от филм с най-малък бюджет към филм с най-голям бюджет)
        Collections.sort(movies, new MovieRatingComparator().reversed());

        movies.forEach(System.out::println);
    }
}

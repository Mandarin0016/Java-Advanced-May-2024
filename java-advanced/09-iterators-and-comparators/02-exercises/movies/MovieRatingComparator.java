package movies;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    // Comparator -> Външен клас, с който ние ще може да сравним два обекта от един и същ клас по даден критерии
    // method compare -> начина по който се сравняват двата обекта.
    @Override
    public int compare(Movie firstMovie, Movie secondMovie) {
        return firstMovie.getRating().compareTo(secondMovie.getRating());
    }
}

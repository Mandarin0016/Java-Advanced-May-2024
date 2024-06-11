package movies;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie firstMovie, Movie secondMovie) {

        return firstMovie.getRating().compareTo(secondMovie.getRating());
    }
}

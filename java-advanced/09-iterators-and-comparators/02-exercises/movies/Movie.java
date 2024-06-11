package movies;

// POJO -> Plain old java object
public class Movie implements Comparable<Movie> {

    private String title;
    private Double budget;
    private Double rating;

    public Movie(String title, double budget, double rating) {
        this.title = title;
        this.budget = budget;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public Double getBudget() {
        return budget;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("Movie \"%s\"\n -Cost: %.0f million $\n -Rating: %.1f/10", title, budget, rating);
    }

    // Описвам начина по който тези обекти се сравняват
    @Override
    public int compareTo(Movie otherMovie) {
        // Default compareTo implementation: нарежда във възходящ ред, гогато го използвам за Double, Integer, Float, Long
        // от най-малък бюджет към най-голям
        return this.budget.compareTo(otherMovie.budget);
    }
}

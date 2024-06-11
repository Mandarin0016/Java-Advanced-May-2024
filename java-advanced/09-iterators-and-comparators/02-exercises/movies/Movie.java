package movies;

public class Movie implements Comparable<Movie> {

    private String title;
    private Double budget;
    private Double rating;

    public Movie(String title, Double budget, Double rating) {
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
        return String.format("Title: %s\nCost: %.0f million $\nRating: %.1f/10", title, budget, rating);
    }

    // Описваме начина по който се сравняват два филма
    @Override
    public int compareTo(Movie otherMover) {

        return this.budget.compareTo(otherMover.budget);
    }
}

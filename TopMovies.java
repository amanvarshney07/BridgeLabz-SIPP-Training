import java.util.*;

public class TopMovies {
    record Movie(String title, double rating, int year) {}
    
    static List<Movie> movies = List.of(
        new Movie("Avengers", 8.4, 2019),
        new Movie("Spider-Man", 7.3, 2021),
        new Movie("The Batman", 8.2, 2022),
        new Movie("Dune", 8.0, 2021),
        new Movie("Top Gun", 8.3, 2022),
        new Movie("Black Panther", 7.3, 2018),
        new Movie("Inception", 8.8, 2010),
        new Movie("Interstellar", 8.6, 2014),
        new Movie("Joker", 8.4, 2019),
        new Movie("Parasite", 8.5, 2019)
    );
    
    public static void main(String[] args) {
        movies.stream()
            .filter(m -> m.rating() >= 8.0)
            .sorted(Comparator.comparing(Movie::rating).reversed().thenComparing(Movie::year).reversed())
            .limit(5)
            .forEach(System.out::println);
    }
}
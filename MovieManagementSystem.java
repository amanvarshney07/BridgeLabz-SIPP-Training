import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;
    
    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private Movie head;
    private Movie tail;
    
    public MovieDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("Movie added at beginning successfully!");
    }
    
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("Movie added at end successfully!");
    }
    
    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1) {
            System.out.println("Position should be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        
        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        
        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        
        newMovie.next = current;
        newMovie.prev = current.prev;
        current.prev.next = newMovie;
        current.prev = newMovie;
        
        System.out.println("Movie added at position " + position + " successfully!");
    }
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("Movie list is empty!");
            return;
        }
        
        Movie current = head;
        
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head && current == tail) {
                    head = tail = null;
                }
                else if (current == head) {
                    head = current.next;
                    head.prev = null;
                }
                else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                
                System.out.println("Movie '" + title + "' removed successfully!");
                return;
            }
            current = current.next;
        }
        
        System.out.println("Movie '" + title + "' not found!");
    }
    
    public void searchByDirector(String director) {
        if (head == null) {
            System.out.println("Movie list is empty!");
            return;
        }
        
        Movie current = head;
        boolean found = false;
        
        System.out.println("\n--- Movies by Director: " + director + " ---");
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                displayMovieInfo(current);
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No movies found by director '" + director + "'");
        }
    }
    
    
    public void searchByRating(double rating) {
        if (head == null) {
            System.out.println("Movie list is empty!");
            return;
        }
        
        Movie current = head;
        boolean found = false;
        
        System.out.println("\n--- Movies with Rating: " + rating + " ---");
        while (current != null) {
            if (current.rating == rating) {
                displayMovieInfo(current);
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No movies found with rating " + rating);
        }
    }
    
    public void displayForward() {
        if (head == null) {
            System.out.println("No movie records found!");
            return;
        }
        
        System.out.println("\n--- All Movies (Forward Order) ---");
        Movie current = head;
        int position = 1;
        
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayMovieInfo(current);
            current = current.next;
            position++;
        }
    }
    
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movie records found!");
            return;
        }
        
        System.out.println("\n--- All Movies (Reverse Order) ---");
        Movie current = tail;
        int position = getSize();
        
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayMovieInfo(current);
            current = current.prev;
            position--;
        }
    }
    
    public void updateRating(String title, double newRating) {
        if (head == null) {
            System.out.println("Movie list is empty!");
            return;
        }
        
        Movie current = head;
        
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                double oldRating = current.rating;
                current.rating = newRating;
                System.out.println("Rating updated successfully!");
                System.out.println("Movie: " + title);
                System.out.println("Old Rating: " + oldRating);
                System.out.println("New Rating: " + newRating);
                return;
            }
            current = current.next;
        }
        
        System.out.println("Movie '" + title + "' not found!");
    }

    private void displayMovieInfo(Movie movie) {
        System.out.println("Title: " + movie.title);
        System.out.println("Director: " + movie.director);
        System.out.println("Year: " + movie.year);
        System.out.println("Rating: " + movie.rating);
    }
    

    private int getSize() {
        int count = 0;
        Movie current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Movie Management System ===");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movies by Director");
            System.out.println("6. Search Movies by Rating");
            System.out.println("7. Display All Movies (Forward)");
            System.out.println("8. Display All Movies (Reverse)");
            System.out.println("9. Update Movie Rating");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    scanner.nextLine(); 
                    System.out.print("Enter Movie Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Rating (0.0-10.0): ");
                    double rating = scanner.nextDouble();
                    
                    if (choice == 1) {
                        movieList.addAtBeginning(title, director, year, rating);
                    } else if (choice == 2) {
                        movieList.addAtEnd(title, director, year, rating);
                    } else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        movieList.addAtPosition(title, director, year, rating, position);
                    }
                    break;
                    
                case 4:
                    scanner.nextLine(); 
                    System.out.print("Enter Movie Title to remove: ");
                    String removeTitle = scanner.nextLine();
                    movieList.removeByTitle(removeTitle);
                    break;
                    
                case 5:
                    scanner.nextLine(); 
                    System.out.print("Enter Director name: ");
                    String searchDirector = scanner.nextLine();
                    movieList.searchByDirector(searchDirector);
                    break;
                    
                case 6:
                    System.out.print("Enter Rating to search: ");
                    double searchRating = scanner.nextDouble();
                    movieList.searchByRating(searchRating);
                    break;
                    
                case 7:
                    movieList.displayForward();
                    break;
                    
                case 8:
                    movieList.displayReverse();
                    break;
                    
                case 9:
                    scanner.nextLine(); 
                    System.out.print("Enter Movie Title: ");
                    String updateTitle = scanner.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = scanner.nextDouble();
                    movieList.updateRating(updateTitle, newRating);
                    break;
                    
                case 10:
                    System.out.println("Thank you for using Movie Management System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
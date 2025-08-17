import java.util.Scanner;

class Book {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    Book next;
    Book prev;
    
    public Book(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class LibraryDoublyLinkedList {
    private Book head;
    private Book tail;
    
    public LibraryDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public void addAtBeginning(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        if (findBookById(bookId) != null) {
            System.out.println("Book with ID " + bookId + " already exists!");
            return;
        }
        
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at beginning successfully!");
    }
    
    public void addAtEnd(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        if (findBookById(bookId) != null) {
            System.out.println("Book with ID " + bookId + " already exists!");
            return;
        }
        
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at end successfully!");
    }
    
    public void addAtPosition(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus, int position) {
        if (findBookById(bookId) != null) {
            System.out.println("Book with ID " + bookId + " already exists!");
            return;
        }
        
        if (position < 1) {
            System.out.println("Position should be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }
        
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        Book current = head;
        
        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            addAtEnd(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }
        
        newBook.next = current;
        newBook.prev = current.prev;
        
        if (current.prev != null) {
            current.prev.next = newBook;
        }
        current.prev = newBook;
        
        if (current == head) {
            head = newBook;
        }
        
        System.out.println("Book added at position " + position + " successfully!");
    }
    
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        
        Book current = head;
        
        while (current != null) {
            if (current.bookId == bookId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = current.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                
                System.out.println("Book with ID " + bookId + " removed successfully!");
                return;
            }
            current = current.next;
        }
        
        System.out.println("Book with ID " + bookId + " not found!");
    }
    
    public void searchByTitle(String title) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        
        Book current = head;
        boolean found = false;
        
        System.out.println("\n--- Books with title containing '" + title + "' ---");
        while (current != null) {
            if (current.bookTitle.toLowerCase().contains(title.toLowerCase())) {
                displayBookInfo(current);
                System.out.println("---");
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No books found with title containing '" + title + "'");
        }
    }
    
    public void searchByAuthor(String author) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        
        Book current = head;
        boolean found = false;
        
        System.out.println("\n--- Books by author containing '" + author + "' ---");
        while (current != null) {
            if (current.author.toLowerCase().contains(author.toLowerCase())) {
                displayBookInfo(current);
                System.out.println("---");
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No books found by author containing '" + author + "'");
        }
    }
    
    public void updateAvailabilityStatus(int bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.availabilityStatus = !book.availabilityStatus;
            String status = book.availabilityStatus ? "Available" : "Not Available";
            System.out.println("Availability status updated successfully!");
            System.out.println("Book: " + book.bookTitle);
            System.out.println("New Status: " + status);
        } else {
            System.out.println("Book with ID " + bookId + " not found!");
        }
    }
    
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        
        System.out.println("\n--- All Books (Forward Order) ---");
        Book current = head;
        int position = 1;
        
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayBookInfo(current);
            current = current.next;
            position++;
        }
    }
    
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty!");
            return;
        }
        
        System.out.println("\n--- All Books (Reverse Order) ---");
        Book current = tail;
        int position = countBooks();
        
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayBookInfo(current);
            current = current.prev;
            position--;
        }
    }
    
    public int countBooks() {
        int count = 0;
        Book current = head;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        return count;
    }
    
    public void displayBookCount() {
        int totalBooks = countBooks();
        System.out.println("\nTotal number of books in library: " + totalBooks);
        
        if (totalBooks > 0) {
            int availableBooks = 0;
            int unavailableBooks = 0;
            
            Book current = head;
            while (current != null) {
                if (current.availabilityStatus) {
                    availableBooks++;
                } else {
                    unavailableBooks++;
                }
                current = current.next;
            }
            
            System.out.println("Available books: " + availableBooks);
            System.out.println("Checked out books: " + unavailableBooks);
        }
    }
    
    private void displayBookInfo(Book book) {
        System.out.println("Book ID: " + book.bookId);
        System.out.println("Title: " + book.bookTitle);
        System.out.println("Author: " + book.author);
        System.out.println("Genre: " + book.genre);
        System.out.println("Status: " + (book.availabilityStatus ? "Available" : "Checked Out"));
    }
    
    private Book findBookById(int bookId) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public void displayAvailableBooks() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        
        System.out.println("\n--- Available Books ---");
        Book current = head;
        boolean found = false;
        
        while (current != null) {
            if (current.availabilityStatus) {
                displayBookInfo(current);
                System.out.println("---");
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No books are currently available!");
        }
    }
    
    public void displayCheckedOutBooks() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        
        System.out.println("\n--- Checked Out Books ---");
        Book current = head;
        boolean found = false;
        
        while (current != null) {
            if (!current.availabilityStatus) {
                displayBookInfo(current);
                System.out.println("---");
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No books are currently checked out!");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Specific Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Books by Title");
            System.out.println("6. Search Books by Author");
            System.out.println("7. Update Book Availability");
            System.out.println("8. Display All Books (Forward)");
            System.out.println("9. Display All Books (Reverse)");
            System.out.println("10. Count Total Books");
            System.out.println("11. Display Available Books");
            System.out.println("12. Display Checked Out Books");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Is book available? (true/false): ");
                    boolean availabilityStatus = scanner.nextBoolean();
                    
                    if (choice == 1) {
                        library.addAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
                    } else if (choice == 2) {
                        library.addAtEnd(bookTitle, author, genre, bookId, availabilityStatus);
                    } else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        library.addAtPosition(bookTitle, author, genre, bookId, availabilityStatus, position);
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();
                    library.removeByBookId(removeId);
                    break;
                    
                case 5:
                    scanner.nextLine();
                    System.out.print("Enter Book Title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;
                    
                case 6:
                    scanner.nextLine();
                    System.out.print("Enter Author name to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                    
                case 7:
                    System.out.print("Enter Book ID to toggle availability: ");
                    int updateId = scanner.nextInt();
                    library.updateAvailabilityStatus(updateId);
                    break;
                    
                case 8:
                    library.displayForward();
                    break;
                    
                case 9:
                    library.displayReverse();
                    break;
                    
                case 10:
                    library.displayBookCount();
                    break;
                    
                case 11:
                    library.displayAvailableBooks();
                    break;
                    
                case 12:
                    library.displayCheckedOutBooks();
                    break;
                    
                case 13:
                    System.out.println("Thank you for using Library Management System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
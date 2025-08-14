package Class_and_Object;

public class Books {
	String book_name;
	String writer_name;
	double price;
	public Books(String book_name, String writer_name, double price) {
		this.book_name=book_name;
		this.writer_name=writer_name;
		this.price=price;
	}
	public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title  : " + book_name);
        System.out.println("Author : " + writer_name);
        System.out.println("Price  : ₹" + price);
    }
	public static void main(String args[]) {
		Books books = new Books("song of fire and ice", "George RR Martin",999.0);
		books.displayDetails();
		
		
	}
}

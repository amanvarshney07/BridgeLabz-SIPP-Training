package Constructors_Instance_vs_Class_Variables_Access_Modifier;

public class HotelBooking {
	String guestName;
    String roomType;
    int nights;
    
    public HotelBooking(String guestName, String roomType, int nights ) {
    	this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }
    public void display() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelBooking booking2=new HotelBooking("Aman", "double", 6);
		HotelBooking booking1 = new HotelBooking(); 
		 HotelBooking booking3 = new HotelBooking(booking2); 
		 booking1.display();
	        booking2.display();
	        booking3.display();

	}

}

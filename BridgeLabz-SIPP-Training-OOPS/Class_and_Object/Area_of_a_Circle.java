package Class_and_Object;

public class Area_of_a_Circle {
	double radius;
	public Area_of_a_Circle(double radius) {
		this.radius = radius;
	}
	public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    public void displayDetails() {
        System.out.println("Circle Details:");
        System.out.println("Radius         : " + radius);
        System.out.println("Area           : " + calculateArea());
        System.out.println("Circumference  : " + calculateCircumference());
    }

	
	public static void main(String args[]) {
		Area_of_a_Circle area= new Area_of_a_Circle(7.0);
		area.displayDetails();
		
	}
}

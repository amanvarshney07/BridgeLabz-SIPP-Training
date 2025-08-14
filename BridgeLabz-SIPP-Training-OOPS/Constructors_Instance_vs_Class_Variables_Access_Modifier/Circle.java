package Constructors_Instance_vs_Class_Variables_Access_Modifier;

public class Circle {
	double radius;
	public Circle() {
		
		
	}
	public Circle(double radius) {
        this.radius = radius;
    }
	public void display() {
        double area = Math.PI * radius * radius;
        System.out.println("Radius: " + radius + ", Area: " + area);
    }
	
	public static void main(String[] args) {
        Circle defaultCircle = new Circle(1.0);       
        Circle customCircle = new Circle(5.5);     
        defaultCircle.display();
        customCircle.display();
    }

}

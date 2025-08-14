package Class_and_Object;
import java.util.*;
public class Employee_Details {
	String name;
    int id;
    double salary;
    
    public Employee_Details(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
	public void displayDetails() {
		 System.out.println("Employee Details:");
	        System.out.println("Name   : " + name);
	        System.out.println("ID     : " + id);
	        System.out.println("Salary : ₹" + salary);
	}
	public static void main(String args[]) {
	Employee_Details emp= new Employee_Details("Aman", 218,230000.00);
	emp.displayDetails();

}
}
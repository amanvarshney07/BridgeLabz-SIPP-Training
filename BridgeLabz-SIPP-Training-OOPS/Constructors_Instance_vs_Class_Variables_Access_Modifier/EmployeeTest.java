package Constructors_Instance_vs_Class_Variables_Access_Modifier;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    public void displayManagerInfo() {
        System.out.println("Accessing Employee ID (public): " + employeeID);
        System.out.println("Accessing Department (protected): " + department);
        System.out.println("Team Size: " + teamSize);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "IT", 50000);
        emp1.displayEmployeeInfo();
        emp1.setSalary(55000);
        System.out.println("Updated Salary: ₹" + emp1.getSalary());

        System.out.println("\n--- Manager Info ---");
        Manager mgr = new Manager(201, "HR", 70000, 5);
        mgr.displayEmployeeInfo();
        mgr.displayManagerInfo();
    }
}


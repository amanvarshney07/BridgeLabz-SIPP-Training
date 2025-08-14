package this_static_final_key_words_and_instanceof_operator;

class Employee {
    static String companyName = "Tech Solutions Ltd.";
    static int totalEmployees = 0;

    private String name;
    private final int id;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", 101, "Software Engineer");
        Employee emp2 = new Employee("Jane Smith", 102, "Project Manager");

        if (emp1 instanceof Employee) {
            emp1.displayDetails();
        }

        if (emp2 instanceof Employee) {
            emp2.displayDetails();
        }

        Employee.displayTotalEmployees();
    }
}


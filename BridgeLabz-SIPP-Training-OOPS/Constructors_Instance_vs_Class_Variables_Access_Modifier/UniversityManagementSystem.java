package Constructors_Instance_vs_Class_Variables_Access_Modifier;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    private String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayPGStudentInfo() {
        System.out.println("Postgraduate Student Name (protected access): " + name);
        System.out.println("Specialization: " + specialization);
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Aman", 8.7);
        s1.displayStudentInfo();
        s1.setCGPA(9.1);
        System.out.println("\nUpdated CGPA: " + s1.getCGPA());

        System.out.println("\n--- Postgraduate Student Details ---");
        PostgraduateStudent pg1 = new PostgraduateStudent(201, "jgdthdcg", 9.2, "Computer Science");
        pg1.displayStudentInfo();
        pg1.displayPGStudentInfo();
    }
}


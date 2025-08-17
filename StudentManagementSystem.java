import java.util.Scanner;

class Student{
    int rollNumber;  // Fixed: was "roll no" (invalid variable name)
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList{
    private Student head;
    
    public StudentLinkedList() {
        this.head = null;
    }
    
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
        System.out.println("Student added at beginning successfully!");
    }
    
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        
        if (head == null) {
            head = newStudent;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
        System.out.println("Student added at end successfully!");
    }
    
    public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
        if (position < 1) {
            System.out.println("Position should be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student current = head;
        
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        
        newStudent.next = current.next;
        current.next = newStudent;
        System.out.println("Student added at position " + position + " successfully!");
    }
    
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        // If head node has the roll number to delete
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted successfully!");
            return;
        }
        
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        
        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found!");
        } else {
            current.next = current.next.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted successfully!");
        }
    }
    
    public void searchByRollNumber(int rollNumber) {
        Student current = head;
        int position = 1;
        
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("\n--- Student Found ---");
                System.out.println("Position: " + position);
                System.out.println("Roll Number: " + current.rollNumber);
                System.out.println("Name: " + current.name);
                System.out.println("Age: " + current.age);
                System.out.println("Grade: " + current.grade);
                return;
            }
            current = current.next;
            position++;
        }
        
        System.out.println("Student with Roll Number " + rollNumber + " not found!");
    }
    
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records found!");
            return;
        }
        
        System.out.println("\n--- All Student Records ---");
        Student current = head;
        int position = 1;
        
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            System.out.println("Roll Number: " + current.rollNumber);
            System.out.println("Name: " + current.name);
            System.out.println("Age: " + current.age);
            System.out.println("Grade: " + current.grade);
            current = current.next;
            position++;
        }
    }
    
    public void updateGrade(int rollNumber, String newGrade) {
        Student current = head;
        
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                String oldGrade = current.grade;
                current.grade = newGrade;
                System.out.println("Grade updated successfully!");
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Old Grade: " + oldGrade);
                System.out.println("New Grade: " + newGrade);
                return;
            }
            current = current.next;
        }
        
        System.out.println("Student with Roll Number " + rollNumber + " not found!");
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Specific Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Display All Students");
            System.out.println("7. Update Student Grade");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    
                    if (choice == 1) {
                        studentList.addAtBeginning(rollNumber, name, age, grade);
                    } else if (choice == 2) {
                        studentList.addAtEnd(rollNumber, name, age, grade);
                    } else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        studentList.addAtPosition(rollNumber, name, age, grade, position);
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int deleteRoll = scanner.nextInt();
                    studentList.deleteByRollNumber(deleteRoll);
                    break;
                    
                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = scanner.nextInt();
                    studentList.searchByRollNumber(searchRoll);
                    break;
                    
                case 6:
                    studentList.displayAllStudents();
                    break;
                    
                case 7:
                    System.out.print("Enter Roll Number: ");
                    int updateRoll = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.nextLine();
                    studentList.updateGrade(updateRoll, newGrade);
                    break;
                    
                case 8:
                    System.out.println("Thank you for using Student Management System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
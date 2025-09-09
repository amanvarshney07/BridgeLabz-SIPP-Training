import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;
    
    Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManager {
    private Student head;
    
    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }
    
    public void addAtEnd(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }
    
    public void addAtPosition(int pos, int rollNo, String name, int age, char grade) {
        if (pos == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNo, name, age, grade);
        Student temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }
    
    public void deleteByRollNo(int rollNo) {
        if (head == null) return;
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Student not found");
        }
    }
    
    public void searchByRollNo(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Found: Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }
    
    public void displayAll() {
        if (head == null) {
            System.out.println("No records found");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
    
    public void updateGrade(int rollNo, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }
    
    public static void main(String[] args) {
        StudentRecordManager srm = new StudentRecordManager();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add at beginning\n2. Add at end\n3. Add at position\n4. Delete by Roll No\n5. Search by Roll No\n6. Display all\n7. Update grade\n8. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Roll No: ");
                    int rollNo1 = sc.nextInt();
                    System.out.print("Name: ");
                    String name1 = sc.next();
                    System.out.print("Age: ");
                    int age1 = sc.nextInt();
                    System.out.print("Grade: ");
                    char grade1 = sc.next().charAt(0);
                    srm.addAtBeginning(rollNo1, name1, age1, grade1);
                    break;
                case 2:
                    System.out.print("Roll No: ");
                    int rollNo2 = sc.nextInt();
                    System.out.print("Name: ");
                    String name2 = sc.next();
                    System.out.print("Age: ");
                    int age2 = sc.nextInt();
                    System.out.print("Grade: ");
                    char grade2 = sc.next().charAt(0);
                    srm.addAtEnd(rollNo2, name2, age2, grade2);
                    break;
                case 3:
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Roll No: ");
                    int rollNo3 = sc.nextInt();
                    System.out.print("Name: ");
                    String name3 = sc.next();
                    System.out.print("Age: ");
                    int age3 = sc.nextInt();
                    System.out.print("Grade: ");
                    char grade3 = sc.next().charAt(0);
                    srm.addAtPosition(pos, rollNo3, name3, age3, grade3);
                    break;
                case 4:
                    System.out.print("Roll No to delete: ");
                    int delRoll = sc.nextInt();
                    srm.deleteByRollNo(delRoll);
                    break;
                case 5:
                    System.out.print("Roll No to search: ");
                    int searchRoll = sc.nextInt();
                    srm.searchByRollNo(searchRoll);
                    break;
                case 6:
                    srm.displayAll();
                    break;
                case 7:
                    System.out.print("Roll No: ");
                    int updateRoll = sc.nextInt();
                    System.out.print("New Grade: ");
                    char newGrade = sc.next().charAt(0);
                    srm.updateGrade(updateRoll, newGrade);
                    break;
                case 8:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
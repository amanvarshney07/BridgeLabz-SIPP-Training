package Inheritance;

class Person {
 String name;
 int age;

 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public void showBasicInfo() {
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
 }
}

class Teacher extends Person {
 String subject;

 public Teacher(String name, int age, String subject) {
     super(name, age);
     this.subject = subject;
 }

 public void displayRole() {
     System.out.println("Role: Teacher");
     showBasicInfo();
     System.out.println("Subject: " + subject);
 }
}

class Student extends Person {
 String grade;

 public Student(String name, int age, String grade) {
     super(name, age);
     this.grade = grade;
 }

 public void displayRole() {
     System.out.println("Role: Student");
     showBasicInfo();
     System.out.println("Grade: " + grade);
 }
}

class Staff extends Person {
 String department;

 public Staff(String name, int age, String department) {
     super(name, age);
     this.department = department;
 }

 public void displayRole() {
     System.out.println("Role: Staff");
     showBasicInfo();
     System.out.println("Department: " + department);
 }
}

public class SchoolApp {
 public static void main(String[] args) {
     Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
     Student student = new Student("Ananya", 15, "10th Grade");
     Staff staff = new Staff("Mrs. Verma", 38, "Administration");

     teacher.displayRole();
     System.out.println();
     student.displayRole();
     System.out.println();
     staff.displayRole();
 }
}


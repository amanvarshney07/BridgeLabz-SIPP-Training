package Inheritance;

class jiol{
 String name;
 int id;

 public jiol(String name, int id) {
     this.name = name;
     this.id = id;
 }

 public void showBasicInfo() {
     System.out.println("Name: " + name);
     System.out.println("ID: " + id);
 }
}

interface Worker {
 void performDuties();
}

class Chef extends Person implements Worker {
 String specialty;

 public Chef(String name, int id, String specialty) {
     super(name, id);
     this.specialty = specialty;
 }

 public void performDuties() {
     showBasicInfo();
     System.out.println("Role: Chef");
     System.out.println("Specialty: " + specialty);
     System.out.println("Duties: Prepare meals and manage the kitchen.");
 }
}

class Waiter extends Person implements Worker {
 int tableCount;

 public Waiter(String name, int id, int tableCount) {
     super(name, id);
     this.tableCount = tableCount;
 }

 public void performDuties() {
     showBasicInfo();
     System.out.println("Role: Waiter");
     System.out.println("Tables Assigned: " + tableCount);
     System.out.println("Duties: Serve food and attend to customers.");
 }
}

public class RestaurantApp {
 public static void main(String[] args) {
     Chef chef = new Chef("Raj", 101, "Indian Cuisine");
     Waiter waiter = new Waiter("Priya", 102, 5);

     chef.performDuties();
     System.out.println();
     waiter.performDuties();
 }
}


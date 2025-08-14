package Constructors_Instance_vs_Class_Variables_Access_Modifier;

public class Person {
	String name;
    int age;
     public Person(String name, int age) {
    	 this.name=name;
    	 this.age=age;
    	 
     }
     public Person(Person other) {
    	 this.name=other.name;
    	 this.age=other.age;
    	 
     }
     public void display() {
         System.out.println("Name: " + name + ", Age: " + age);
     }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Person original = new Person("Aman", 21);
	        Person clone = new Person(original);
	        original.display();
	        clone.display();

	}

}

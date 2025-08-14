package Constructors_Instance_vs_Class_Variables_Access_Modifier;

public class Course {
	private String courseName;
	private int duration;
	private double fee;
	
private static String instituteName = "Default Institute";
	
	public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
	
	public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
    }
	 public static void updateInstituteName(String newName) {
	        instituteName = newName;
	    }
	 public static void main(String[] args) {
	        
	        Course.updateInstituteName("TechAcademy");

	        Course course1 = new Course("Java Programming", 12, 5000);
	        Course course2 = new Course("Web Development", 10, 4500);

	        course1.displayCourseDetails();
	        System.out.println();
	        course2.displayCourseDetails();
	    }

}

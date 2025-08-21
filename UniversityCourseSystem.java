abstract class CourseType {
    protected String type;
    protected int maxStudents;
    
    public CourseType(String type, int maxStudents) {
        this.type = type;
        this.maxStudents = maxStudents;
    }
    
    public abstract double calculateGrade(double score);
    public String getType() { return type; }
    public int getMaxStudents() { return maxStudents; }
}

class ExamCourse extends CourseType {
    public ExamCourse() { super("Exam", 100); }
    public double calculateGrade(double score) { return score * 0.9; }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() { super("Assignment", 50); }
    public double calculateGrade(double score) { return score * 0.85 + 5; }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() { super("Research", 20); }
    public double calculateGrade(double score) { return score * 0.95; }
}

class Course<T extends CourseType> {
    private String name;
    private T courseType;
    private java.util.List<String> students;
    
    public Course(String name, T courseType) {
        this.name = name;
        this.courseType = courseType;
        this.students = new java.util.ArrayList<>();
    }
    
    public boolean enroll(String student) {
        if (students.size() < courseType.getMaxStudents()) {
            students.add(student);
            return true;
        }
        return false;
    }
    
    public double getGrade(double score) { return courseType.calculateGrade(score); }
    public String getName() { return name; }
    public T getCourseType() { return courseType; }
    public java.util.List<String> getStudents() { return students; }
    
    public String toString() {
        return name + " (" + courseType.getType() + ") - " + students.size() + "/" + courseType.getMaxStudents();
    }
}

class University {
    public static void showCourses(java.util.List<? extends Course<? extends CourseType>> courses) {
        System.out.println("Courses:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println("  " + course);
        }
    }
    
    public static <T extends CourseType> void enrollStudent(Course<T> course, String student) {
        if (course.enroll(student)) {
            System.out.println(student + " enrolled in " + course.getName());
        } else {
            System.out.println(course.getName() + " is full!");
        }
    }
    
    public static void showGrades(Course<? extends CourseType> course, java.util.Map<String, Double> scores) {
        System.out.println("Grades for " + course.getName() + ":");
        for (String student : course.getStudents()) {
            if (scores.containsKey(student)) {
                double raw = scores.get(student);
                double final_grade = course.getGrade(raw);
                System.out.printf("  %s: %.1f -> %.1f%%\n", student, raw, final_grade);
            }
        }
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        System.out.println("=== University Course System ===\n");
        
        Course<ExamCourse> math = new Course<>("Calculus", new ExamCourse());
        Course<AssignmentCourse> cs = new Course<>("Data Structures", new AssignmentCourse());
        Course<ResearchCourse> physics = new Course<>("Quantum Mechanics", new ResearchCourse());
        
        java.util.List<Course<? extends CourseType>> courses = new java.util.ArrayList<>();
        courses.add(math);
        courses.add(cs);
        courses.add(physics);
        
        University.showCourses(courses);
        
        System.out.println("\nEnrollments:");
        University.enrollStudent(math, "Alice");
        University.enrollStudent(cs, "Bob");
        University.enrollStudent(physics, "Charlie");
        
        System.out.println();
        University.showCourses(courses);
        
        java.util.Map<String, Double> scores = new java.util.HashMap<>();
        scores.put("Alice", 85.0);
        scores.put("Bob", 90.0);
        scores.put("Charlie", 88.0);
        
        System.out.println();
        University.showGrades(math, scores);
        University.showGrades(cs, scores);
        University.showGrades(physics, scores);
    }
}
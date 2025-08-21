abstract class JobRole {
    protected String title;
    protected String[] skills;
    
    public JobRole(String title, String[] skills) {
        this.title = title;
        this.skills = skills;
    }
    
    public abstract double calculateScore(String[] candidateSkills);
    public String getTitle() { return title; }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() { super("Software Engineer", new String[]{"Java", "Python", "Git"}); }
    public double calculateScore(String[] candidateSkills) {
        int matches = 0;
        for (String skill : candidateSkills) {
            for (String required : skills) {
                if (skill.equalsIgnoreCase(required)) matches++;
            }
        }
        return (matches * 100.0) / skills.length;
    }
}

class DataScientist extends JobRole {
    public DataScientist() { super("Data Scientist", new String[]{"Python", "ML", "Statistics"}); }
    public double calculateScore(String[] candidateSkills) {
        int matches = 0;
        for (String skill : candidateSkills) {
            for (String required : skills) {
                if (skill.equalsIgnoreCase(required)) matches++;
            }
        }
        return (matches * 100.0) / skills.length;
    }
}

class ProductManager extends JobRole {
    public ProductManager() { super("Product Manager", new String[]{"Strategy", "Leadership", "Analytics"}); }
    public double calculateScore(String[] candidateSkills) {
        int matches = 0;
        for (String skill : candidateSkills) {
            for (String required : skills) {
                if (skill.equalsIgnoreCase(required)) matches++;
            }
        }
        return (matches * 100.0) / skills.length;
    }
}

class Resume<T extends JobRole> {
    private String name;
    private T jobRole;
    private double score;
    
    public Resume(String name, String[] skills, T jobRole) {
        this.name = name;
        this.jobRole = jobRole;
        this.score = jobRole.calculateScore(skills);
    }
    
    public boolean isQualified() { return score >= 50; }
    public String getName() { return name; }
    public T getJobRole() { return jobRole; }
    public double getScore() { return score; }
    
    public String toString() {
        return name + " (" + jobRole.getTitle() + ") - " + String.format("%.0f", score) + "%";
    }
}

class AIScreening {
    public static <T extends JobRole> Resume<T> screen(String name, String[] skills, T role) {
        return new Resume<>(name, skills, role);
    }
    
    public static void showResults(java.util.List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("Screening Results:");
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("  " + resume + (resume.isQualified() ? " ✓" : " ✗"));
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        System.out.println("=== AI Resume Screening ===\n");
        
        Resume<SoftwareEngineer> r1 = AIScreening.screen("Alice", new String[]{"Java", "Python"}, new SoftwareEngineer());
        Resume<DataScientist> r2 = AIScreening.screen("Bob", new String[]{"Python", "ML"}, new DataScientist());
        Resume<ProductManager> r3 = AIScreening.screen("Carol", new String[]{"Strategy", "Leadership"}, new ProductManager());
        
        java.util.List<Resume<? extends JobRole>> resumes = new java.util.ArrayList<>();
        resumes.add(r1);
        resumes.add(r2);
        resumes.add(r3);
        
        AIScreening.showResults(resumes);
    }
}
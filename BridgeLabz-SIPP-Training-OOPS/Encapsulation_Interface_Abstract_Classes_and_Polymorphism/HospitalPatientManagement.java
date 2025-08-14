package Encapsulation_Interface_Abstract_Classes_and_Polymorphism;

import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private List<String> records;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.records = new ArrayList<>();
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public List<String> viewRecords() {
        return records;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public List<String> viewRecords() {
        return records;
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient p1 = new InPatient(101, "John Doe", 45, 5, 2000);
        Patient p2 = new OutPatient(102, "Jane Smith", 30, 500);

        MedicalRecord mr1 = (MedicalRecord) p1;
        MedicalRecord mr2 = (MedicalRecord) p2;

        mr1.addRecord("Admitted for fever and weakness.");
        mr1.addRecord("Blood test and x-ray done.");
        mr2.addRecord("Routine check-up and consultation.");

        Patient[] patients = {p1, p2};

        for (Patient p : patients) {
            System.out.println("=======================");
            p.getPatientDetails();
            System.out.println("Medical History:");
            MedicalRecord mr = (MedicalRecord) p;
            for (String rec : mr.viewRecords()) {
                System.out.println("- " + rec);
            }
            System.out.println("Total Bill: ₹" + p.calculateBill());
        }
    }
}


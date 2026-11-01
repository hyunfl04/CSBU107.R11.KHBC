import java.util.ArrayList;
import java.util.List;

abstract class Student {
    protected String fullName;
    protected String studentID;
    protected int totalCredits;
    protected double gpa;
    protected String address;

    public Student(String studentID, String fullName, String address, int totalCredits, double gpa) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.address = address;
        this.totalCredits = totalCredits;
        this.gpa = gpa;
    }

    public abstract boolean isEligibleForGraduation();

    public String getFullName() {
        return fullName;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public double getGpa() {
        return gpa;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student Name: " + fullName + "\n" +
               "Student ID: " + studentID + "\n" +
               "Total Credits: " + totalCredits + "\n" +
               "GPA: " + gpa + "\n" +
               "Address: " + address;
    }
}

class CollegeStudent extends Student {
    private final double graduationExamScore; 

    public CollegeStudent(String studentID, String fullName, String address, int totalCredits, double gpa, double graduationExamScore) {
        super(studentID, fullName, address, totalCredits, gpa);
        this.graduationExamScore = graduationExamScore;
    }

    @Override
    public boolean isEligibleForGraduation() {
        return this.totalCredits >= 120 && this.gpa >= 5.0 && this.graduationExamScore >= 5.0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nGraduation Exam Score: " + graduationExamScore;
    }
}

class UniversityStudent extends Student {
    private final String thesisTitle; 
    private final double thesisScore; 

    public UniversityStudent(String studentID, String fullName, String address, int totalCredits, double gpa, String thesisTitle, double thesisScore) {
        super(studentID, fullName, address, totalCredits, gpa);
        this.thesisTitle = thesisTitle;
        this.thesisScore = thesisScore;
    }

    @Override
    public boolean isEligibleForGraduation() {
        return this.totalCredits >= 170 && this.gpa >= 5.0 && this.thesisScore >= 5.0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nThesis Title: " + thesisTitle + "\nThesis Score: " + thesisScore;
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new CollegeStudent("CD01", "John Doe", "New York", 125, 6.5, 7.0));
        students.add(new UniversityStudent("DH01", "Jane Smith", "California", 165, 8.0, "AI Research", 9.0));
        students.add(new UniversityStudent("DH02", "Alex Johnson", "Texas", 175, 8.8, "Cloud Computing", 8.5));

        int graduationCount = 0;
        System.out.println("=== LIST OF GRADUATION-ELIGIBLE STUDENTS ===");
        for (Student student : students) {
            if (student.isEligibleForGraduation()) {
                graduationCount++;
                System.out.println(student);
                System.out.println("-----------------------------------");
            }
        }
        System.out.println("-> Total eligible students: " + graduationCount);
        System.out.println();

        double maxGpa = -1;
        for (Student student : students) {
            if (student instanceof UniversityStudent univStudent) { 
                if (univStudent.getGpa() > maxGpa) {
                    maxGpa = univStudent.getGpa();
                }
            }
        }

        System.out.println("=== UNIVERSITY STUDENT(S) WITH HIGHEST GPA ===");
        if (maxGpa != -1) {
            for (Student student : students) {
                if (student instanceof UniversityStudent univStudent) {
                    if (univStudent.getGpa() == maxGpa) {
                        System.out.println(univStudent);
                        System.out.println("-----------------------------------");
                    }
                }
            }
        } else {
            System.out.println("No university students found in the list.");
        }
    }
}
class UITStudent {
    private String studentId;
    private String fullname;
    private String major;
    private double gpa;
    public UITStudent(String studentId, String fullname, String major, double gpa) {
        this.studentId = studentId;
        this.fullname = fullname;
        this.major = major;
        this.gpa = gpa;
    }
    public UITStudent(String studentId, String fullName){
        this(studentId, fullName, "Undeclared", 0.0);
    }
    public UITStudent(){
        this("Unknown", "Unknown", "Undeclared", 0.0);
    }
    public boolean isPassed(){
        return this.gpa >= 5.0;
    }
    public String academicClassification(){
        if (this.gpa >= 8.0) {
            return "Excellent";
        } else if (this.gpa >= 6.5) {
            return "Good";
        } else if (this.gpa >= 5.0) {
            return "Average";
        } else {
            return "Poor";
        }
    }
    public void displayInfo(){
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Full Name: " + this.fullname);
        System.out.println("Major: " + this.major);
        System.out.println("GPA: " + this.gpa);
        System.out.println("Passed: " + (this.isPassed() ? "Yes" : "No"));
        System.out.println("Academic Classification: " + this.academicClassification());
    }
}
public class Exercise7 {
    public static void main(String[] args) {
        UITStudent student1 = new UITStudent("S001", "Alice", "Computer Science", 8.5);
        UITStudent student2 = new UITStudent("S002", "Bob", "Mathematics", 6.0);
        UITStudent student3 = new UITStudent("S003", "Charlie");
        UITStudent student4 = new UITStudent();

        student1.displayInfo();
        System.out.println();
        student2.displayInfo();
        System.out.println();
        student3.displayInfo();
        System.out.println();
        student4.displayInfo();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Singer {
    protected String fullName;
    protected int yearsOfExperience;
    protected int albumsSold;
    protected int performances;

    public Singer() {}
    public Singer(String fullName, int yearsOfExperience, int albumsSold, int performances) {
        this.fullName = fullName;
        this.yearsOfExperience = yearsOfExperience;
        this.albumsSold = albumsSold;
        this.performances = performances;
    }
    public void input(Scanner scanner){
        System.out.print("Enter full name: ");
        this.fullName = scanner.nextLine();
        System.out.print("Enter years of experience: ");
        this.yearsOfExperience = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter number of albums sold: ");
        this.albumsSold = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter number of performances: ");
        this.performances = Integer.parseInt(scanner.nextLine());
    }
    public abstract double calculateSalary();
    public void display(){
        System.out.printf("Name: %-18s | Exp: %-2d yrs | Albums: %-6d | Shows: %-3d", 
                fullName, yearsOfExperience, albumsSold, performances);
    }
    public String getFullName() {
        return fullName;
    }
}
class RegularSinger extends Singer{
    public RegularSinger(){}
    public RegularSinger(String fullName, int yearsOfExperience, int albumsSold, int performances) {
        super(fullName, yearsOfExperience, albumsSold, performances);
    }
    @Override
    public double calculateSalary(){
        return 3000000.0 
             + (500000.0 * yearsOfExperience) 
             + (1000.0 * albumsSold) 
             + (200000.0 * performances);
    }
    @Override
    public void display(){
        super.display();
        System.out.printf(" | Type: Regular | Salary: %,.0f VND%n", calculateSalary());    
    }
}
class FamousSinger extends Singer{
    private int gameShowsAttended;
    public FamousSinger(){}
    public FamousSinger(String fullName, int yearsOfExperience, int albumsSold, int performances, int gameShowsAttended) {
        super(fullName, yearsOfExperience, albumsSold, performances);
        this.gameShowsAttended = gameShowsAttended;
    }
    @Override
    public void input (Scanner scanner){
        super.input(scanner);
        System.out.print("Enter number of game shows attended: ");
        this.gameShowsAttended = Integer.parseInt(scanner.nextLine());
    }
    @Override
    public double calculateSalary(){
        return 5000000.0 
             + (500000.0 * yearsOfExperience) 
             + (1200.0 * albumsSold) 
             + (500000.0 * performances) 
             + (500000.0 * gameShowsAttended);
    }
    @Override
    public void display(){
        super.display();
        System.out.printf(" | Game Shows: %-2d | Type: Famous  | Salary: %,.0f VND%n", 
                gameShowsAttended, calculateSalary());
    }
}
public class Excercise4{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
        List<Singer> singers = new ArrayList<>();

            System.out.print("Enter total number of singers: ");
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Entering Singer #" + (i + 1) + " ---");
                System.out.println("1. Regular Singer");
                System.out.println("2. Famous Singer");
                System.out.print("Select choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                Singer singer;
                if (choice == 2) {
                    singer = new FamousSinger();
                } else {
                    singer = new RegularSinger();
                }

                singer.input(scanner);
                singers.add(singer);
            }

            if (singers.isEmpty()) {
                System.out.println("\nNo singers were entered.");
                return;
            }

            double totalCompanySalary = 0;
            Singer highestPaidSinger = singers.get(0);

            System.out.println("\n================ LIST OF SINGERS ================");
            for (Singer singer : singers) {
                singer.display();
                double salary = singer.calculateSalary();
                totalCompanySalary += salary;    
                if (salary > highestPaidSinger.calculateSalary()) {
                    highestPaidSinger = singer;
                }
            }
            System.out.println("=================================================");

            System.out.printf("Total Salary Paid by Company: %,.0f VND%n%n", totalCompanySalary);
            System.out.println("=== HIGHEST-PAID SINGER ===");
            highestPaidSinger.display();
            System.out.println("---------------------------");
        }  
    }
}
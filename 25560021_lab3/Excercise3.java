import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Person {
    protected String fullName;
    protected int age;

    public Person() {}

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public void input(Scanner scanner) {
        System.out.print("Enter Full Name: ");
        this.fullName = scanner.nextLine();
        System.out.print("Enter Age: ");
        this.age = Integer.parseInt(scanner.nextLine());
    }

    public void display() {
        System.out.printf("Name: %-18s | Age: %-3d", fullName, age);
    }

    public String getFullName() {
        return fullName;
    }
}

class Guest extends Person {
    private String cccd;

    public Guest() {}

    public Guest(String cccd, String fullName, int age) {
        super(fullName, age);
        this.cccd = cccd;
    }

    @Override
    public void input(Scanner scanner) {
        System.out.print("Enter Citizen ID (CCCD): ");
        this.cccd = scanner.nextLine();
        super.input(scanner);
    }

    @Override
    public void display() {
        System.out.printf("CCCD: %-12s | ", cccd);
        super.display();
        System.out.println();
    }

    public String getCccd() {
        return cccd;
    }
}

class Staff extends Person {
    private final String licenseID;
    private final String employeeID;

    public Staff(String licenseID, String employeeID, String fullName, int age) {
        super(fullName, age);
        this.licenseID = licenseID;
        this.employeeID = employeeID;
    }

    @Override
    public void display() {
        System.out.printf("Emp ID: %-8s | License: %-10s | ", employeeID, licenseID);
        super.display();
        System.out.println();
    }
}

class Room {
    private final String roomType; 
    private final int rentalDays;  
    private final Guest guest;     

    public Room(String roomType, int rentalDays, Guest guest) {
        this.roomType = roomType.toUpperCase();
        this.rentalDays = rentalDays;
        this.guest = guest;
    }

    public double getPricePerDay() {
        return switch (roomType) {
            case "VIP1" -> 900000.0;
            case "VIP2" -> 700000.0;
            case "VIP3" -> 500000.0;
            default -> 0.0;
        };
    }

    public double calculateRentalCost() {
        return getPricePerDay() * rentalDays;
    }

    public Guest getGuest() {
        return guest;
    }

    public void displayInvoice() {
        System.out.println("---------------- INVOICE ----------------");
        guest.display();
        System.out.printf("Room Type: %-5s | Days: %-3d | Total Cost: %,.0f VND%n", 
                roomType, rentalDays, calculateRentalCost());
        System.out.println("-----------------------------------------");
    }
}

public class Excercise3 {
    private final List<Guest> guestList = new ArrayList<>();
    private final List<Room> roomList = new ArrayList<>();
    private final List<Person> peopleList = new ArrayList<>();

    public Excercise3() {
        peopleList.add(new Staff("LIC001", "EMP01", "Manager Alex", 35));
    }

    public void addGuest(Scanner scanner) {
        System.out.println("\n--- ADD NEW GUEST & RENT ROOM ---");
        Guest guest = new Guest();
        guest.input(scanner);
        guestList.add(guest);
        peopleList.add(guest); 
        System.out.print("Enter Room Type (VIP1 / VIP2 / VIP3): ");
        String roomType = scanner.nextLine();
        System.out.print("Enter Number of Rental Days: ");
        int days = Integer.parseInt(scanner.nextLine());

        Room room = new Room(roomType, days, guest);
        roomList.add(room);
        System.out.println("-> Guest registered and room assigned successfully!");
    }

    public void removeGuest(Scanner scanner) {
        System.out.print("\nEnter Citizen ID (CCCD) of guest to remove: ");
        String cccd = scanner.nextLine();

        boolean removedGuest = guestList.removeIf(g -> g.getCccd().equalsIgnoreCase(cccd));
        boolean removedRoom = roomList.removeIf(r -> r.getGuest().getCccd().equalsIgnoreCase(cccd));
        peopleList.removeIf(p -> p instanceof Guest g && g.getCccd().equalsIgnoreCase(cccd));

        if (removedGuest || removedRoom) {
            System.out.println("-> Guest with CCCD [" + cccd + "] removed successfully.");
        } else {
            System.out.println("-> Guest not found.");
        }
    }

    public void displayAllRentals() {
        if (roomList.isEmpty()) {
            System.out.println("\nNo active room rentals found.");
            return;
        }

        System.out.println("\n================ LIST OF HOTEL RENTALS ================");
        double totalRevenue = 0;
        for (Room room : roomList) {
            room.displayInvoice();
            totalRevenue += room.calculateRentalCost();
        }
        System.out.printf("TOTAL HOTEL REVENUE: %,.0f VND%n", totalRevenue);
        System.out.println("=======================================================");
    }

    public void displayAllPeople() {
        System.out.println("\n================ ALL PERSONS IN HOTEL ================");
        for (Person person : peopleList) {
            person.display();
        }
        System.out.println("======================================================");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Excercise3 manager = new Excercise3(); 
            int choice;

            do {
                System.out.println("\n========== HOTEL MANAGEMENT MENU ==========");
                System.out.println("1. Add Guest & Rent Room");
                System.out.println("2. Remove Guest");
                System.out.println("3. Display All Rentals & Total Revenue");
                System.out.println("4. Display All Persons (Staff & Guests)");
                System.out.println("0. Exit");
                System.out.print("Select choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> manager.addGuest(scanner);
                    case 2 -> manager.removeGuest(scanner);
                    case 3 -> manager.displayAllRentals();
                    case 4 -> manager.displayAllPeople();
                    case 0 -> System.out.println("Exiting program...");
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);
        }
    }
}
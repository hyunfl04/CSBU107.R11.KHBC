import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Ticket {
    protected String ticketID;
    protected String holderName;
    protected int yearOfBirth;
    protected int gamesPlayed;

    public Ticket() {}

    public void input(Scanner scanner) {
        System.out.print("Enter Ticket ID: ");
        this.ticketID = scanner.nextLine();
        System.out.print("Enter Holder Name: ");
        this.holderName = scanner.nextLine();
        System.out.print("Enter Year of Birth: ");
        this.yearOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Number of Games Played: ");
        this.gamesPlayed = Integer.parseInt(scanner.nextLine());
    }

    public abstract double calculatePrice();

    public abstract boolean isPartial();

    public void display() {
        System.out.printf("ID: %-8s | Holder: %-15s | Birth Year: %d | Games: %-2d", 
                ticketID, holderName, yearOfBirth, gamesPlayed);
    }
}

class FullPackageTicket extends Ticket {
    @Override
    public double calculatePrice() {
        return 200000.0;
    }

    @Override
    public boolean isPartial() {
        return false;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf(" | Type: Full Package | Price: %,.0f VND%n", calculatePrice());
    }
}

class PartialTicket extends Ticket {
    @Override
    public double calculatePrice() {
        return 70000.0 + (20000.0 * gamesPlayed);
    }

    @Override
    public boolean isPartial() {
        return true;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf(" | Type: Partial      | Price: %,.0f VND%n", calculatePrice());
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
        List<Ticket> tickets = new ArrayList<>();

        System.out.print("Enter total number of tickets: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Entering Ticket #" + (i + 1) + " ---");
            System.out.println("1. Full Package Ticket (200,000 VND)");
            System.out.println("2. Partial Ticket (70,000 VND + 20,000 VND/game)");
            System.out.print("Select choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            Ticket ticket;
            if (choice == 2) {
                ticket = new PartialTicket();
            } else {
                ticket = new FullPackageTicket();
            }

            ticket.input(scanner);
            tickets.add(ticket);
        }

        double totalRevenue = 0;
        int partialTicketCount = 0;

        System.out.println("\n================ TICKET DETAILS ================");
        for (Ticket t : tickets) {
            t.display();
            totalRevenue += t.calculatePrice();
            if (t.isPartial()) {
                partialTicketCount++;
            }
        }
        System.out.println("================================================");

        System.out.println("Total Partial Tickets Sold: " + partialTicketCount);
        System.out.printf("Total Revenue: %,.0f VND%n", totalRevenue);

        scanner.close();
    }
}
}
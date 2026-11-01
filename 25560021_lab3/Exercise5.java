import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    private String customerID;
    private String fullName;
    private String address;
    private String phoneNumber;

    public Customer() {}

    public Customer(String customerID, String fullName, String address, String phoneNumber) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void input(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        this.customerID = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        this.fullName = scanner.nextLine();
        System.out.print("Enter Address: ");
        this.address = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        this.phoneNumber = scanner.nextLine();
    }

    public String getDetails() {
        return String.format("Customer ID: %s | Name: %s | Phone: %s | Address: %s", 
                customerID, fullName, phoneNumber, address);
    }
}

abstract class Product {
    protected String productID;
    protected String name;
    protected int volumeMl;
    protected double unitPricePerMl;

    public Product(String productID, String name, int volumeMl, double unitPricePerMl) {
        this.productID = productID;
        this.name = name;
        this.volumeMl = volumeMl;
        this.unitPricePerMl = unitPricePerMl;
    }

    public double calculatePrice() {
        return volumeMl * unitPricePerMl;
    }

    public String getDetails() {
        return String.format("%s (%d ml) - %,.0f VND", name, volumeMl, calculatePrice());
    }
}

class RosePerfume extends Product {
    public RosePerfume(int volumeMl) {
        super("P01", "Rose Perfume", volumeMl, 20000.0);
    }
}

class ChamomilePerfume extends Product {
    public ChamomilePerfume(int volumeMl) {
        super("P02", "Chamomile Perfume", volumeMl, 15000.0);
    }
}

class DryHairShampoo extends Product {
    public DryHairShampoo(int volumeMl) {
        super("P03", "Dry Hair Shampoo", volumeMl, 20000.0);
    }
}

class OilyHairShampooStd1 extends Product {
    public OilyHairShampooStd1(int volumeMl) {
        super("P04", "Oily Hair Shampoo - Standard 1", volumeMl, 30000.0);
    }
}

class OilyHairShampooStd2 extends Product {
    public OilyHairShampooStd2(int volumeMl) {
        super("P05", "Oily Hair Shampoo - Standard 2", volumeMl, 40000.0);
    }
}

class DrySkinShowerGel extends Product {
    public DrySkinShowerGel(int volumeMl) {
        super("P06", "Dry Skin Shower Gel", volumeMl, 20000.0);
    }
}

class OilySkinShowerGel extends Product {
    public OilySkinShowerGel(int volumeMl) {
        super("P07", "Oily Skin Shower Gel", volumeMl, 40000.0);
    }
}

abstract class Package {
    protected String packageName;
    protected List<Product> products = new ArrayList<>();

    public Package(String packageName) {
        this.packageName = packageName;
    }

    public abstract void inputPackage(Scanner scanner);

    public double calculateTotalPrice() {
        double total = 0;
        for (Product p : products) {
            total += p.calculatePrice();
        }
        return total;
    }

    public String getPackageDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Package Type: ").append(packageName).append("\n  Included Products:\n");
        for (Product p : products) {
            sb.append("   - ").append(p.getDetails()).append("\n");
        }
        sb.append(String.format("  Package Total Price: %,.0f VND", calculateTotalPrice()));
        return sb.toString();
    }
}

class RomanticPackage extends Package {
    public RomanticPackage() {
        super("Romantic Package");
    }

    @Override
    public void inputPackage(Scanner scanner) {
        System.out.println("-> Configuring Romantic Package:");
        
        System.out.print("Enter Rose Perfume volume (ml): ");
        int roseVol = Integer.parseInt(scanner.nextLine());
        products.add(new RosePerfume(roseVol));

        System.out.print("Do you want to add Shampoo? (1: Dry Hair / 2: Oily Std1 / 3: Oily Std2 / 0: No): ");
        int shChoice = Integer.parseInt(scanner.nextLine());
        if (shChoice > 0) {
            System.out.print("Enter Shampoo volume (ml): ");
            int vol = Integer.parseInt(scanner.nextLine());
            switch (shChoice) {
                case 1 -> products.add(new DryHairShampoo(vol));
                case 2 -> products.add(new OilyHairShampooStd1(vol));
                case 3 -> products.add(new OilyHairShampooStd2(vol));
            }
        }

        System.out.print("Do you want to add Shower Gel? (1: Dry Skin / 2: Oily Skin / 0: No): ");
        int sgChoice = Integer.parseInt(scanner.nextLine());
        if (sgChoice > 0) {
            System.out.print("Enter Shower Gel volume (ml): ");
            int vol = Integer.parseInt(scanner.nextLine());
            if (sgChoice == 1) {
                products.add(new DrySkinShowerGel(vol));
            } else if (sgChoice == 2) {
                products.add(new OilySkinShowerGel(vol));
            }
        }
    }
}

class FreshAirPackage extends Package {
    public FreshAirPackage() {
        super("Fresh-Air Package");
    }

    @Override
    public void inputPackage(Scanner scanner) {
        System.out.println("-> Configuring Fresh-Air Package:");

        System.out.print("Select Oily Hair Shampoo (1: Standard 1 / 2: Standard 2): ");
        int shChoice = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Shampoo volume (ml): ");
        int shVol = Integer.parseInt(scanner.nextLine());
        if (shChoice == 2) {
            products.add(new OilyHairShampooStd2(shVol));
        } else {
            products.add(new OilyHairShampooStd1(shVol));
        }

        System.out.print("Do you want to add Perfume? (1: Rose / 2: Chamomile / 0: No): ");
        int pChoice = Integer.parseInt(scanner.nextLine());
        if (pChoice > 0) {
            System.out.print("Enter Perfume volume (ml): ");
            int vol = Integer.parseInt(scanner.nextLine());
            if (pChoice == 1) {
                products.add(new RosePerfume(vol));
            } else if (pChoice == 2) {
                products.add(new ChamomilePerfume(vol));
            }
        }

        System.out.print("Do you want to add Shower Gel? (1: Dry Skin / 2: Oily Skin / 0: No): ");
        int sgChoice = Integer.parseInt(scanner.nextLine());
        if (sgChoice > 0) {
            System.out.print("Enter Shower Gel volume (ml): ");
            int vol = Integer.parseInt(scanner.nextLine());
            if (sgChoice == 1) {
                products.add(new DrySkinShowerGel(vol));
            } else if (sgChoice == 2) {
                products.add(new OilySkinShowerGel(vol));
            }
        }
    }
}

class Order {
    private String orderID;
    private String invoiceDate;
    private Customer customer;
    private Package pkg;

    public Order() {}

    public void inputOrder(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        this.orderID = scanner.nextLine();
        System.out.print("Enter Invoice Date (DD/MM/YYYY): ");
        this.invoiceDate = scanner.nextLine();

        System.out.println("\n[Customer Information]");
        this.customer = new Customer();
        this.customer.input(scanner);

        System.out.println("\n[Select Package Type]");
        System.out.println("1. Romantic Package");
        System.out.println("2. Fresh-Air Package");
        System.out.print("Select choice: ");
        int pChoice = Integer.parseInt(scanner.nextLine());

        if (pChoice == 2) {
            this.pkg = new FreshAirPackage();
        } else {
            this.pkg = new RomanticPackage();
        }
        this.pkg.inputPackage(scanner);
    }

    public double getOrderPrice() {
        return pkg.calculateTotalPrice();
    }

    public String getOrderSummary() {
        String template = """
            ================ ORDER ID: %s ================
            Invoice Date: %s
            %s
            %s
            TOTAL ORDER PRICE: %,.0f VND
            ===============================================""";
        return String.format(template, orderID, invoiceDate, customer.getDetails(), pkg.getPackageDetails(), getOrderPrice());
    
    }
}

public class Exercise5 {
    private static final String FILE_NAME = "order_list.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Order> orders = new ArrayList<>();

            System.out.print("Enter number of orders (N): ");
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\n==============================================");
                System.out.println("        INPUTTING ORDER #" + (i + 1));
                System.out.println("==============================================");
                Order order = new Order();
                order.inputOrder(scanner);
                orders.add(order);
            }

            System.out.println("\n\n##############################################");
            System.out.println("         DISPLAY ALL ORDERS BEFORE SAVING     ");
            System.out.println("##############################################\n");
            for (Order o : orders) {
                System.out.println(o.getOrderSummary());
                System.out.println();
            }

            saveOrdersToFile(orders);
        }
    }

    private static void saveOrdersToFile(List<Order> orders) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Order o : orders) {
                writer.println(o.getOrderSummary());
                writer.println();
            }
            System.out.println("-> Successfully saved all " + orders.size() + " orders to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving orders to file: " + e.getMessage());
        }
    }
}
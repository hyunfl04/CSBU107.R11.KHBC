import java.util.Scanner;
public class E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        for (int i = 0; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "is even");
            } else{
                System.out.println(i + "is odd");
            }
        }
        scanner.close();
    }
}
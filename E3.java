import java.util.Scanner;
public class E3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int sum = 0;
        int remaining = Math.abs(number);

        while (remaining > 0) {
            sum += remaining % 10;
            remaining /= 10;
        }

        System.out.println("The sum of digits is: " + sum);
        scanner.close();
    }

}

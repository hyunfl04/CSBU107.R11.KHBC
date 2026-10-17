import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        String reversedText = "";

        for (int index = text.length() - 1; index >= 0; index--) {
            reversedText += text.charAt(index);
        }

        System.out.println("Reversed string: " + reversedText);

        scanner.close();
    }
}

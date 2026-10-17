import java.util.Scanner;
public class E6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }
        System.out.print("Enter the number to search for: ");
        int x = scanner.nextInt();
        int index = -1;
        for(int i = 0; i < n; i++){
            if(numbers[i]==x){
                index = i;
                break;
            }
        }
        System.out.println(index);
        scanner.close();
    }
}
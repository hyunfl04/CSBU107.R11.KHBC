//BRISTLEBACK'S QUILL SPRAY DAMAGE CALCULATION
import java.util.Scanner;
public class BristlebackQuillSprayDamage {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] time = new double[n];
        for (int i = 0; i < n; i++){
            time[i] = sc.nextDouble();
        }
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();
        double totalDamage = 0;
        int startIndex = 0;
        for (int i = 0; i < n ; i++){
            double currentTime = time[i];
            while (startIndex < i && currentTime > time[startIndex] + z){
                startIndex++;
            }
            int activeQuills = i - startIndex + 1;
            double currentDamage = x + (activeQuills * y);
            totalDamage += currentDamage;
        }
        System.out.println(totalDamage);
        sc.close();
    }
}
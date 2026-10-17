import java.util.Scanner;
public class E7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array 1:");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter the elements of first sorted array:");
        for(int i = 0; i < n; i++){
            arr1[i] = sc.nextInt();
        
        }
        System.out.print("Enter the size of the array 2:");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Enter the elements of second sorted array:");
        for(int j = 0; j < m; j++){
            arr2[j] = sc.nextInt();
            
        }
        int[] mergedArray = new int[n+m];
        int i = 0, j = 0, k = 0;
        while( i < n && j < m){
            if (arr1[i] < arr2[j]){
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        System.out.println("Merged sorted array:");
        while(i < n){
            mergedArray[k++] = arr1[i++];
        }       

        while(j < m){
            mergedArray[k++] = arr2[j++];
        }
        System.out.print("The merged sorted array is: ");
        for(int num : mergedArray){
            System.out.print(num + " ");
        }   
        sc.close();
    }
  
}
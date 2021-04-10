import java.util.Scanner;

public class IncreasingArray {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      long[] arr = new long[n];
      
      for (int i = 0; i < n; i++) {
         arr[i] = scan.nextLong();
      }
      
      long count = 0;
      
      for (int j = 1; j < n; j++) {
         if (arr[j] < arr[j-1]) {
            count += arr[j-1]  - arr[j];
            arr[j] += (arr[j-1]  - arr[j]);
         }
      }   
      
      System.out.println(count);  
   }
}
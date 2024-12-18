import java.util.Scanner;

public class Permutations {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      
      // edge case
      switch (n) {
         case 1 : System.out.println(1);
                  return;
         case 2 :
         case 3 : System.out.println("NO SOLUTION");
                     return;
      }
      
      for (int i = n/2, j = n; i > 0; i--,j--) {
         System.out.print(i + " " + j + " ");
      }
   }
}
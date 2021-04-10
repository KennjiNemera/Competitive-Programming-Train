import java.util.Scanner;

public class Weird {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      Long n = scan.nextLong();
      String output = "";
      output += n + " ";
      
      while (n != 1) {
         if (n % 2 == 0) n /= 2;
         else n = n * 3 + 1;
         output += n + " ";
      } 
      
      System.out.println(output);
   }
}
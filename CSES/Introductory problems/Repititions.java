import java.util.Scanner;

public class Repititions {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      String dna = scan.nextLine();
      int maxCount = 1;
      char curChar = dna.charAt(0); 
      int curCount = 1;
      
      for (int i = 1; i < dna.length(); i++) {
         if (curChar == dna.charAt(i)) {
            curCount++;
         } else {
            curCount = 1;
         }
         curChar = dna.charAt(i);
         maxCount = curCount > maxCount ? curCount : maxCount;
      }
      
      System.out.println(maxCount);
   }
}
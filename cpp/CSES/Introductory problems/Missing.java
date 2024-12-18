import java.util.*;

public class Missing {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int max = scan.nextInt();
      scan.nextLine();
      
      String[] Strarr = scan.nextLine().split(" ");
      
      List<String> temp = Arrays.asList(Strarr);
      
      if (!temp.contains(String.valueOf(max))) {
         System.out.println(max);
         return;
      }
      
      // creating int array to sort the values
      int[] arr = new int[Strarr.length];
      for (int k = 0; k < arr.length; k++) {
         arr[k] = Integer.parseInt(Strarr[k]);
      }  
      
      Arrays.sort(arr);
      
      // check for a difference that isnt one
      for (int i = 0; i < max; i++) {
         if (arr[i] != i+1) {
            System.out.println(i+1);
            return;
         }
      }  
   }   
}
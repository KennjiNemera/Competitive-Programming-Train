import java.io.*;
import java.util.*;

public class PhoneProblems_107B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    TreeMap<Integer, List<String>> taxi = new TreeMap<>();
    TreeMap<Integer, List<String>> pizza = new TreeMap<>();
    TreeMap<Integer, List<String>> girl = new TreeMap<>();

    while (t-- > 0) {
      int n = fr.nextInt();
      String s = fr.next();

      int[] count = new int[3];

      for (int i = 0; i < n; i++) {
        String str = fr.nextLine();
        count[validate(str)]++;
      }

      // System.out.println(s + " " + count[0] + " " + count[1] + " " + count[2]);

      taxi.putIfAbsent(count[0], new ArrayList<>());
      taxi.get(count[0]).add(s);

      pizza.putIfAbsent(count[1], new ArrayList<>());
      pizza.get(count[1]).add(s);

      girl.putIfAbsent(count[2], new ArrayList<>());
      girl.get(count[2]).add(s);
    }

    // print out the best

    StringBuilder taxistr = new StringBuilder("If you want to call a taxi, you should call: ");
    StringBuilder pizzastr = new StringBuilder("If you want to order a pizza, you should call: ");
    StringBuilder girlstr = new StringBuilder("If you want to go to a cafe with a wonderful girl, you should call: ");
    
    // print taxi
    
    int size = taxi.get(taxi.lastKey()).size();
    for (int i = 0; i < size; i++) {
      if (i == size - 1) {
        taxistr.append(taxi.get(taxi.lastKey()).get(i) + ".");
      } else {
        taxistr.append(taxi.get(taxi.lastKey()).get(i) + ", ");
      }
    }

    size = pizza.get(pizza.lastKey()).size();
    for (int i = 0; i < size; i++) {
      if (i == size - 1) {
        pizzastr.append(pizza.get(pizza.lastKey()).get(i) + ".");
      } else {
        pizzastr.append(pizza.get(pizza.lastKey()).get(i) + ", ");
      }
    }

    size = girl.get(girl.lastKey()).size();
    for (int i = 0; i < size; i++) {
      if (i == size - 1) {
        girlstr.append(girl.get(girl.lastKey()).get(i) + ".");
      } else {
        girlstr.append(girl.get(girl.lastKey()).get(i) + ", ");
      }
    }

    pr.println(taxistr.toString());
    pr.println(pizzastr.toString());
    pr.println(girlstr.toString());

    pr.close();
  }

  static int validate(String s) {
    // strings are short enough to brute force it
    s = s.replaceAll("-","");
    if (isTaxi(s)) return 0;
    if (isPizza(s)) return 1;
    else return 2;
  }

  static boolean isTaxi(String s) {
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) != s.charAt(i+1)) return false;
    }
    return true;
  }

  static boolean isPizza(String s) {
    Set<Integer> set = new HashSet<>();
    set.add(toInt(s.charAt(0) + ""));
    for (int i = 0; i < s.length() - 1; i++) {
      if (set.contains(toInt(s.charAt(i+1) + ""))) return false;
      else set.add(toInt(s.charAt(i) + ""));
      if (toInt(s.charAt(i) + "") <= toInt(s.charAt(i+1) + "")) return false;
    }
    return true;
  }

  static class Pair {
      int x, y;
      public Pair(int x, int y) {
          this.x = x;
          this.y = y;
      }
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new InputStreamReader(System.in)); 
      } 

      String next() 
      { 
          while (st == null || !st.hasMoreElements()) 
          { 
              try
              { 
                  st = new StringTokenizer(br.readLine()); 
              } 
              catch (IOException  e) 
              { 
                  e.printStackTrace(); 
              } 
          } 
          return st.nextToken(); 
      } 

      int nextInt() 
      { 
          return Integer.parseInt(next()); 
      } 

      long nextLong() 
      { 
          return Long.parseLong(next()); 
      } 

      double nextDouble() 
      { 
          return Double.parseDouble(next()); 
      } 

      String nextLine() 
      { 
          String str = ""; 
          try
          { 
              str = br.readLine(); 
          } 
          catch (IOException e) 
          { 
              e.printStackTrace(); 
          } 
          return str; 
      } 
  }
}

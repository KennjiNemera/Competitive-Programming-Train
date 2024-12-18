import java.io.*;
import java.util.*;

public class citiesandstates {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("citystate.out")));
    int n = fr.nextInt();
    HashMap<String, Integer> map = new HashMap<>();

    // read in the strings and sort
    for (int i = 0; i < n; i++) {
      String a = fr.next().substring(0, 2);
      String b = fr.next();
      if (a.equals(b)) continue;
      if (!map.containsKey(a + b)) {
        map.put(a + b, 1);
      } else map.put(a+b, map.get(a+b) + 1);
    }

    int ans = 0;
    for (String s : map.keySet()) {
      String otherS = s.substring(2) + s.substring(0, 2);
      if (map.containsKey(otherS)) {
        ans += map.get(s) * map.get(otherS);
      }
    }

    pr.print(ans / 2);
    pr.close();
  }

  static class Pair {
      String name, state;
      public Pair(String x, String y) {
          name = x;
          state = y;
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
          br = new BufferedReader(new FileReader("citystate.in")); 
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

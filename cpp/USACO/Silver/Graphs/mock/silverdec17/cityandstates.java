import java.io.*;
import java.util.*;

public class cityandstates {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("citystate.out")));
    int n = fr.nextInt();
    Map<String, Long> map = new HashMap<>();
    long total = 0;

    for (int i = 0; i < n; i++) {
      String a = fr.next().substring(0, 2);
      String b = fr.next();

      // System.out.println(a + b);

      if (!a.equals(b)) {
        if (!map.containsKey(a + b)) {
          map.put(a + b, (long)0);
        } map.put(a + b, map.get(a + b) + 1);        
      }

    }

    for (Map.Entry<String, Long> a : map.entrySet()) {
      String swap = a.getKey().substring(2) + a.getKey().substring(0, 2);
      if (map.containsKey(swap)) {
        total += map.get(a.getKey()) * map.get(swap);
      }
    }

    pr.println(total / 2);
    pr.close();
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

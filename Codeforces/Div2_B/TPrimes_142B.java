import java.io.*;
import java.util.*;

public class TPrimes_142B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    Map<Long, Boolean> map = new HashMap<>();

    while (n-- > 0) {
      long a = fr.nextLong();
      if (map.containsKey(a)) {
        if (map.get(a)) pr.println("YES");
        else pr.println("NO");
      } else {
        if (Math.sqrt(a) % 1 == 0 && search(a, 0) == 0 && a != 1) {
          map.put(a, true);
          pr.println("YES");
        } else {
          map.put(a, false);
          pr.println("NO");
        }        
      }
    }

    pr.close();
  }

  static int search (long n, int count) {
    for (int i = (int) Math.sqrt(n); i > 1; i--) {
      if (n % i == 0) {
        return count + search(i, count + 1);
      }
    }
    return 0;
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

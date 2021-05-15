import java.io.*;
import java.util.*;

public class AlmostPrime {

  static ArrayList<Integer> temp;
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    temp = new ArrayList<>();
    int ans = 0;

    for (int i = 3; i <= n; i++) {
      temp.clear();
      if (isalmost(i, 0)) {
        ans++;
      }  
    }

    pr.println(ans);
    pr.close();
  }

  static boolean isalmost(int n, int count) {
    if (n <= 1 && count == 2) return true;
    if (n <= 1 && count != 2) return false;
    
    for (int i = 2; i <= n; i++) {
      if (n % i == 0) {
        if (temp.contains(i)) {
          return isalmost(n / i, count);
        } else {
          temp.add(i);
          return isalmost(n / i, count + 1);
        } 
      }
    }

    return false;
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

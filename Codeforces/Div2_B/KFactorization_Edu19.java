import java.io.*;
import java.util.*;

public class KFactorization_Edu19 {

    static ArrayList<Integer> arr = new ArrayList<>();
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int k = fr.nextInt();

    findfactors(n);

    if (arr.size() < k) {
        pr.println(-1);
    } else {
        while (arr.size() > k) {
            int a = arr.remove(0);
            int b = arr.remove(0);
            arr.add(a * b);
        }

        // print out the array
        for (Integer a : arr) {
            pr.print(a + " ");
        }
    }

    pr.close();
  }

  static void findfactors(int n) {
      for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            arr.add(i);
            findfactors(n / i);
            return;
        }
      }

      arr.add(n);
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

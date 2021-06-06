import java.io.*;
import java.util.*;

public class FairNumbers {

  static boolean[] check;
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      long n = fr.nextLong();
      boolean flag = false;

      while (!flag) {

        // base params for each attempt
        String val = String.valueOf(n);
        check = new boolean[10];
        check[0] = true; // 0 gets set to true by default
        flag = true;

        for (int i = 0; i < val.length(); i++) {
          int a = Integer.parseInt(val.charAt(i)+"");
          if (check[a]) continue;
          else {
            if (n % a != 0) {
              n++;
              flag = false;
              break;
            } else check[a] = true;
          }
        }      
        
        if (flag) break;
      }

      pr.println(n);
    }

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

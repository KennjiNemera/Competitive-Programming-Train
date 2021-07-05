import java.io.*;
import java.util.*;

public class ProdThreeNum {

    static ArrayList<Integer> arr = new ArrayList<>();
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
        int n = fr.nextInt();
        arr.clear();
        for (int i = 2; i <= Math.sqrt(n) && arr.size() < 2 ; i++) {
            if (n % i == 0) {
                arr.add(i);
                n /= i;
            }
        }
        
        if (!arr.contains(n) && arr.size() == 2) {
            pr.println("YES");
            String out = arr.get(0) + " " + arr.get(1) + " " + n;
            pr.println(out);
        } else {
            pr.println("NO");
        }
    }

    pr.close();

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

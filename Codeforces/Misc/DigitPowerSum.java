import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class DigitPowerSum {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    ArrayList<BigInteger> arr = new ArrayList<>();

    int ifound = 0;
    BigInteger val = BigInteger.ZERO;

    for (int i = 2; i <= 1000; i++) {
      for (int j = 2; j <= 300; j++) {
        val = BigInteger.valueOf(i).pow(j);
        if (getsum(val) == i) {
          ifound++;
          arr.add(val);
        }
        if (ifound > n) break;
      }
      if (ifound > n) break; 
    } 
    
    Collections.sort(arr);
    for (int i = 0; i < Math.min(n, arr.size()); i++) {
      pr.println(arr.get(i));
    }

    pr.println(arr.size());

    pr.close();
  }

  static int getsum(BigInteger a) {
    int count = 0;
    String b = a.toString();
    for (int i = 0; i < b.length(); i++) {
      count += (int) (b.charAt(i) - '0');
    }
    return count;
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

import java.io.*;
import java.util.*;

public class swap {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("cowdance.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();
    Pair[] arr = new Pair[n];
    Pair[] trans = new Pair[2];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(i, i+1);
    }

    for (int i = 0; i < 2; i++) {
      trans[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    for (int i = 0; i < trans.length; i++) {
      arr = getSwap(arr, trans[i]);
    }


  }

  static Pair[] getSwap(Pair[] a, Pair pair) {
    int offset = pair.x;
    for (int i = pair.x-1; i < pair.y; i++) {
      
    }
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
          br = new BufferedReader(new FileReader("cowdance.in")); 
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

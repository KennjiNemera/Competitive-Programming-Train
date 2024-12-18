import java.io.*;
import java.util.*;
import java.awt.*;

public class billboard {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("billboard.out")));
    Pair[] rect = new Pair[2];

    for (int i = 0; i < 2; i++) {
      rect[i] = new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());
    }

    Pair truck = new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());

    subtract(rect[0], truck);
    subtract(rect[1], truck);

    pr.println(rect[0].area + rect[1].area - subtract(rect[0], truck) - subtract(rect[1], truck));
    pr.close();
  }

  static int subtract(Pair bill, Pair truck) {
    int x = Math.max(0, Math.min(bill.c, truck.c) - Math.max(bill.a, truck.a));
    int y = Math.max(0, Math.min(bill.d, truck.d) - Math.max(bill.b, truck.b));
    return x * y;
  }

  static class Pair implements Comparable<billboard.Pair> {
      int a, b, c, d, area;
      public Pair(int a, int b, int c, int d) {
          this.a = a;
          this.b = b;
          this.c = c;
          this.d = d;
          area = (c-a) * (d-b);
      }
      @Override 
      public int compareTo(Pair o) {
        return a - o.a;
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
          br = new BufferedReader(new FileReader("billboard.in")); 
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

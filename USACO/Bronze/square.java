import java.io.*;
import java.util.*;

public class square {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("square.out")));
    Pair a = new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());
    Pair b = new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());

    int xDif = Math.max(a.c, b.c) - Math.min(a.a, b.a);
    int yDif = Math.max(a.d, b.d) - Math.min(a.b, b.b);

    pr.println((int)Math.pow(Math.max(xDif, yDif), 2));
    pr.close();
  }

  static class Pair {
      int a,b,c,d;
      public Pair(int a, int b, int c, int d) {
          this.a = a;
          this.b = b;
          this.c = c;
          this.d = d;
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
          br = new BufferedReader(new FileReader("square.in")); 
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

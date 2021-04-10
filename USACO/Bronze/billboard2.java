import java.io.*;
import java.util.*;

public class billboard2 {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("billboard.out")));
    Pair a = new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());
    Pair b = new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());

    // Find intersection taking into account that it may stretch into the negative: implement absolute
    int cornercount = 0;
    if (covered(a.a, a.b, b.a, b.b, b.c, b.d)) cornercount++;
    if (covered(a.c, a.b, b.a, b.b, b.c, b.d)) cornercount++;
    if (covered(a.a, a.d, b.a, b.b, b.c, b.d)) cornercount++;
    if (covered(a.c, a.d, b.a, b.b, b.c, b.d)) cornercount++;    

    if (cornercount == 4) {
      pr.println(0);
      pr.close();
      return;
    } else if (cornercount < 2) {
      pr.println(getArea(a));
      pr.close();
    } else {
      int lX = Math.max(a.a, b.a);
      int lY = Math.max(a.b, b.b);
      int hX = Math.min(a.c, b.c);
      int hY = Math.min(a.d, b.d);
      int area = getArea(a) - (hX-lX)*(hY-lY);
      pr.println(area);
      pr.close();
    }
  }

  static boolean covered(int x, int y, int x1, int y1, int x2, int y2) {
    return x >= x1 && x <= x2 && y >= y1 && y <= y2;
  }

  static int getArea(Pair a) {
    return (a.c-a.a) * (a.d-a.b);
  }

  static class Pair {
      int a, b, c, d;
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

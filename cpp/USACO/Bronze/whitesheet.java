import java.io.*;
import java.util.*;

public class whitesheet {

  static Pair intA, intB;
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    Pair w = new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());
    Pair b1 = new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());
    Pair b2 = new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());
    long white = getArea(w);

    Pair wb1 = intersection(w, b1);
    Pair wb2 = intersection(w, b2);
    Pair b1b2 = intersection(b1, b2);

    long blk1 = getArea(wb1);
    long blk2 = getArea(wb2);
    long intersection = getArea(b1b2);

    System.out.println(white + " " + (blk1 + blk2 - intersection));
    if (white > (blk1 + blk2 - intersection)) {
      pr.println("YES");
    } else {
      pr.println("NO");
    }
    pr.close();
  }

  static Pair intersection(Pair a, Pair b) {
    int lg = Math.max(Math.min(a.a, a.c), Math.min(b.a, b.c));
    int hg = Math.min(Math.max(a.a, a.c), Math.max(b.a, b.c)); 
    int up = Math.min(Math.max(a.b, a.d), Math.max(b.b, b.d));
    int down = Math.max(Math.min(a.b, a.d), Math.min(b.b, b.d));
    
    // check that there even is an intersection
    if (hg <= lg || up <= down) return new Pair(0, 0, 0, 0);
    return new Pair(lg, down, hg, up);
  }

  static long getArea(Pair a) {
    return Math.abs(a.c - a.a) * Math.abs(a.d-a.b);
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

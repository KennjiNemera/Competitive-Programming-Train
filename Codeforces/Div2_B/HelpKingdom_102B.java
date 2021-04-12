import java.io.*;
import java.util.*;

public class HelpKingdom_102B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    String s = fr.nextLine();

    boolean neg = s.indexOf("-") != -1;

    int point = s.indexOf(".");

    StringBuilder sb = new StringBuilder();
    if (point == -1) {
      if (neg) sb.append("($");
      else sb.append("$");
      StringBuilder bulk = new StringBuilder();
      if (neg) {
        bulk.append(s.substring(1));
      } else {
        bulk.append(s);
      }
      int add = (bulk.length() / 3);
      int pos = bulk.length() % 3;
      int added = 0;


      // adding commas
      if (bulk.length() - pos >= 3) {
        for (int i = 0; i < add; i++) {
          if (pos != 0) {
            bulk.insert(pos + added, ",");
            added++;
          }
          pos += 3;
        }
      }
      
      sb.append(bulk);
      sb.append(".00");
      if (neg) sb.append(")");
    } else {
      if (neg) sb.append("($");
      else sb.append("$");
      StringBuilder bulk = new StringBuilder();
      if (neg) {
        bulk.append(s.substring(1, point));
      } else bulk.append(s.substring(0, point));

      int add = bulk.length() / 3;
      int pos = bulk.length() % 3;
      int added = 0;
      
      // adding commas
      if (bulk.length() - pos >= 3) {
        for (int i = 0; i < add; i++) {
          if (pos != 0) {
            bulk.insert(pos + added, ",");
            added++;
          }
          pos += 3;
        }
      }

      sb.append(bulk);
      String rem;

      if (s.length() - point - 1 < 2) {
        rem = s.substring(point + 1, point + 2) + "0";
      } else {
        rem = s.substring(point + 1, point + 3);
      }

      sb.append("." + rem);

      if (neg) sb.append(")");
    }

    pr.println(sb.toString());
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

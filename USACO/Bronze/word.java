import java.io.*;
import java.util.*;

public class word {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("word.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();
    StringBuilder sb = new StringBuilder();
    
    while (n-- > 0) {
      String s = fr.next();
      if (sb.length() + s.length() - getSpaces(sb)<= k) {
        if (sb.length() == 0) {
          sb.append(s);
        } else {
          sb.append(" " + s);
        }
      } else {
        pr.println(sb.toString());
        sb = new StringBuilder(s);
      }
    }

    pr.println(sb);

    pr.close();
  }

  static int getSpaces(StringBuilder sb) {
    int count = 0;
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == ' ') count++;
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
          br = new BufferedReader(new FileReader("word.in")); 
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

import java.io.*;
import java.util.*;

public class highcard {
  public static void main(String[] args) throws IOException{  
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("highcard.out")));
    int n = fr.nextInt();

    TreeSet<Integer> elsie = new TreeSet<>();
    TreeSet<Integer> bessie = new TreeSet<>();

    // read into array

    for (int i = 0; i < n; i++) {
      elsie.add(fr.nextInt());
    }

    // update bessie 
    for (int i = 1; i <= 2 * n; i++) {
      if (!elsie.contains(i)) bessie.add(i);
    }

    long count = 0;

    for (Integer i : elsie) {
      if (bessie.higher(i) != null) {
        count++;
        bessie.remove(bessie.higher(i));
      } 
    }

    pr.println(count);
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
          br = new BufferedReader(new FileReader("highcard.in")); 
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

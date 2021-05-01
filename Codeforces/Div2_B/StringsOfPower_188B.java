import java.io.*;
import java.util.*;

public class StringsOfPower_188B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    ArrayList<Integer> heavy = new ArrayList<>();
    ArrayList<Integer> metal = new ArrayList<>();

    String s = fr.nextLine();

    for (int i = 0; i < s.length()-4; i++) {
        if (s.substring(i, i + 5).equals("heavy")) {
            heavy.add(i);
        } else if (s.substring(i, i + 5).equals("metal")) {
            metal.add(i);
        }        
    } 

    long total = 0;
    for (Integer integer : heavy) {
        int invalid = binarysearch(integer, metal);
        if (invalid != -1) {
            total += (metal.size() - invalid - 1);
        } else total += metal.size();
    }

    pr.println(total);
    pr.close();

  }

  static int binarysearch(int n, ArrayList<Integer> target) {
      int lo = 0;
      int hi = target.size()-1;
      int ans = -1;

      while (lo <= hi) {
          int mid = (lo + hi) / 2;
          if (target.get(mid) < n) {
            lo = mid + 1;
            ans = mid;
          } else {
              hi = mid - 1;
          }
      }

      return ans;
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

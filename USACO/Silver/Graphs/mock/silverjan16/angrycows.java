import java.io.*;
import java.util.*;

public class angrycows {

  static TreeSet<Integer> treeset = new TreeSet<>();

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("angry.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();

    for (int i = 0; i < n; i++) {
      treeset.add(fr.nextInt());
    }

    int low = 0;
    int high = 1000000000;
    int ans = -1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (search(mid, k)) {
        ans = mid;
        high = mid - 1;
      } else low = mid + 1;
    }

    pr.println(ans);
    pr.close();
  }

  static boolean search(int r, int k) {
    Integer cur = treeset.first();
    int used = 0;
    while (true) {
      cur = treeset.higher(cur + (2 * r));
      used++;
      if (used > k) return false;
      if (cur == null) break;
    }
    return true;
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
          br = new BufferedReader(new FileReader("angry.in")); 
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

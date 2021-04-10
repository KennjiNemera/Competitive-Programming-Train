import java.io.*;
import java.util.*;

public class subordinates {

  static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  static int n, count;
  static int[] aCount;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();
    StringBuilder sb = new StringBuilder();
    aCount = new int[n];

    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }

    // IO routine 
    for (int i = 0; i < n - 1; i++) {
      int a = fr.nextInt();
      list.get(a-1).add(i + 1);
    }

    // dfs routine
    dfs(0, -1);

    for (int i = 0; i < aCount.length; i++) {
      sb.append((aCount[i]-1) + " ");
    }

    sb.deleteCharAt(sb.length()-1);
    pr.println(sb.toString());
    pr.close();
  }

  static void dfs(int s, int p) {
    aCount[s] = 1;
    for (Integer a : list.get(s)) {
      if (a == p) continue;
      dfs(a, s);
      aCount[s] += aCount[a];
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

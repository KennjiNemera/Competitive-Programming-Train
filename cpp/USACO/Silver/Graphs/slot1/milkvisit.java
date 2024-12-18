import java.io.*;
import java.util.*;

public class milkvisit {

  static ArrayList<Pair> arr;
  static ArrayList<Boolean> vis;
  static int n, m;
  static String result = "";

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("milkvisits.out")));
    n = fr.nextInt();
    m = fr.nextInt();

    arr = new ArrayList<>();
    vis = new ArrayList<>();
    char[] pref = fr.nextLine().toCharArray();

    for (int i = 0; i < n; i++) {
      arr.add(new Pair(i, pref[i]));
      vis.add(false);
    }

    // IO routine build map
    for (int i = 0; i < n-1; i++) {
      int a = fr.nextInt()-1;
      int b = fr.nextInt()-1;

      arr.get(a).neighbours.add(arr.get(b));
      arr.get(a).neighbours.add(arr.get(a));
    }

    // process the queuries
    while (m-- > 0) {
      int a = fr.nextInt()-1;
      int b = fr.nextInt()-1;
      String c = fr.next();
      Collections.fill(vis, false);
      dfs(a, b, c, arr.get(a).c);
    }

    pr.println(result);
    pr.close();
  }

  static void dfs(int n, int b, String target, char found) {
    if (n == b) {
      result += target.equals(found + "") ? "1" : "0";
      return;
    } 
    vis.set(n, true);
    for (Pair pair : arr.get(n).neighbours) {
      char c;
      if ((found + "").equals(target)) c = target.charAt(0); 
      else c = pair.c;
      if (!vis.get(pair.x)) {
        dfs(pair.x, b, target, c);
      }
    }
  }

  static class Pair {
      int x;
      ArrayList<Pair> neighbours;
      char c;
      public Pair(int x, char c) {
          this.x = x;
          this.c = c;
          neighbours = new ArrayList<>();
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
          br = new BufferedReader(new FileReader("milkvisits.in")); 
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

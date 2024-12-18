import java.io.*;
import java.util.*;

public class revegetate {

  static ArrayList<ArrayList<Integer>> S;
  static ArrayList<ArrayList<Integer>> D;
  static int[] vis;
  static int n, m;
  static boolean impossible = false;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("revegetate.out")));
    int n = fr.nextInt();
    int m = fr.nextInt();

    // init structures
    S = new ArrayList<>();
    D = new ArrayList<>();
    vis = new int[n];

    // warm up spots for pastures
    for (int i = 0; i < n; i++) {
      S.add(new ArrayList<>());
      D.add(new ArrayList<>());
    }

    // build connections
    for (int i = 0; i < m; i++) {
      String[] s = fr.nextLine().split(" ");
      int a = toInt(s[1]);
      int b = toInt(s[2]);

      if (s[0].equals("S")) {
        S.get(a-1).add(b-1);
        S.get(b-1).add(a-1);
      } else {
        D.get(a-1).add(b-1);
        D.get(b-1).add(a-1);
      }
    }

    // process cc
    int result = 0;

    for (int i = 0; i < n; i++) {
      if (vis[i] == 0) {
        result++;
        if (impossible) break;
        dfs(i, 1);
      }
    }

    if (impossible) {
      pr.println(0);
    } else {
      pr.print(1);
      for (int i = 0; i < result; i++) {
        pr.print("0");
      }
    }

    pr.close();
  }

  static void dfs(int x, int c) {
    vis[x] = c;
    for (Integer i : S.get(x)) {
      if (vis[i] == 3 - c) {
        impossible = true;
      }

      if (vis[i] == 0) {
        dfs(i, c);
      }
    }

    for (Integer i : D.get(x)) {
      if (vis[i] == c) {
        impossible = true;
      } 

      if (vis[i] == 0) {
        dfs(i, 3 - c);
      }
    }
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
  }


  static class Pasture {
    int index, color;
    ArrayList<Pasture> neighbours;
    public Pasture (int index) {
      this.index = index;
      neighbours = new ArrayList<>();
    } 
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("revegetate.in")); 
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

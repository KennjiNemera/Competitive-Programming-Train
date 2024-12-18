import java.io.*;
import java.util.*;

public class milkvisits {

  static ArrayList<Cow> list = new ArrayList<>();
  static int n, m;
  static int[] comp;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("milkvisits.out")));
    n = fr.nextInt();
    m = fr.nextInt();
    comp = new int[n];
    StringBuilder sb = new StringBuilder(n);

    String s = fr.nextLine();

    // Holstein - 1, Guernsey - 2
    for (int i = 0; i < n; i++) {
      int k = s.charAt(i) == 'H' ? 1 : 2;
      list.add(new Cow(i, k));
    }

    // adjacency list construction
    for (int i = 0; i < n-1; i++) {
      int a = fr.nextInt()-1, b = fr.nextInt()-1;

      list.get(a).neighbours.add(list.get(b));
      list.get(b).neighbours.add(list.get(a));
    }

    // build the components
    int compn = 0;

    for (int i = 0; i < n; i++) {
      if (comp[i] == 0) {
        compn++;
        dfs(i, compn);
      }
    }

    // run over the queries
    for (int i = 0; i < m; i++) {
      int a = fr.nextInt()-1;
      int b = fr.nextInt()-1;
      int c = fr.next().equals("H") ? 1 : 2;

      if (list.get(a).k != list.get(b).k) {
        sb.append("1");
        continue;
      } 

      if (list.get(a).k == c || list.get(b).k == c) {
        sb.append("1");
        continue;
      }

      // check the components
      if (comp[a] != comp[b]) {
        sb.append("1");
        continue;
      }

      sb.append("0");
    }
    pr.println(sb.toString());
    pr.close();
  }

  static void dfs(int n, int p) {
    if (comp[n] != 0) return;
    comp[n] = p;
    for (Cow cow : list.get(n).neighbours) {
      if (cow.k == list.get(n).k) {
        dfs(cow.x, p);
      }
    }
  }

  static class Cow {
      int x, k;
      ArrayList<Cow> neighbours;
      public Cow(int x, int k) {
          this.x = x;
          this.k = k;
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

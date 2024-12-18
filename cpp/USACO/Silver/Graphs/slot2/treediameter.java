import java.io.*;
import java.util.*;

public class treediameter {

  static ArrayList<ArrayList<Integer>> list;
  static int n, m, count, f, fp;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();

    list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());  
    }

    // IO routine
    for (int i = 0; i < n-1; i++) {
      int a = fr.nextInt() - 1, b = fr.nextInt() - 1;
      list.get(a).add(b);
      list.get(b).add(a);
    }

    count = -1;
    bfs(0, -1);
    // System.out.println(f + " " + fp + " " + count);
    count = -1;
    bfs(f, -1);
    // System.out.println(f + " " + fp + " " + count);

    pr.println(count);
    pr.close();
  }

  static void bfs(int a, int c) {
    Queue<Pair> q = new LinkedList<>();

    q.offer(new Pair(a, -1));
    int temp = q.size();

    while (!q.isEmpty()) {
      count++;
      int curCount = 0;
      for (int i = 0; i < temp; i++) {
        Pair polled = q.poll();
        f = polled.x;
        fp = polled.y;
        for (Integer val : list.get(polled.x)) {
          if (val == polled.y) continue;
          q.offer(new Pair(val, polled.x));
          curCount++;
        }
      }
      temp = curCount;
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

import java.io.*;
import java.util.*;

public class PowersOfTwo {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int k = fr.nextInt();

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    // fill in the pq

    for (int i = 0; (1 << i) <= n; i++) {
      int a = n & (1 << i);
      if (a != 0) {
        pq.offer(1<<i);
      }
    }

    if (pq.size() > k) {
      pr.println("NO");
      pr.close();
      return;
    } 

    while (pq.size() < k) {
      int a = pq.poll();
      if (a == 1) break;
      pq.offer(a >> 1);
      pq.offer(a >> 1);
    }

    if (pq.size() < k) {
      pr.println("NO");
      pr.close();
      return;
    }
    
    pr.println("YES");
    StringBuilder sb = new StringBuilder();

    while (!pq.isEmpty()) {
      sb.append(pq.poll() + " ");
    }

    pr.println(sb.toString().trim());
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

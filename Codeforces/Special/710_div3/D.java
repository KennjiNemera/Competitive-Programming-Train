import java.io.*;
import java.util.*;

public class D {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.y - x.y); // sorted in descending order
      Map<Integer, Integer> map = new HashMap<>();

      int n = fr.nextInt();
      int total = n;

      for (int i = 0; i < n; i++) {
        int a = fr.nextInt();
        map.putIfAbsent(a, 0);
        map.put(a, map.get(a) + 1);
      }

      // push these values into the queue
      for (Map.Entry<Integer, Integer> a : map.entrySet()) {
        pq.offer(new Pair(a.getKey(), a.getValue()));
      }

      // continually process the values until there is only 1 element in the queue
      while (pq.size() >= 2) {
        Pair a = pq.poll();
        Pair b = pq.poll();
        
        int aRem = a.y - 1;
        int bRem = b.y - 1;

        // System.out.println(aRem + " " + bRem);

        if (aRem > 0) {
          pq.offer(new Pair(a.x, aRem));
        }
        if (bRem > 0) {
          pq.offer(new Pair(b.x, bRem));
        }

        total -= 2;
      }

      pr.println(total);
    }
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

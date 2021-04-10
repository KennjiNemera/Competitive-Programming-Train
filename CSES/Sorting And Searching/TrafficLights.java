import java.util.*;
import java.io.*;

public class TrafficLights {

  static TreeMap<Integer, Integer> dist = new TreeMap<>();
  public static void main(String[] args) {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int x = fr.nextInt();
    int n = fr.nextInt();
    TreeSet<Integer> set = new TreeSet<>();
    add(x);
    set.add(0);
    set.add(x);
    for (int i = 0; i < n; i++) {
      int a = fr.nextInt();
      set.add(a);
      int it1 = set.higher(a);
      int it2 = set.lower(a);
      remove(it1 - it2);
      add(it1 - a);
      add(a-it2);
      sb.append(dist.lastKey() + " ");
    }   
    pr.write(sb.toString());
    pr.close();
  }

  static void add(int val) {
    if (dist.containsKey(val)) {
      dist.put(val, dist.get(val) + 1);
    } else {
      dist.put(val, 1);
    }
  }

  static void remove(int val) {
    dist.put(val, dist.get(val) - 1);
    if (dist.get(val) == 0) {
      dist.remove(val);
    }
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader()
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
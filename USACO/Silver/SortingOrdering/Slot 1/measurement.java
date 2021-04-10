import java.util.*;
import java.io.*;

public class measurement {

  static TreeMap<Integer, Integer> values = new TreeMap<>((o1, o2) -> o2 - o1); // will sort the map in descending;
  static Map<Integer, Integer> ids = new HashMap<>();
  static int n, g;

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("measurement.out")));
    n = fr.nextInt();
    g = fr.nextInt();
    int a = 0;
    Log[] entries = new Log[n];

    for (int i = 0; i < entries.length; i++) {
      int d, id, c;
      d = fr.nextInt(); id = fr.nextInt(); c = fr.nextInt();
      entries[i] = new Log(d, id, c);
      ids.put(id, 0); //  sets each known cow to a value of 0...
    }

    Arrays.sort(entries);
    values.put(0, n+1 );

    for (int i = 0; i < n; i++) {
      int change = ids.get(entries[i].id);
      boolean wasTop = change == values.firstKey();
      int prevCount = values.get(change);
      values.put(change, values.get(change)-1);
      if (values.get(change) == 0) values.remove(change);
      
      change += entries[i].net;
      ids.put(entries[i].id, change);
      values.put(change, values.getOrDefault(change, 0) + 1);

      boolean isTop = change == values.firstKey();
      int curCount = values.get(change);

      if (wasTop) {
        if (isTop && curCount == prevCount && curCount == 1) continue;
        a++;
      } else if (isTop) {
        a++;
      }
    }

    pr.println(a);
    pr.close();
  }

  static class Log implements Comparable<measurement.Log> {
    int day, id, net;
    public Log (int day, int id, int net) {
      this.day = day;
      this.id = id;
      this.net = net;
    }
    @Override 
    public int compareTo(Log o) {
      return day - o.day;
    }
  }

  
  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("measurement.in")); 
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
import java.io.*;
import java.util.*;

public class A {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      Map<Integer, Integer> map = new HashMap<>();
      ArrayList<Pair> p = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int a = fr.nextInt();
        if (!map.containsKey(a)) {
          p.add(new Pair(a, i + 1));
          map.putIfAbsent(a, 0);
        } 
        map.put(a, map.get(a) + 1);
        for (Pair o : p) {
          if (o.x == a) {
            o.y = i + 1;
          }
        }
      }

      // get elem with one
      for (Map.Entry<Integer, Integer> m : map.entrySet()) {
        if (m.getValue() == 1) {
          for (Pair pair : p) {
            if (pair.x == m.getKey()) {
              pr.println(pair.y);
            }
          }
        }
      }
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

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() throws FileNotFoundException {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}

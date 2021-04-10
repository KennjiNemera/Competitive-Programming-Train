import java.io.*;
import java.util.*;

public class C {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      Set<Integer> set = new HashSet<>();
      Map<Integer, Integer> map = new HashMap<>();
      int prev = fr.nextInt();
      map.put(prev, 0);

      for (int i = 0; i < n - 1; i++) {
        int add = fr.nextInt();
        if (prev != add) {
          map.putIfAbsent(add, 0);
          map.put(add, map.get(add) + 1);
          if (set.contains(add)) {
            set.remove(add);
          } else
            set.add(add);
        }

        prev = add;
      }

      for (Integer a : set) {
        map.put(a, map.get(a) + 1);
      }

      // find the min value in the map
      int min = Integer.MAX_VALUE;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        min = Math.min(min, entry.getValue());
      }

      if (min == Integer.MAX_VALUE) {
        pr.println(0);
      } else pr.println(min);
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

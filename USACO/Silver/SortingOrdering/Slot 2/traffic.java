import java.io.*;
import java.util.*;

public class traffic {

  static TreeSet<Integer> set = new TreeSet<>();
  static TreeMap<Integer, Integer> map = new TreeMap<>();

  // multiset implementation
  static void add(Integer a) {
    if (map.containsKey(a)) {
      map.put(a, map.get(a) + 1);
    } else
      map.put(a, 1);
  }

  static void remove(Integer a) {
    map.put(a, map.get(a) - 1);
    if (map.get(a) == 0) {
      map.remove(a);
    }
  }

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int t = fr.nextInt();

    set.add(0);
    set.add(n);

    add(n);

    while (t-- > 0) {
      int light = fr.nextInt();
      int right = set.higher(light);
      int left = set.lower(light);

      remove(right - left);
      add(right - light);
      add(light - left);

      set.add(light);

      pr.print(map.lastKey() + " ");
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

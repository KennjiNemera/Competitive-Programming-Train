import java.io.*;
import java.util.*;

public class moviefestival {

  static TreeMap<Integer, Integer> map = new TreeMap<>();

  static void add(Integer a) {
    if (map.containsKey(a)) {
      map.put(a, map.get(a) + 1);
    } else
      map.put(a, 1);
  }

  static void remove(Integer e) {
    if (map.get(e) == 0)
      return;
    map.put(e, map.get(e) - 1);
    if (map.get(e) == 0 && e != 0) {
      map.remove(e);
    }
  }

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int k = fr.nextInt();

    map.put(0, k); // initial amount of free watchers

    Pair[] arr = new Pair[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    Arrays.sort(arr);

    long ans = 0;

    for (int i = 0; i < arr.length; i++) {
      int a = arr[i].x;
      int b = arr[i].y;

      int freeMemeber = getLowerKey(a);
      if (map.get(freeMemeber) > 0) { // 27
        remove(freeMemeber);
        ans++;
        add(b);
      }
    }

    pr.println(ans);
    pr.close();

  }

  static int getLowerKey(int a) {
    int curVal = a;
    Map.Entry<Integer, Integer> temp = map.floorEntry(curVal);
    while (curVal >= 0) {
      curVal = map.floorKey(curVal);
      if (curVal == 0) return 0; // prevents null error
      temp = map.floorEntry(curVal);
      if (temp.getValue() > 0) return curVal; // returns the first free member
    }
    return -1;
  }

  static class Pair implements Comparable<moviefestival.Pair> {
    int x, y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
      if (y == o.y) {
        return o.x - x;
      } else
        return y - o.y;
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

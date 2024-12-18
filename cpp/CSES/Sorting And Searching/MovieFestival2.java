import java.util.*;
import java.io.*;

// Unsolved: iterator issues with java making this unnecesarrily difficult.

public class MovieFestival2 {

  static TreeMap<Integer, Integer> multiset = new TreeMap<>();
  static int itValue;
  static int prev = 0;

  static void add(int x) {
    if (multiset.containsKey(x)) {
      multiset.put(x, multiset.get(x) + 1);
    } else
      multiset.put(x, 1);
  }

  static void remove(int x) {
    multiset.put(x, multiset.get(x) - 1);
    if (multiset.get(x) == 0) {
      multiset.remove(x);
    }
  }

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int k = fr.nextInt();
    Pair[] arr = new Pair[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    Arrays.sort(arr);

    // printPair(arr);

    for (int i = 0; i < k; i++) {
      add(0);
    }

    int ans = 0;

    for (int i = 0; i < n; i++) {
      int it = binarySearch(arr[i].x);
      System.out.println("Prev: " + prev);
      System.out.println(it + " --- " + arr[i].x);
      print();

      if (it != -1) {
        if (itValue == multiset.firstKey())
          continue;
      }

      System.out.println("Prev: " + prev);
      if (it == -1)
        remove(multiset.firstKey());
      else
        remove(multiset.get(prev));

      add(arr[i].y);

      ans++;
    }

    pr.print(ans);
    pr.close();
  }

  static void print() {
    System.out.println("--");
    for (Map.Entry<Integer, Integer> m : multiset.entrySet()) {
      System.out.println(m.getKey() + " " + m.getValue());
    }
    System.out.println("--");
  }

  static void printPair(Pair[] arr) {
    for (Pair e : arr) {
      System.out.println(e.x + "-" + e.y);
    }
  }

  static int binarySearch(int x) {
    Object[] arr = multiset.keySet().toArray();
    // System.out.println(Arrays.toString(arr));
    int L = 0;
    int R = multiset.size() - 1;
    int ans = -1;
    while (L <= R) {
      int mid = L + ((R - L) / 2);
      // System.out.println("Arr mid: " + arr[mid]);
      if ((Integer) arr[mid] >= x) {
        ans = mid;
        itValue = (int) arr[mid];
        if (mid > 0)
          prev = (int) arr[mid - 1];
        System.out.println("pREV:" + prev);
        R = mid - 1;
      } else
        L = mid + 1;
    }
    return ans;
  }

  static class Pair implements Comparable<MovieFestival2.Pair> {
    int x, y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
      return y - o.y;
    }
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
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

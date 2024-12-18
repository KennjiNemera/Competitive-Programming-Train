import java.io.*;
import java.util.*;

public class FlightSchedule {

  static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
  static boolean[] vis;
  static long[] dist;
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt(), m = fr.nextInt();

    vis = new boolean[n];
    dist = new long[n];

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
      dist[i] = (long)Math.pow(10, 15);
    }

    for (int i = 0; i < m; i++) {
      int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();

      adj.get(a-1).add(new Pair(b-1, c));
    }

    dist[0] = 0;

    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(new Comp());

    // tuple key
      // 1) Distance to node
      // 2) Current Index
      // 3) Current max on route

    pq.offer(new Tuple(0, 0, 0));

    while (!pq.isEmpty()) {
      Tuple tp = pq.poll();
      if (vis[tp.y]) continue;
      vis[tp.y] = true;

      for (Pair p : adj.get(tp.y)) {
        long temp;
        long max = Math.max(tp.z, p.y); 
        temp = dist[tp.y] + p.y;
        if (p.x == n-1) {
          temp -= max;
          temp += (long)Math.floor(max/2);
        }
        if (temp < dist[p.x]) {
          dist[p.x] = temp;
          pq.offer(new Tuple(dist[p.x], p.x, max));
        }
      }

    }

    pr.println(dist[n-1]);
    pr.close();
    
  }

  static class Pair {
    int x, y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static class Tuple {
    long x, z;
    int y;

    public Tuple(long x, int y, long z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }

  static class Comp implements Comparator<Tuple> {
    public int compare(Tuple a, Tuple b) {
      return Long.compare(a.x, b.x);
    }
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
  }

  // MERGE SORT IMPLEMENTATION
  void sort(int[] arr, int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;

      sort(arr, l, m);
      sort(arr, m + 1, r);

      // call merge
      merge(arr, l, m, r);
    }
  }

  void merge(int[] arr, int l, int m, int r) {
    // find sizes
    int len1 = m - l + 1;
    int len2 = r - m;

    int[] L = new int[len1];
    int[] R = new int[len2];

    // push to copies
    for (int i = 0; i < L.length; i++)
      L[i] = arr[l + i];
    for (int i = 0; i < R.length; i++) {
      R[i] = arr[m + 1 + i];
    }

    // fill in new array
    int i = 0, j = 0;
    int k = l;
    while (i < len1 && j < len2) {
      if (L[i] < R[i]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[i];
        j++;
      }
      k++;
    }

    // add remaining elements
    while (i < len1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < len2) {
      arr[k] = R[j];
      j++;
      k++;
    }
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

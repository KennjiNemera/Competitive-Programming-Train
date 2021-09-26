import java.io.*;
import java.util.*;

public class CycleFinding {

  static int[] par;
  static boolean[] vis;
  static ArrayList<Tuple> adj = new ArrayList<>();
  static ArrayList<Integer> log = new ArrayList<>();
  static int n, m;
  static long[] dist;

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    n = fr.nextInt();
    m = fr.nextInt();

    dist = new long[n];
    vis = new boolean[n];
    par = new int[n];

    long inf = (long) Math.pow(10, 15);

    for (int i = 0; i < n; i++) {
      dist[i] = inf;
      par[i] = -1;
    }

    for (int i = 0; i < m; i++) {
      int a = fr.nextInt() - 1, b = fr.nextInt() - 1, c = fr.nextInt();

      adj.add(new Tuple(a, b, c));
    }

    dist[0] = 0;

    int x = -1;

    for (int i = 0; i < n; i++) {
      x = -1;
      for (Tuple edge : adj) {
        int source = edge.x, target = edge.y, weight = edge.z;

        if (weight > inf)
          continue;

        long temp = dist[source] + weight;

        if (temp < dist[target]) {
          dist[target] = temp;
          // keep track of parents
          par[target] = source;

          x = target;
        }
      }
    }

    if (x == -1) {
      pr.println("NO");
    } else {
      pr.println("YES");

      int y = x;

      for (int i = 0; i < n; i++) {
        y = par[y];
      }

      for (int cur = y;; cur = par[cur]) {
        log.add(cur+1);

        // check that we have completed the cycle
        if (cur == y && log.size() > 1) {
          break;
        }
      }

      Collections.reverse(log);

      StringBuilder sb = new StringBuilder();

      for (Integer a : log) {
        sb.append(a + " ");
      }

      pr.println(sb.toString().trim());
    }



    pr.close();
  }

  static class Tuple {
    int x, y, z;

    public Tuple(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
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

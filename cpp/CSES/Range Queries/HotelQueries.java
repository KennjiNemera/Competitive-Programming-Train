import java.io.*;
import java.util.*;

public class HotelQueries {

  static int n;
  static int[] tree;

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();
    int q = fr.nextInt();

    n = (int) Math.pow(2, Math.ceil(Math.log10(n * 1.0) / Math.log10(2.0)));

    tree = new int[2 * n];
    String[] adj = fr.nextLine().split(" ");

    for (int i = 0; i < adj.length; i++) {
      int a = toInt(adj[i]);
      update(a, i);
    }

    StringBuilder sb = new StringBuilder();
    String[] arr = fr.nextLine().split(" ");

    for (int i = 0; i < q ; i++) {
      int a = toInt(arr[i]);
      int ans = roomsearch(a);

      if (ans != 0) {
        update((int)tree[ans] - a, ans-n);
        sb.append((ans - n + 1) + " ");
      } else {
        sb.append("0 ");
      }
    }

    pr.println(sb.toString().trim());
    pr.close();    
  }

  static int roomsearch(int req) {
    int i = 1;
    boolean found = false;

    while (i < n) {
      if (tree[i] < req)
        return 0;

      found = true;
      if (tree[2 * i] >= req) {
        i *= 2;
      } else {
        i *= 2;
        i++;
      }
    }

    return found ? i : 0;
  }

  static void update(int a, int pos) {
    pos += n;
    tree[pos] = a;
    for (int i = pos / 2; i > 0; i /= 2) {
      tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
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

  void minimumquery(long[][] arr, long[] vals, int n) {

    for (int i = 0; i < arr.length; i++) {
      arr[i][0] = vals[i];
    }

    for (int i = 1; (1 << i) <= n; i++) {
      for (int j = 0; j + (1 << i) - 1 < n; j++) {
        arr[j][i] = Math.min(arr[j][i - 1], arr[j + (1 << (i - 1))][i - 1]);
      }
    }
  }

  int solveExp2(int n) {
    return (int) Math.ceil(Math.log10(n * 1.0) / Math.log10(2 * 1.0));
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

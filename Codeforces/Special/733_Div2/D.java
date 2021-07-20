import java.io.*;
import java.util.*;

public class D {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      ArrayList<Integer> arr = new ArrayList<>();

      boolean[] vis = new boolean[n];
      int[] vals = new int[n];
      int ans = 0;

      for (int i = 0; i < vis.length; i++) {
        int a = fr.nextInt();
        if (vis[a - 1])
          arr.add(i);
        else {
          ans++;
          vis[a - 1] = true;
        }
        vals[i] = a;
      }

      int cur = 0;

      // pr.println(Arrays.toString(vis));
      boolean badcase = false;
      while (arr.size() - cur > 0) {
        int a = arr.get(cur);
        cur++;
        int x = find(vis, a);
        if (x == -1) {
          badcase = true;
          break;
        }
        vals[a] = find(vis, a) + 1;
        vis[vals[a] - 1] = true;
      }

      if (!arr.isEmpty() && badcase) {
        int a = arr.get(arr.size() - 1);
        int target = vals[a];
        int pos = search(vals, target);
        vals[pos] = find(vis, pos) + 1;
      }

      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < vals.length; i++) {
        sb.append(vals[i] + " ");
      }

      pr.println(ans);
      pr.println(sb.toString().trim());
    }

    pr.close();
  }

  static int find(boolean[] arr, int cur) {
    for (int i = 0; i < arr.length; i++) {
      if (!arr[i] && i != cur)
        return i;
    }
    return -1;
  }

  static int search(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target)
        return i;
    }

    return -1;
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

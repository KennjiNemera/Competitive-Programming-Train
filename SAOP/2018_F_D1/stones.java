import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class stones {

  static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
  static int n, m;
  static boolean[][] vis;
  static ArrayList<Pair> stones;
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();
    m = fr.nextInt();
    int q = fr.nextInt();

    long[][] arr = new long[n][m];
    stones = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = fr.nextLong();
        if (arr[i][j] != 0) stones.add(new Pair(i, j, (i + j)));
      }
    }

    Collections.sort(stones, new Comp());

    Queue<Pair> qu;

    while (q-- > 0) {
      int type = fr.nextInt(), i = fr.nextInt(), j = fr.nextInt();
      long k = fr.nextLong();

      if (type == 1) {
        arr[i][j] = (int)k;
      } else {
        long total = 0;
        long dist = 0;
        vis = new boolean[n][m];

        qu = new LinkedList<>();
        qu.offer(new Pair(i, j, 0));

        int curdist = i + j;
        int c = binarySearch(curdist);

        int l = c;
        int r = c;

        total += arr[stones.get(l).x][stones.get(l).y];

        while (isValid(l) || isValid(r) && total < k) {
          int left = Integer.MAX_VALUE;
          int right = left;
          if (isValid(l-1)) left = stones.get(l-1).c;
          if (isValid(r+1)) right = stones.get(r+1).c;
          if (Math.abs(curdist-left) <= Math.abs(curdist-right)) {
            l--;
            Pair a = stones.get(l);
            int rem = (int) Math.min(arr[a.x][a.y], k - total);
            total += rem;
            dist += (2 * rem * Math.abs());
          }
        }

        

        // while (total < k && !qu.isEmpty()) {
        //   Pair p = qu.poll();
        //   vis[p.x][p.y] = true;
        //   int rem = (int) Math.min(arr[p.x][p.y], k - total);
        //   total += rem;
        //   if (rem != 0) dist += (2 * rem * p.c);
        //   for (int[] move : moves) {
        //     int cx = p.x + move[0];
        //     int cy = p.y + move[1];
        //     if (isValid(cx, cy)) {
        //       if (vis[cx][cy]) continue;
        //       qu.offer(new Pair(cx, cy, p.c + 1));
        //       vis[cx][cy] = true;
        //     }
        //   }       
        // }

        if (total >= k) {
          pr.println(dist);
        } else pr.println(-1);
      }
      
    }

    pr.close();

  }

  static int binarySearch(int n) {
    int lo = 0;
    int hi = stones.size()-1;
    int ans = -1;
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      if (stones.get(mid).c >= n) {
        lo = mid + 1;
        ans = mid;
      } else {
        hi = mid - 1;
      }
    }
    return ans;
  }

  static class Comp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
      return Integer.compare(a.c, b.c);
    }
  }

  static boolean isValid(int x) {
    if (x < 0 || x >= stones.size()) return false;
    return true;
  }

  static class Pair {
    int x, y, c;

    public Pair(int x, int y, int c) {
      this.x = x;
      this.y = y;
      this.c = c;
    }
  }

  static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
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

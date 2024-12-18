import java.io.*;
import java.util.*;

public class highscore {

    static int n, m;
    static HashSet<Long> nodes, reverse, init;
    static ArrayList<ArrayList<Pair>> edge;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out)); 
        n = fr.nextInt();
        m = fr.nextInt();
        long inf = (long) -Math.pow(10, 15);

        long[] dist = new long[n];
        edge = new ArrayList<>();

        for (int i = 0; i < n; i++) {
          edge.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
          int a = fr.nextInt()-1, b = fr.nextInt()-1, c = fr.nextInt();
          edge.get(a).add(new Pair(b, c));
        }

        for (int i = 0; i < dist.length; i++) dist[i] = inf;

        dist[0] = 0;

        int count = 0;
        nodes = new HashSet<>();

        for (int i = 0; i < n-1; i++) {
          count = 0;
          nodes.clear();
          for (int j = 0; j < n; j++) {
            for (Pair e : edge.get(j)) {
              int a = j, b = e.x, c = e.y;
              if (dist[b] < dist[a] + c) {
                count++;
                nodes.add((long)b);
                dist[b] = dist[a] + c;
              }
            }            
          }
        }

        if (count != 0) {
          init = new HashSet<>();
          vis = new boolean[n];
          dfs(0,0);
          edge = reverseAdjList(edge);
          vis = new boolean[n];
          reverse = new HashSet<>();
          dfs(n-1,1);
          boolean marked = false;
          for (long l : nodes) {
            if (reverse.contains(l) && init.contains(l)) marked = true;
          }
          if (!marked || n == 2) {
            pr.println(dist[n-1]);
          } else pr.println(-1);
        } else {
          pr.println(dist[n-1]);
        }

        pr.close();
    }

    static void dfs(long p, int a) {
      vis[(int)p] = true;
      if (a == 0) init.add(p);
      else reverse.add(p); 
      for (Pair e : edge.get((int)p)) {
        if (!vis[e.x]) {
          dfs(e.x, a);
        }
      }
    }

    static ArrayList<ArrayList<Pair>> reverseAdjList(ArrayList<ArrayList<Pair>> adj) {
      ArrayList<ArrayList<Pair>> ans = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        ans.add(new ArrayList<>());
      }

      for (int i = 0; i < n; i++) {
        for (Pair edg : adj.get(i)) {
          ans.get(edg.x).add(new Pair(i, edg.y));
        }
      }

      return ans; 
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
        while(i < len1 && j < len2) {
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
            i++;k++;
        }

        while (j < len2) {
            arr[k] = R[j];
            j++; k++;
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

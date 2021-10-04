import java.io.*;
import java.util.*;

public class TreeDistance {

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); 
    static int[] dist;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int n = fr.nextInt();

        for (int i = 0; i < n; i++) {
          arr.add(new ArrayList<>());
        }

        dist = new int[n];

        for (int i = 0; i < n - 1; i++) {
          int a = fr.nextInt() - 1;
          int b = fr.nextInt() - 1;
          
          arr.get(a).add(b);
          arr.get(b).add(a);
        }

        dfs(0, -1);

        ans = new int[n];

        for (int i = 0; i < n; i++) {
          findMax(v, p);
        }

        pr.println(Arrays.toString(dist));
        pr.close();        
    }

    static void findMax(int v, int p) {
      int ans = dist[v];

      int max = 0;
      for (Integer par : arr.get(v)) {
        if (par != v) {
          max = Math.max(max, dist[par]);
        }
      }

      ans += max;

      dist
    }

    static void dfs(int v, int p) {
      if (arr.get(v).size() == 0) {
        dist[v] = 1;
      }
      int max = 0;
      for (Integer child : arr.get(v)) {
        if (child != p) {
          dfs(child, v);
          max = Math.max(max, dist[child]);
        }
      }
      dist[v] = max + 1;
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

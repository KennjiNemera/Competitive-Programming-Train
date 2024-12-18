import java.io.*;
import java.util.*;

public class ShortestPaths1 {

    static int n, m;
    static ArrayList<ArrayList<Pair>> adj;
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        n = fr.nextInt();
        m = fr.nextInt();

        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
          adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
          int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();

          adj.get(a-1).add(new Pair(b,c));
        }

        long[] dist = new long[n];

        dist[0] = 0;
        for (int i = 1; i < n; i++) dist[i] = Long.MAX_VALUE;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());

        pq.offer(new Pair(1, 0));
        boolean[] vis = new boolean[n];

        while (!pq.isEmpty()) {
            int a = pq.peek().b; 
            pq.poll();

            if (vis[a-1]) continue;
            vis[a-1] = true;

            for (Pair p : adj.get(a-1)) {
                int b = p.b;    
                long w = p.w;
                if (dist[a-1] + w < dist[b-1]) {
                    dist[b-1] = dist[a-1] + w;
                    pq.offer(new Pair(b, dist[b-1]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (long l : dist) {
            sb.append(l + " ");
        }

        pr.println(sb.toString().trim());
        pr.close();
    }

    static class Comp implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return Long.compare(a.w, b.w);
        }
    }

    static class Pair {
        int b;
        long w;

        public Pair(int b, long w) {
            this.b = b;
            this.w = w;
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

import java.io.*;
import java.util.*;

public class MessageRoute2 {

    static ArrayList<ArrayList<Integer>> mem;
    static ArrayList<Boolean> vis; 
    static ArrayList<Integer> parent; 
    
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int n = fr.nextInt(), m = fr.nextInt();

        mem = new ArrayList<>();
        vis = new ArrayList<>();
        parent = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            mem.add(new ArrayList<>());
            vis.add(false);
            parent.add(-1);
        }

        for (int i = 0; i < m; i++) {
            int a = fr.nextInt(), b = fr.nextInt();

            // 2 way connection
            mem.get(a-1).add(b);
            mem.get(b-1).add(a);
        }

        bfs(n);

        if (parent.get(n-1) == -1) {
            pr.println("IMPOSSIBLE");
        } else {
            // path-retrieval with stack
            StringBuilder sb = new StringBuilder();
            Stack<Integer> st = new Stack<>();

            int curnode = n;
            st.add(curnode);

            while (parent.get(curnode-1) != -1) {
                int p = parent.get(curnode-1);
                st.add(p);
                curnode = p;
            }

            pr.println(st.size());

            while (!st.isEmpty()) sb.append(st.pop() + " ");
            pr.print(sb.toString().trim());
        }

        pr.close();
    }

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis.set(0, true);
        while (!q.isEmpty()) {
            Integer polled = q.poll();
            for (Integer i : mem.get(polled-1)) {
                // base case
                if (i == n) {
                    vis.set(i-1, true);
                    parent.set(i-1, polled);
                    return;
                }
                // continued search
                if (!vis.get(i-1)) {
                    vis.set(i-1, true);
                    parent.set(i-1, polled);
                    q.offer(i);
                }
            }
        }

        // queue is 1-indexed, vis is 0-indexed, parent is 0-indexed
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

import java.io.*;
import java.util.*;

public class FenwickGrid {

    static long[][] tree;
    static int n;
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

        n = fr.nextInt();
        int q = fr.nextInt();

        tree = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long val = fr.nextLong();
                update(i, j, val);
            }    
        }

        while (q-- > 0) {
            int ax = fr.nextInt();
            int ay = fr.nextInt();
            int bx = fr.nextInt();
            int by = fr.nextInt();

            long a = getSum(bx, by), b = getSum(ax-1, by), c = getSum(bx, ay-1), d = getSum(ax-1, ay-1);

            pr.println(a - b - c + d);
        }

        pr.close();
    }

    static void update(int x, int y, long val) {
        for (int a = x;a <= n; a += (a & -a)) {
            for (int b = y; b <= n; b += (b & -b)) {
                tree[a][b] += val;
            }
        }
    }
    
    static long getSum(int x, int y) {
        long ans = 0;

        for (int i = x; i > 0; i -= (i & -i)) {
            for (int j = y; j > 0; j -= (j & -j)) {
                ans += tree[i][j];
            }
        }

        return ans;
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

import java.io.*;
import java.util.*;

public class DynamicRangeMinimum {

    static long[] tree;
    static int n;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        n = fr.nextInt();
        int q = fr.nextInt();

        n = (int) Math.pow(2, (int) Math.ceil(Math.log10(n * 1.0) / Math.log10(2.0)));

        tree = new long[2 * n];

        for (int i = 0; i < n; i++) {
            int a = fr.nextInt();
            update(a, i);
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            Long t = fr.nextLong();
            try {
                Long a = fr.nextLong();
                Long b = fr.nextLong();
                if (t == 1) {
                    // update
                    update(b, a.intValue() - 1);
                } else if (t == 2) {
                    // minimum
                    sb.append(min(a.intValue() - 1, b.intValue() - 1) + "\n");
                }
            } catch (NullPointerException e) {
                System.out.println(t + " : FAULT");
            }

        }

        pr.println(sb.toString().trim());
        pr.close();
    }

    static void update(long x, int pos) {
        try {
            pos += n;
            tree[pos] = x;
            for (int i = pos / 2; i >= 1; i /= 2) {
                tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
            }
        } catch (NullPointerException e) {
            System.out.println("UPDATE FAULT");
        }
    }

    static int min(int a, int b) {
        try {
            a += n;
            b += n;
            long ans = Integer.MAX_VALUE;
            while (a <= b) {
                if (a % 2 == 1)
                    ans = Math.min(ans, tree[a++]);
                if (b % 2 == 0)
                    ans = Math.min(ans, tree[b--]);
                a /= 2;
                b /= 2;
            }
            return (int) ans;
        } catch (NullPointerException e) {
            System.out.println("MIN FAULT");
            return -2;
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

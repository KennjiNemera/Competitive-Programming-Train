import java.io.*;
import java.util.*;

public class MiraisStones {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int n = fr.nextInt();

        long[] arr = new long[n + 1];
        long[] sortedarr = new long[n + 1];

        long total = 0;
        for (int i = 0; i < n; i++) {
            int a = fr.nextInt();
            total += a;
            arr[i + 1] = total;
            sortedarr[i + 1] = a;
        }

        sort(sortedarr, 0, n);

        for (int i = 2; i <= n; i++) {
            sortedarr[i] += sortedarr[i - 1];
        }

        int t = fr.nextInt();

        while (t-- > 0) {
            int type = fr.nextInt();
            int l = fr.nextInt();
            int r = fr.nextInt();

            if (type == 1) {
                pr.println(arr[r] - arr[l - 1]);
            } else {
                pr.println(sortedarr[r] - sortedarr[l - 1]);
            }
        }

        // just a test

        pr.close();
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // MERGE SORT IMPLEMENTATION
    static void sort(long[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            // call merge
            merge(arr, l, m, r);
        }
    }

    static void merge(long[] arr, int l, int m, int r) {
        // find sizes
        int len1 = m - l + 1;
        int len2 = r - m;

        long[] L = new long[len1];
        long[] R = new long[len2];

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
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
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

    static int toInt(String s) {
        return Integer.parseInt(s);
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

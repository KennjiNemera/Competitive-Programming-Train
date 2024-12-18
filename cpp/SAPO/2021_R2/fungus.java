import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class fungus {

    static BigInteger mod = new BigInteger("1000000007");
    static int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        k = fr.nextInt(); n = fr.nextInt(); m = fr.nextInt();

        Pair[][] arr = new Pair[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = new Pair(0, 0);
            }
        }

        arr[0][0]  = new Pair(1,1);

        BigInteger ans = new BigInteger("0");

        for (int time = 0; time < k; time++){
            BigInteger temp = new BigInteger("0");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    BigInteger total = arr[i][j].cur;

                    for (int[] move : moves) {
                        int cx = i + move[0];
                        int cy = j + move[1];

                        if (isValid(cx, cy)) {
                            if (move[0] == 1 || move[1] == 1) {
                                total = total.add(arr[cx][cy].cur);
                            } else {
                                total = total.add(arr[cx][cy].prev);
                            }
                        }
                    }

                    arr[i][j].prev = arr[i][j].cur;
                    arr[i][j].cur = total;
                    temp = temp.add(total);
                }
            }
            ans = temp;
        }

        ans = ans.mod(mod);
        pr.println(ans);
        pr.close();
    }

    static boolean isValid(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        return true;
    }

    static class Pair {
        BigInteger cur, prev;

        public Pair(long x, long y) {
            cur = new BigInteger(String.valueOf(x));
            prev = new BigInteger(String.valueOf(y));
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

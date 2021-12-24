import java.io.*;
 
public class DivanNewProject {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int t = fr.nextInt();
 
        while (t-- > 0) {
            int n = fr.nextInt();
 
            int flipper = 0;
 
            Pair[] arr = new Pair[n];
 
            for (int i = 0; i < n; i++) {
                int a = fr.nextInt();
                arr[i] = new Pair(i, a);
            }
 
            Arrays.sort(arr, new Comp());
 
            long total = 0;
            long[] pos = new long[n];

            long push = 1;
 
            for (int i = 0; i < n; i++) {
                long d = arr[i].y * 2 * push;
                total += d;
                int x = arr[i].x;
                if (flipper % 2 == 0) {
                    pos[x] = push;
                } else {
                    pos[x] = -push;
                }
                flipper++;
                if (flipper == 2) {
                    flipper = 0;
                    push++;
                }
            }
 
            pr.println(total);
 
            String temp = Arrays.toString(pos);
            int len = temp.length();
            String out = "0 " + temp.substring(1, len - 1).replaceAll(",", "");
 
            pr.println(out);
        }
 
        pr.close();
    }
 
    static class Comp implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return Integer.compare(b.y, a.y);
        }
    }
 
    static class Pair {
        int x, y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
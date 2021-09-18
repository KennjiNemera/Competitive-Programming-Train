import java.io.*;
import java.text.BreakIterator;
import java.util.*;

public class Labrinth {

    static char[][] c;
    static char[][] par;
    static boolean[][] vis;
    static int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int sx, sy, ex, ey;
    static int n, m;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        n = fr.nextInt();
        m = fr.nextInt();

        c = new char[n][m];
        par = new char[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = fr.nextLine();
            for (int j = 0; j < s.length(); j++) {
                char temp = s.charAt(j);
                if (temp == 'A') {
                    sx = i;
                    sy = j;
                } else if (temp == 'B') {
                    ex = i;
                    ey = j;
                }
                c[i][j] = temp;
            }
        }

        if (search()) {
            pr.println("YES");

            // PATH RETRIEVAL
            StringBuilder sb = new StringBuilder();

            while (true) {
                if (par[ex][ey] == 'O') break;
                sb.append(par[ex][ey]);
                switch (par[ex][ey]) {
                    case 'D': ex--; break;
                    case 'U': ex++; break;
                    case 'R': ey--; break;
                    case 'L': ey++; break;
                } 
            }

            pr.println(sb.length());
            pr.println(sb.reverse().toString());
        } else {
            pr.println("NO");
        }

        pr.close();

    }

    static boolean search() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sx, sy, 'O'));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            vis[p.x][p.y] = true;
            par[p.x][p.y] = p.p;

            if (p.x == ex && p.y == ey)
                return true;

            for (int i = 0; i < 4; i++) {
                int cx = p.x + moves[i][0];
                int cy = p.y + moves[i][1];

                if (isValid(cx, cy)) {
                    if (!vis[cx][cy] && c[cx][cy] != '#') {
                        char par = 'E';
                        switch (i) {
                            case 0:
                                par = 'D';
                                break;
                            case 1:
                                par = 'U';
                                break;
                            case 2:
                                par = 'R';
                                break;
                            case 3:
                                par = 'L';
                                break;
                        }
                        q.offer(new Pair(cx, cy, par));
                    }
                }
            }
        }

        return false;
    }

    static boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return false;
        return true;
    }

    static class Pair {
        int x, y;
        char p;

        public Pair(int x, int y, char p) {
            this.x = x;
            this.y = y;
            this.p = p;
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

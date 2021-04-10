import java.io.*;
import java.util.*;

public class moocast {

    static ArrayList<Pair> arr;
    static boolean[] vis;
    static int maxCC, n, cc;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("moocast.out")));
    n = fr.nextInt();
    vis = new boolean[n];
    arr = new ArrayList<>();

    // add all cows
    for (int i = 0; i < n; i++) {
        arr.add(new Pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), i));
    }

    // build list of neighbours
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            int x = Math.abs(arr.get(i).x - arr.get(j).x);
            int y = Math.abs(arr.get(i).y - arr.get(j).y);
            double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            if (dist <= arr.get(i).p) {
                arr.get(i).neighbours.add(arr.get(j));
            }
        }
    }

    // Find the largest component assuming that any node (visited or not might be a lead)
    for (int i = 0; i < n; i++) {
        cc = 1;
        dfs(arr.get(i));
        maxCC = Math.max(maxCC, cc);
        Arrays.fill(vis, false);
    }

    pr.println(maxCC);
    pr.close();

  }

  static void dfs(Pair a) {
    vis[a.index] = true;
    for (Pair pair : a.neighbours) {
        if (!vis[pair.index]) {
            cc++;
            dfs(pair);
        }
    }
  }

    static class Pair {
        int x, y, p, index;
        ArrayList<Pair> neighbours;

        public Pair(int x, int y, int p, int index) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.index = index;
            neighbours = new ArrayList<>();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("moocast.in"));
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

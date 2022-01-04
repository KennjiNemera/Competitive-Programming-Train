import java.util.*;
import java.io.*;

public class KthAncestor {

    static ArrayList<ArrayList<Integer>> adj;
    static int[] sparse;
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

        int n = fr.nextInt();
        sparse = new int[n+1];

        adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());    
        }

        for (int i = 0; i < n - 1; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        build(1, 0);

        pr.println(Arrays.toString(sparse));

        pr.println(sparse(3, 2));
        pr.close();
    }

    static int sparse(int x, int k) {
        if (k == 1) {
            return sparse[x];
        }
        return sparse(sparse(x,k/2), k/2);
    }

    static void build(int x, int p) {
        sparse[x] = p;
        for (Integer child : adj.get(x)) {
            if (child != p) {
                build(child, x);
            }
        }
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;
    
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
    
        double nextDouble() {
          return Integer.parseInt(next());
        }
    
        long nextLong() {
          return Long.parseLong(next());
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




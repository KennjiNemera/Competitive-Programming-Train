import java.util.*;
import java.io.*;

public class AllLongestPaths {

    static ArrayList<ArrayList<Pair>> adj;
    static Pair[][] maxdist;
    static int[] parent;
    public static void main(String[] args) throws FileNotFoundException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

        adj = new ArrayList<>();

        int n = fr.nextInt();
        int m = fr.nextInt();

        parent = new int[n];
        maxdist = new Pair[n][2];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            maxdist[i][0] = new Pair(-1,0);
            maxdist[i][1] = new Pair(-1,0);
        }

        for (int i = 0; i < m; i++) {
            int a = fr.nextInt()-1;
            int b = fr.nextInt()-1;
            int w = fr.nextInt();

            adj.get(a).add(new Pair(b, w));
            adj.get(b).add(new Pair(a,w));
        }

        // Run a recursive build of the maxdists
        dfs(new Pair(0,0),-1);

        for (Pair[] parr : maxdist) {
          pr.println("----------------");
          pr.println(parr[0].x + " " + parr[0].y);
          pr.println(parr[1].x + " " + parr[1].y);
        }

        // now to find the max path that starts at each node.
        for (int i = 0; i < n; i++) {
          int maxchild = maxdist[i][0].y;

          // get the max route through the parent that doesn't go through i
          int maxparent = 0;
          int p = parent[i];
          if (p == -1) {
            maxparent = maxdist[i][1].y; 
          } else {
            if (maxdist[p][0].x == i) {
              // add route to parent + other route
              maxparent += getWeight(i, p) + maxdist[p][1].y;
            } else {
              maxparent += getWeight(i, p) + maxdist[p][0].y;
            }
          }

          pr.println(i + " : " + (maxparent + maxchild));
        }
      
        pr.close();
    }

    static int getWeight(int a, int b) {
      for (Pair p : adj.get(a)) {
        if (p.x == b) return p.y;
      }
      return -1;
    }

    static void dfs(Pair x, int p) {

      parent[x.x] = p;

        for (Pair child : adj.get(x.x)) {
            if (child.x != p) {
                dfs(child, x.x);
                int templen = maxdist[child.x][0].y + child.y;
                if (maxdist[x.x][1].y < templen) {
                    if (maxdist[x.x][0].y < templen) {
                        maxdist[x.x][1].x = maxdist[x.x][0].x;
                        maxdist[x.x][1].y = maxdist[x.x][0].y;

                        maxdist[x.x][0].x = child.x;
                        maxdist[x.x][0].y = templen;
                    } else {
                        maxdist[x.x][1].x = child.x;
                        maxdist[x.x][1].y = templen;
                    }
                }
            }
        }
    }

    static class Pair {

      // child -> x; dist -> y
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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

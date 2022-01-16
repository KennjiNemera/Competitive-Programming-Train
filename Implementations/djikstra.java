import java.util.*;
import java.io.*;

public class djikstra {
  public static void main(String[] args) throws FileNotFoundException {
    Fast fr = new Fast();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    int n = fr.nextInt();
    int m = fr.nextInt();

    ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
    boolean[] vis = new boolean[n];

    for (int i = 0; i < n; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int a = fr.nextInt() - 1;
      int b = fr.nextInt() - 1;
      int w = fr.nextInt();

      arr.get(a).add(new Pair(b, w));
      arr.get(b).add(new Pair(a, w));
    }

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[0] = 0;

    PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());

    pq.offer(new Pair(0,0));

    while(!pq.isEmpty()) {
      Pair node = pq.poll();

      int ind = node.a;

      if (vis[ind]) continue;

      vis[ind] = true;

      for (Pair child : arr.get(ind)) {
        int b = child.a, w = child.b;

        if (dist[ind] + w < dist[b]) {
          dist[b] = dist[ind] + w;
          pq.offer(new Pair(b, dist[b]));
        }
      }
    }

    for (int i = 1; i < n; i++) {
      if (dist[i] != Integer.MAX_VALUE) {
        pr.println(dist[i]);
      } else {
        pr.println(-1);
      }
    }

    pr.close();
  }

  static class Comp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
      return a.b - b.b;
    }
  }

  static class Pair {
    int a, b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  static class Edge {
    int a, b, w;

    Edge(int a, int b, int w) {
      this.a = a;
      this.b = b;
      this.w = w;
    }
  }

  static class Fast {
    StringTokenizer st;
    BufferedReader br;

    public Fast() throws FileNotFoundException {
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

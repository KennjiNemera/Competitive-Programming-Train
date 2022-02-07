import java.io.*;
import java.util.*;

class finedining {

  static ArrayList<ArrayList<Pair>> arr;
  static boolean[] vis;
  static long[] chows;

  public static void main(String[] args) {
    FastIO fr = new FastIO(); // reader
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    int n = fr.nextInt();
    int m = fr.nextInt();
    int k = fr.nextInt();

    arr = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int a = fr.nextInt()-1;
      int b = fr.nextInt()-1;
      long weight = fr.nextLong();

      arr.get(a).add(new Pair(b,weight));
      arr.get(b).add(new Pair(a,weight));
    }

    // READ IN THE HAYBALES DUMMY
    chows = new long[n];

    for (int i = 0; i < k; i++) {
      int ind = fr.nextInt() - 1;
      long nxalevel = fr.nextLong();

      chows[ind] = Math.max(chows[ind], nxalevel);
    }

    // RUN THE FIRST DJIKSTRA TO FIND THE MOST OPTIMAL PATH FROM N TO EACH OTHER NODE
    long[] run1 = new long[n + 1];

    Arrays.fill(run1, Long.MAX_VALUE);
    run1[n-1] = 0;

    PriorityQueue<Pair> pq = new PriorityQueue<>(); // sort the pairs by asc dist
    pq.offer(new Pair(n-1, 0));

    boolean[] vis = new boolean[n];

    while (!pq.isEmpty()) {
      Pair node = pq.poll();

      if (vis[node.a]) continue;
      vis[node.a] = true;


      for (Pair child : arr.get(node.a)) {

        // check that we haven't already visited the child node

        if (vis[child.a]) continue;

        int cid = child.a;
        long cw = child.b;
        if (run1[node.a] + cw < run1[cid]) {
          run1[cid] = run1[node.a] + cw;
          pq.offer(new Pair(cid, (int)run1[cid]));
        }
      }
    }

    for (int i = 0; i < chows.length; i++) {
      if (chows[i] == 0) continue; // not a valid place to chow
      arr.get(n).add(new Pair(i, run1[i] - chows[i]));
    }

    // DOUBLE DIJKS
    vis = new boolean[n + 1];
    long[] run2 = new long[n + 1];

    Arrays.fill(run2, Long.MAX_VALUE);
    pq = new PriorityQueue<>(); // possibly an issue later on
    pq.offer(new Pair(n, 0));

    run2[n] = 0;

    while (!pq.isEmpty()) {
      Pair node = pq.poll();

      if (vis[node.a]) continue;
      vis[node.a] = true;

      for (Pair child : arr.get(node.a)) {

        // check that we haven't already visited the child node
        if (vis[child.a]) continue;

        int cid = child.a;
        long cw = child.b;
        if (run2[node.a] + cw < run2[cid]) {
          run2[cid] = run2[node.a] + cw;
          pq.offer(new Pair(cid, (int)run2[cid]));
        }
      }
    }
    
    // only up n - 1 because no cows are on the nth farm
    for (int i = 0; i < n - 1; i++) {
      if (run2[i] <= run1[i]) {
        pr.println(1);
      } else {
        pr.println(0);
      }
    }
    
    pr.close();
  }


  static class Pair implements Comparable<Pair>{
    int a;
    long b;

    public Pair(int a, long b) {
      this.a = a;
      this.b = b;
    }

    public int compareTo(Pair b) {
      return Long.compare(this.b, b.b);
    }
  }

  static class FastIO extends PrintWriter {

    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar, numChars;

    public FastIO() {
      this(System.in, System.out);
    }

    public FastIO(InputStream i, OutputStream o) {
      super(o);
      stream = i;
    }

    private int nextByte() {
      if (numChars == -1)
        throw new InputMismatchException();

      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }

        if (numChars == -1)
          return -1;
      }

      return buf[curChar++];
    }

    private String next() {
      int c;
      do {
        c = nextByte();
      } while (c <= ' ');

      StringBuilder sb = new StringBuilder();

      do {
        sb.appendCodePoint(c);
        c = nextByte();
      } while (c > ' ');

      return sb.toString();
    }

    public int nextInt() {
      int c;
      do {
        c = nextByte();
      } while (c <= ' ');

      int sgn = 1;

      if (c == '-') {
        sgn = -1;
        c = nextByte();
      }

      int res = 0;

      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();

        res = 10 * res + c - '0';
        c = nextByte();
      } while (c > ' ');

      return res * sgn;
    }

    
    public long nextLong() {
      long c;
      do {
        c = nextByte();
      } while (c <= ' ');

      long sgn = 1;

      if (c == '-') {
        sgn = -1;
        c = nextByte();
      }

      long res = 0;

      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();

        res = 10 * res + c - '0';
        c = nextByte();
      } while (c > ' ');

      return res * sgn;
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}

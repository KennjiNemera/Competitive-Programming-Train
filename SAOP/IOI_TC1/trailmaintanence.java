import java.io.*;
import java.util.*;

class trailmaintanance {

  static int[] link, size;

  static int find(int x) {
    while (x != link[x])
      x = link[x];
    return x;
  }

  static void union(int a, int b) {
    int ap = find(a);
    int bp = find(b);

    if (size[ap] < size[bp]) {
      int temp = ap;
      ap = bp;
      bp = temp;
    }

    size[ap] += size[bp];
    link[bp] = ap;
  }

  public static void main(String[] args) {
    FastIO fr = new FastIO(); // reader
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    // ITS A DSU PROBLEM! I FEEL IT IN MY BONES
    int n = fr.nextInt();
    int w = fr.nextInt();

    link = new int[n + 1];
    size = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      link[i] = i;
      size[i] = 1;
    }

    ArrayList<Edge> edges = new ArrayList<>();

    for (int i = 0; i < w; i++) {
      int a = fr.nextInt();
      int b = fr.nextInt();
      long nw = fr.nextLong();

      // building a spanning tree because input is small...maybe we can get a few points

      edges.add(new Edge(a, b, nw));

      Collections.sort(edges);

      Arrays.fill(size, 1);
      for (int j = 1; j <= n; j++) {
        link[j] = j;
      }

      long treespan = 0;

      for (int j = 0; j < edges.size(); j++) {
        int x = edges.get(j).a;
        int y = edges.get(j).b;
        long dist = edges.get(j).weight;

        if (find(x) != find(y)) {
          treespan += dist;
          union(x, y);
        }
      }

      // check if the tree is complete
      if (size[find(1)] == n) {
        pr.println(treespan);
      } else {
        pr.println(-1);;
      }
    }

    pr.close();
  }

  static class Edge implements Comparable<Edge> {
    int a, b;
    long weight;

    public Edge(int a, int b, long weight) {
      this.a = a;
      this.b = b;
      this.weight = weight;
    }

    public int compareTo(Edge e) {
      return Long.compare(this.weight, e.weight);
    }
  }

  static class Pair {
    long a, b;

    public Pair(long a, long b) {
      this.a = a;
      this.b = b;
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

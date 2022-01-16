import java.io.*;
import java.util.*;

class journey {

  public static void main(String[] args) {
    FastIO fr = new FastIO(); // reader
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    int n = fr.nextInt();

    String in = fr.next();

    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    int[] nodecomp = new int[2 * n + 2];
    int[] compSize = new int[2 * n + 2];

    for (int i = 0; i < 2 * n + 2; i++) {
      arr.add(new ArrayList<>());
    }

    // perform io and build a bidirectional graph
    for (int i = 0; i < n; i++) {
      if (in.charAt(i) == 'L') {
        arr.get(i * 2 + 1).add((i + 1) * 2);
        arr.get((i+1) * 2).add(i * 2 + 1);
      } else {
        arr.get(i * 2).add((i + 1) * 2 + 1);
        arr.get((i+1) * 2 + 1).add(i * 2);
      }
    }

    Arrays.fill(nodecomp, Integer.MIN_VALUE);
    int compCount = 0;

    // perform a component search for size
    for (int i = 0; i < 2 * n + 2; i++) {

      // break search if component has already been assigned.
      if (nodecomp[i] != Integer.MIN_VALUE) {
        continue;
      }

      // perform a new BFS -> I chooose bfs just to avoid the use of functions outside main

      Queue<Integer> q = new LinkedList<>();
      q.offer(i);

      // keep a count for each component so that we can call it's length in O(1) time
      int count = 1;

      // perform BFS
      while (!q.isEmpty()) {
        Integer node = q.poll();

        nodecomp[node] = compCount;

        for (Integer child : arr.get(node)) {
          // check that we haven't already visited the child
          if (nodecomp[child] == Integer.MIN_VALUE) {
            count++;
            nodecomp[child] = compCount;
            q.offer(child);
          }
        }
      }

      compSize[compCount] = count;
      compCount++;
    }


    // for each element, print the size of it's corresponding component
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i <= n; i++) {
      int rep = nodecomp[i * 2];
      sb.append(compSize[rep] + " ");
    }

    pr.println(sb.toString().trim());
    pr.close();
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

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}

import java.io.*;
import java.util.*;

public class desertpwr {

  // lets start working on the segment tree functions
  static long[] sums;
  static int n, m, q, len;

  static long max(int a, int b) {
    a += len;
    b += len;

    long maxv = 0;

    while (a <= b) {
      if (a % 2 == 1)
        maxv = Math.max(maxv, sums[a++]);
      if (b % 2 == 0)
        maxv = Math.max(maxv, sums[b--]);
      a /= 2;
      b /= 2;
    }

    return maxv;
  }

  static void add(int k, long x) {
    k += len;
    sums[k] += x;
    for (k /= 2; k >= 1; k /= 2) {
      sums[k] = Math.max(sums[2 * k], sums[2 * k + 1]);
    }
  }

  // union find structures
  static int[] link;
  static int[] size;

  static int find(int x) {
    while (x != link[x])
      x = link[x];
    return x;
  }

  static void unite(int a, int b) {

    int pa = find(a);
    int pb = find(b);

    if (pa == pb)
      return;

    if (size[pa] < size[pb]) {
      int temp = pa;
      pa = pb;
      pb = temp;
    }

    size[pa] += size[pb];

    // add the points to a side
    add(pa, sums[pb+len]);

    link[pb] = pa;
  }

  public static void main(String[] args) throws IOException {
    FastIO fr = new FastIO();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    n = fr.nextInt();
    m = fr.nextInt();
    q = fr.nextInt();

    link = new int[n];
    size = new int[n];

    // init the tree structure
    for (int i = 0; i < n; i++) {
      link[i] = i;
      size[i] = 1;
    }

    // read in the node power stack
    Stack<Integer>[] power = new Stack[n];

    len = 1;

    while (len < n) {
      len <<= 1;
    }

    // find the first power of n greater than n
    sums = new long[2 * len]; // will store the sum of the component containing node i

    for (int i = 0; i < n; i++) {
      power[i] = new Stack<>();
      power[i].push(fr.nextInt());
    }

    // read in the connections
    Pair[] conn = new Pair[m];

    for (int i = 0; i < m; i++) {
      conn[i] = new Pair(fr.nextInt()-1, fr.nextInt()-1);
    }

    // read in the events and reverse the order

    Event[] events = new Event[q];
    Set<Integer> blacklist = new HashSet<>();

    for (int i = q - 1; i >= 0; i--) {
      char s = fr.next().charAt(0);

      if (s == 'D') {
        int x = fr.nextInt() - 1;
        blacklist.add(x);
        events[i] = new Event(s, x, -1);
      } else {
        int x = fr.nextInt() - 1;
        int y = fr.nextInt();

        power[x].push(y);

        events[i] = new Event(s, x, y);
      }
    }

    // run a loop to init the sums array
    for (int i = 0; i < n; i++) {
      add(i, power[i].peek());
    }


    // build the node structure
    for (int i = 0; i < m; i++) {
      if (blacklist.contains(i))
        continue;

      unite(conn[i].x, conn[i].y);
    }

    ArrayList<Long> list = new ArrayList<>();

    for (int i = 0; i < q; i++) {

      list.add(sums[1]);

      if (events[i].s == 'D') {
        int a = events[i].x;

        unite(conn[a].x, conn[a].y);
      } else {
        int pos = events[i].x;

        power[pos].pop();
        int cur = power[pos].peek();

        int change = cur - events[i].y;

        int parent = find(pos);

        add(parent, change);
      }
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      pr.println(list.get(i));
    }

    pr.close();
  }

  static class Event {
    char s;
    int x, y;

    public Event(char s, int x, int y) {
      this.s = s;
      this.x = x;
      this.y = y;
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

  static class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar, numChars;

    // standard input
    public FastIO() {
      this(System.in, System.out);
    }

    public FastIO(InputStream i, OutputStream o) {
      super(o);
      stream = i;
    }

    // file input
    public FastIO(String i, String o) throws IOException {
      super(new FileWriter(o));
      stream = new FileInputStream(i);
    }

    // throws InputMismatchException() if previously detected end of file
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
          return -1; // end of file
      }
      return buf[curChar++];
    }

    // to read in entire lines, replace c <= ' '
    // with a function that checks whether c is a line break
    public String next() {
      int c;
      do {
        c = nextByte();
      } while (c <= ' ');
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = nextByte();
      } while (c > ' ');
      return res.toString();
    }

    public int nextInt() { // nextLong() would be implemented similarly
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

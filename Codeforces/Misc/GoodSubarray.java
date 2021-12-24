import java.io.*;
import java.util.*;

public class GoodSubarray {

  static int[] prefix;

  public static void main(String[] args) throws IOException {
    FastIO fr = new FastIO();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();

      String s = fr.next();

      // generate a prefix sum

      // for each index in the prefix sum ..
      // run a two pointer from the start to curInd - 1

      HashMap<Integer, Long> map = new HashMap<>();

      long sum = 0;

      map.put(0, 1L);

      for (int i = 0; i < s.length(); i++) {
        sum += toInt(s.charAt(i) + "");
        map.putIfAbsent((int) (sum - i - 1), 0L);
        map.put((int) (sum - i - 1), map.get((int) (sum - i - 1)) + 1);
      }

      long total = 0;

      for (Map.Entry<Integer, Long> entry : map.entrySet()) {
        // pr.println(entry.getKey() + " : " + entry.getValue());
        total += (long)(entry.getValue() * (entry.getValue() - 1)) / 2;
      }

      pr.println(total);
    }
    pr.close();
  }

  // static int binarySearch(int target, int max) {
  // int lo = 0;
  // int hi = max - 1;
  // int ans = -1;

  // while (lo <= hi) {
  // int mid = (lo + hi) / 2;
  // if (prefix[mid] > target) {
  // ans = mid;
  // hi = mid - 1;
  // } else {
  // lo = mid + 1;
  // }
  // }

  // return ans;
  // }

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

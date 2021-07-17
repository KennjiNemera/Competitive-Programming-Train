import java.io.*;
import java.util.*;

public class FairNumbers {

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      long n = fr.nextLong();
      boolean flag = false;

      while (!flag) {

        // base params for each attempt -> this might actually be optimal. STAY AWAY-> FROM STRING CONVERSIONS EVEN IF YOUR LIFE DEPENDS ON IT
        long temp = n;
        flag = true;

        while (temp > 0) {
          long a = temp % 10;
          if (a != 0 && n % a != 0) {
            flag = false;
            break;
          }
          temp /= 10;
        }

        if (!flag)
          n++;
      }
      pr.println(n);
    }

    pr.close();

  }

  static class Pair {
    int x, y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
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

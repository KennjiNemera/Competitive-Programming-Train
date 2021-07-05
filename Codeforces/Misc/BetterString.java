import java.io.*;
import java.util.*;

public class BetterString {

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    String in = fr.nextLine();
    StringBuilder out = new StringBuilder("");
    
    for (int i = 0; i < n; i++) {
      if (out.length() % 2 == 0) {
        out.append(in.charAt(i));
      } else {
        if (in.charAt(i) != out.charAt(out.length() - 1)) {
          out.append(in.charAt(i));
        }
      }
    }

    if (out.length() % 2 == 0) {
      pr.println(in.length() - out.length());
      pr.println(out.toString());
    } else {
      pr.println(in.length() - out.length()+1);
      pr.println(out.toString().substring(0,out.length()-1));
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

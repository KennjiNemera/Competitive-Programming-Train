import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class FastReader {
  public static void main(String[] args) throws FileNotFoundException {
    Fast fr = new Fast();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    int a = fr.nextInt();

    pr.println(a);
    pr.close();
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

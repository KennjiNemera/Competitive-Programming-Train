import java.util.*;
import java.io.*;

public class StickLength {
  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = fr.nextInt();
    }
    Arrays.sort(arr);
    int mid = arr[(n / 2)];
    long sum = 0;
    // System.out.println(mid);
    for (int i = 0; i < arr.length; i++) {
      sum += Math.abs(arr[i] - mid);
    }
    System.out.println(sum);
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
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

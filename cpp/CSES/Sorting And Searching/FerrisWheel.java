import java.util.*;
import java.io.*;

public class FerrisWheel {

  static int[] arr;
  static int x;
  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    x = fr.nextInt();
    arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = fr.nextInt();
    }
    Arrays.sort(arr);
    int ans = arr.length;
    int i = 0;
    int j = arr.length - 1;
    while (i < j) {
      if (arr[i] + arr[j] <= x) {
        i++; j--; ans--;
      } else j--;
    }
    System.out.println(ans);
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
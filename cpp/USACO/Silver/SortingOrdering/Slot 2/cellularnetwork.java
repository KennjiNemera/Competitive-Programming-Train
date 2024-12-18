import java.io.*;
import java.util.*;

public class cellularnetwork {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int m = fr.nextInt();

    int[] cities = new int[n];

    for (int i = 0; i < cities.length; i++) {
      cities[i] = fr.nextInt();
    }

    int[] towers = new int[m];

    for (int i = 0; i < towers.length; i++) {
      towers[i] = fr.nextInt();
    }

    // for each city, perform binary search over the towers to find nearest tower
    long max = 0;
    for (int i = 0; i < cities.length; i++) {
      int ret = binarySearch(cities[i], towers);
      max = Math.max(max, ret);
    }

    pr.println(max);
    pr.close();
  }

  static int binarySearch(int target, int[] arr) {

    if (target < arr[0]) return Math.abs(arr[0] - target);
    if (target > arr[arr.length - 1]) return Math.abs(target - arr[arr.length - 1]);

    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] < target) {
        low = mid + 1;
      } else if (arr[mid] > target) high = mid - 1;
      else return 0;
    }

    int x = Math.abs(target - arr[low]);
    int y = Math.abs(arr[high] - target);

    // find the closest neighbour to the target
    return x < y ? x : y;
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

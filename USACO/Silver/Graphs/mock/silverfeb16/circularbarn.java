import java.io.*;
import java.util.*;

public class circularbarn {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("cbarn.out")));
    int n = fr.nextInt();
    int[] main = new int[n];

    for (int i = 0; i < main.length; i++) {
      main[i] = fr.nextInt();
    }

    long total = Integer.MAX_VALUE;

    // perform a full loop starting at each indices to find the optimum traversal path
    for (int i = 0; i < n; i++) {
      int[] arr = new int[n];
      System.arraycopy(main, 0, arr, 0, main.length);
      int[] walking = new int[n];
      int running = 0;
      int curPos = i;
      int start = i;
      int tempTotal = 0;
      int earliest = i;
      boolean op = false;

      do {
        running += arr[curPos];
        walking[curPos] = arr[curPos];

        if (running == 0) break;

        op = true;
        running--;

        // add the cow to the current pos and add the distance

        int startSearch = earliest;
        while (walking[earliest] == 0) {
          earliest++;
          if (startSearch == earliest) break;
          if (earliest == n) earliest = 0;
        }

        walking[earliest]--;

        arr[curPos] = 1;
        int dist;
        if (earliest > curPos) {
          dist = (n - earliest) + curPos;
        } else dist = curPos - earliest;

        // System.out.println(curPos + " " + tempTotal + " " + dist);

        tempTotal += Math.pow(dist, 2);

        curPos++;
        if (curPos == n) curPos = 0;
      } while (curPos != start);

      // System.out.println(i + " " + tempTotal);
      // System.out.println(Arrays.toString(arr));

      // System.out.println("curpos : " + curPos + " temp" + tempTotal);

      if (curPos == start && op) total = Math.min(total, tempTotal); // constitutes a valid path
    }


    pr.println(total);
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
      br = new BufferedReader(new FileReader("cbarn.in"));
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

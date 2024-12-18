import java.io.*;
import java.util.*;

public class crossingroads3 {

  static int count = 0, n, r, k;
  static int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }, map;
  static boolean[][] cows, vis;

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("countcross.out")));
    n = fr.nextInt();
    k = fr.nextInt();
    r = fr.nextInt();
    map = new int[n][n];
    cows = new boolean[n][n];
    vis = new boolean[n][n];
    ArrayList<Integer> popComp = new ArrayList<>();

    // update values of map boundaries
    for (int i = 0; i < map.length; i++) {
      map[0][i] += 1;
      map[i][0] += 8;
      map[n - 1][i] += 4;
      map[i][n - 1] += 2;
    }

        // // Print out the arrays because I am really skeptical
        // for (int[] row : map) {
        //   System.out.println(Arrays.toString(row));
        // }

    // generate the roads
    while (r-- > 0) {
      int a = fr.nextInt() - 1, b = fr.nextInt() - 1, c = fr.nextInt() - 1, d = fr.nextInt() - 1;
      // wall orientation check
      if (a == c) {
        map[a][Math.min(b, d)] += 2;
        map[a][Math.max(b, d)] += 8;
      } else {
        map[Math.min(a, c)][b] += 4;
        map[Math.max(a, c)][b] += 1;
      }
    }

    // generate the cows
    for (int i = 0; i < k; i++) {
      int a = fr.nextInt() - 1;
      int b = fr.nextInt() - 1;
      cows[a][b] = true;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!vis[i][j]) {
          // System.out.println(i + " " + j);
          count = 0;
          floodFill(i, j);
          if (count != 0) popComp.add(count);
        }
      }
    }

    // Print out the arrays because I am really skeptical
    // for (int[] row : map) {
    //   System.out.println(Arrays.toString(row));
    // }

    // System.out.println(Arrays.toString(popComp.toArray()));

    long ans = 1;

    for (int i = 0; i < popComp.size() - 1; i++) {
      for (int j = i + 1; j < popComp.size(); j++) {
        ans += popComp.get(i) * popComp.get(j);
      }
    }

    ans--;

    pr.println(ans);
    pr.close();
  }

  static boolean isValid(int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= n)
      return false;
    return true;
  }

  static boolean[] validMoves(int x, int y) {
    boolean[] out = new boolean[4];
    int val = map[x][y];
    int[] powers = { 8, 4, 2, 1 };

    // eg 11
    int pos = 0;
    while (pos < 4) {
      if (val >= powers[pos]) {
        val -= powers[pos];
        out[pos] = true;
      }
      while (pos < 4) {
        if (powers[pos] <= val) break;
        pos++;
      }
    }

    // System.out.println(x + " " + y + " : " + Arrays.toString(out));

    return out;
  }

  static void floodFill(int x, int y) {
    if (!isValid(x, y) || vis[x][y]) return;

    vis[x][y] = true;

    if (cows[x][y])
      count++;
    
    boolean[] validation = validMoves(x, y);

    for (int i = 0; i < 4; i++) {
      int cx = x + dir[i][0];
      int cy = y + dir[i][1];

      if (isValid(cx, cy)) {
        if (!validation[i]) {
          floodFill(cx, cy);
        }
      }
    }

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
      br = new BufferedReader(new FileReader("countcross.in"));
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

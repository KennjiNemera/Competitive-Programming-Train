import java.util.*;
import java.io.*;

public class lifeguards {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("lifeguards.out")));
    int n = Integer.parseInt(fr.nextLine());
    TreeSet<Integer> set = new TreeSet<>();
    Pair[] arr = new Pair[2 * n];
    for (int i = 0; i < n; i++) {
      String[] in = fr.nextLine().split(" ");
      arr[2 * i] = new Pair(Integer.parseInt(in[0]), i);
      arr[2 * i + 1] = new Pair(Integer.parseInt(in[1]), i);
    }
    Arrays.sort(arr);
    int[] alone = new int[n];
    int actualTime = 0;
    int last = 0;
    for (Pair p : arr) {
      if (set.size() == 1) {
        alone[set.first()] += p.x - last;
      }
      if (!set.isEmpty()) {
        actualTime += p.x - last;
      }
      if (set.contains(p.y)) {
        set.remove(p.y);
      } else {
        set.add(p.y);
      }
      last = p.x;
    }
    int maxTime = 0;
    for (int i : alone) {
      maxTime = Math.max(maxTime, actualTime - i);
    }
    pr.println(maxTime);
    pr.close();
  }

  static class Pair implements Comparable<lifeguards.Pair> {
    int x, y;
    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
    @Override
    public int compareTo(Pair o) {
      return x - o.x; 
    }
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() throws FileNotFoundException {
      br = new BufferedReader(new FileReader("lifeguards.in"));
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

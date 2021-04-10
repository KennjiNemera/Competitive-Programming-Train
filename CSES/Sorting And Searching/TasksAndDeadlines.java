import java.util.*;
import java.io.*;

public class TasksAndDeadlines {
  
  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    Pair[] arr = new Pair[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), fr.nextInt());   
    }
    Arrays.sort(arr);   
    long reward = 0;
    long curTime = 0;
    for (Pair pair : arr) {
      curTime += pair.f;
      reward += (pair.d - curTime);
    }
    System.out.println(reward);
  }

  static class Pair implements Comparable<TasksAndDeadlines.Pair> {
    int f, d;
    public Pair(int f, int d) {
      this.f = f;
      this.d = d;
    }
    @Override
    public int compareTo(Pair a) {
      return this.f - a.f;
    }
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

import java.io.*;
import java.util.*;

public class roomallocation {

  // come back to this problem with some kind of multiset implementation if this is too slow

  static class comp implements Comparator<roomallocation.Queue> {
    @Override
    public int compare(Queue a, Queue b) {
      if (a.x == b.x) {
        return a.y - b.y;
      } else return a.x - b.x;
    }
  }

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();

    PriorityQueue<Queue> pq = new PriorityQueue<>(n, new comp());

    int roomCount = 0, lastRoom = 0;
    int[] allocation = new int[n];

    Pair[] arr = new Pair[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(fr.nextInt(), fr.nextInt(), i);
    }

    Arrays.sort(arr);

    // process the customers
    for (int i = 0; i < arr.length; i++) {
      if (pq.isEmpty()) {
        lastRoom++;
        allocation[arr[i].i] = lastRoom;
        pq.add(new Queue(arr[i].y, lastRoom));
      } else {
        Queue a = pq.peek();
        if (a.x < arr[i].x) {
          allocation[arr[i].i] = a.y;
          pq.poll();
          pq.add(new Queue(arr[i].y, a.y));
        } else {
          lastRoom++;
          allocation[arr[i].i] = lastRoom;
          pq.add(new Queue(arr[i].y, lastRoom));
        }
      }
      roomCount = Math.max(roomCount, pq.size());
    }

    pr.println(roomCount);
    for (int i : allocation) {
      pr.print(i + " ");
    }

    pr.close();

  }

  static class Queue {
    int x, y;
    public Queue (int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static class Pair implements Comparable<roomallocation.Pair> {
    int x, y, i;

    public Pair(int x, int y, int i) {
      this.x = x;
      this.y = y;
      this.i = i;
    }

    @Override
    public int compareTo(Pair o) {
      if (o.y == y) {
        if (o.x == x) {
          return i - o.i;
        } else return x - o.x;
      } else
        return y - o.y;
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

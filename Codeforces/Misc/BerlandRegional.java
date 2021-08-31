import java.io.*;
import java.util.*;

public class BerlandRegional {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      HashMap<Integer, ArrayList<Long>> map = new HashMap<>();
      String[] team = fr.nextLine().split(" ");

      for (int i = 0; i < n; i++) {
        long a = fr.nextLong();

        map.putIfAbsent(toInt(team[i]), new ArrayList<>());

        map.get(toInt(team[i])).add(a);
      }

      // generate prefix for each university
      long[] arr = new long[n];
      for (Map.Entry<Integer, ArrayList<Long>> ent : map.entrySet()) { 
        ArrayList<Long> temp = ent.getValue();
        Collections.sort(temp);
        for (int i = 1; i < temp.size(); i++) {
          temp.set(i, temp.get(i - 1) + temp.get(i));
        }
        int size = temp.size();
        for (int k = 1; k <= n && k <= temp.size(); k++) {
          int mod = temp.size() % k;
          if (mod > 0) {
            mod--;
            arr[k-1] -= temp.get(mod);
          }
          arr[k-1] += temp.get(size-1);
        }
      }

      StringBuilder sb = new StringBuilder();

      for (long i : arr) {
        sb.append(i + " ");
      }

      pr.println(sb.toString().trim());
    }

    pr.close();
  }

  static class Pair {
    int x;
    ArrayList<Integer> y;

    public Pair(int x) {
      this.x = x;
      this.y = new ArrayList<>();
    }
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
  }

  // MERGE SORT IMPLEMENTATION
  void sort(int[] arr, int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;

      sort(arr, l, m);
      sort(arr, m + 1, r);

      // call merge
      merge(arr, l, m, r);
    }
  }

  void merge(int[] arr, int l, int m, int r) {
    // find sizes
    int len1 = m - l + 1;
    int len2 = r - m;

    int[] L = new int[len1];
    int[] R = new int[len2];

    // push to copies
    for (int i = 0; i < L.length; i++)
      L[i] = arr[l + i];
    for (int i = 0; i < R.length; i++) {
      R[i] = arr[m + 1 + i];
    }

    // fill in new array
    int i = 0, j = 0;
    int k = l;
    while (i < len1 && j < len2) {
      if (L[i] < R[i]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[i];
        j++;
      }
      k++;
    }

    // add remaining elements
    while (i < len1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < len2) {
      arr[k] = R[j];
      j++;
      k++;
    }
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

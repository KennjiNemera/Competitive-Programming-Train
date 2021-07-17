import java.io.*;
import java.util.*;

public class FixingTypos {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    StringBuilder str = new StringBuilder("");
    String in = fr.nextLine();

    char prev = in.charAt(0);
    int count = 1;
    str.append(prev);
    boolean following = false;
    
    for (int i = 1; i < in.length(); i++) {
      char cur = in.charAt(i);
      if (cur == prev) {
        if (count < 2 && !following) {
          count++;
          str.append(cur);
        }
      } else {
        if (count == 2) {
          following = true;
        } else following = false;
        count = 1;
        prev = cur;
        str.append(cur);
      } 
    }

    pr.println(str.toString());
    pr.close();
  }

  static int getend(String sb, int i) {
    if (i == sb.length()) return -1;
    if (i == sb.length()-1) return sb.length()-1;
    char target = sb.charAt(i);
    for (int j = i + 1; j < sb.length(); j++) {
      if (sb.charAt(j) != target)
        return j-1;
    }
    return sb.length();
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

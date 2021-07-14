import java.io.*;
import java.util.*;

public class FixingTypos {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    String in = fr.nextLine();
    StringBuilder str = new StringBuilder("");

    int i = 0;
    while (i < in.length()) {
      int last = getend(in, i);
      if (last - i + 1 > 2 || last == in.length()) {
        str.append(in.substring(i, i + 2));
      } else str.append(in.substring(i, last + 1));
      i=last + 1;
    }

    // pr.println(str.toString());
    String ans = "";
    
    for (int j = 0; j < str.length(); j++) {
      char c = str.charAt(j);
      if (ans.length() > 1) {
        if (ans.length() == 2) {
          if (ans.charAt(ans.length()-1) == c && ans.charAt(ans.length()-2) == c) {
            continue;
          } else ans += c;
        } else if (ans.charAt(ans.length()-2) == ans.charAt(ans.length()-3) &&
                   c == ans.charAt(ans.length()-1)) {
          continue;
        } else ans += c;
      } else ans += c;
    }

    pr.println(ans);
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

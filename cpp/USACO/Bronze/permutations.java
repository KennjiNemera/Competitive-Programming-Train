import java.io.*;
import java.util.*;

public class permutations {

  static int total = 0;
  static Set<String> arr = new HashSet();
  static PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    String s = fr.nextLine();

    allPerm(s.toCharArray(), s.length(), s.length());
    System.out.println(arr.size());

    for (String list : arr) {
      pr.println(list);
    }
    pr.close();
  }

  static void print(char[] a, int n) {
    String s = "";
    for (int i = 0; i < n; i++) {
      s += a[i] + "";
    }
    if (!arr.contains(s)) arr.add(s);
  }

  static void allPerm(char[] s, int size, int n) {
    if (size == 1) {
      print(s, n);
    } 
    for (int i = 0; i < size; i++) {
        allPerm(s, size-1, n);
      if (size % 2 == 0) {
        char temp = s[i];
        s[i] = s[size - 1];
        s[size-1] = temp;
          // swap ith and last
      } else {
        // swap 0 and last
        char temp = s[0];
        s[0] = s[size - 1];
        s[size - 1] = temp;
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

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new InputStreamReader(System.in)); 
      } 

      String next() 
      { 
          while (st == null || !st.hasMoreElements()) 
          { 
              try
              { 
                  st = new StringTokenizer(br.readLine()); 
              } 
              catch (IOException  e) 
              { 
                  e.printStackTrace(); 
              } 
          } 
          return st.nextToken(); 
      } 

      int nextInt() 
      { 
          return Integer.parseInt(next()); 
      } 

      long nextLong() 
      { 
          return Long.parseLong(next()); 
      } 

      double nextDouble() 
      { 
          return Double.parseDouble(next()); 
      } 

      String nextLine() 
      { 
          String str = ""; 
          try
          { 
              str = br.readLine(); 
          } 
          catch (IOException e) 
          { 
              e.printStackTrace(); 
          } 
          return str; 
      } 
  }
}

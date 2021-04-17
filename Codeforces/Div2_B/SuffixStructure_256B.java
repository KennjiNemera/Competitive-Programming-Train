import java.io.*;
import java.util.*;

public class SuffixStructure_256B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    StringBuilder s = new StringBuilder(fr.nextLine());
    StringBuilder t = new StringBuilder(fr.nextLine());

    if (s.indexOf(t.toString()) != -1) {
      pr.println("automaton");
    } else {
      int[] a = new int[26];
      int[] b = new int[26];

      for (int i = 0; i < s.length(); i++) {
        a[s.charAt(i) - 'a']++;
      }

      for (int i = 0; i < t.length(); i++) {
        b[t.charAt(i) - 'a']++;
      }

      if (checkEquality(a, b)) {
        pr.println("array");
      } else if (checkboth(a, b)) {
        pr.println("both");
      } else {
        pr.print("need tree");
      }
    }

    pr.close();    
  }

  static boolean checkboth(int[] a, int[] b) {
    for (int i = 0; i < b.length; i++) {
      if (a[i] < b[i]) return false;
    }
    return true;
  }

  static boolean checkEquality(int[] a, int[] b) {
    for (int i = 0; i < b.length; i++) {
      if (a[i] != b[i]) return false;
    }
    return true;
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

import java.io.*;
import java.util.*;

public class circlecross {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("circlecross.out")));
    String str = fr.nextLine();
    int ans = 0;
    Pair[] arr = new Pair[26];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Pair(-1, -1);
    }

    for (int i = 0; i < str.length(); i++) {
      if (arr[str.charAt(i) - 'A'].x == -1) {
        arr[str.charAt(i) - 'A'].x = i;
      } else {
        arr[str.charAt(i) - 'A'].y = i;
      }
    }

    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        if (arr[i].x < arr[j].x && arr[i].y < arr[j].y && arr[j].x < arr[i].y) ans++;
      }
    }

    pr.println(ans);
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

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("circlecross.in")); 
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

import java.io.*;
import java.util.*;

public class B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    // still trying to understand the problem statement lmao
    // give me a sec, what a dumbass I am
    // big up paralyzed

    int t = fr.nextInt();

    while (t-- > 0) {
      String in = fr.nextLine();

      int a = in.indexOf("a");

      if (a==-1)
      {
        pr.println("NO");
        continue;
      } else {
        char c = 'a';
        int left = a, right = a;
        boolean possible = true;

        while (possible && c < 'a' + in.length() - 1) {
          possible = false;
          if (left != 0) 
          {
            if (in.charAt(left - 1) == (char)(c + 1)) {
              c++;
              left--;
              possible = true;
            }
          }
          if (right != in.length()-1) 
          {
            if (in.charAt(right + 1) == (char)(c + 1)) {
              c++;
              right++;
              possible = true;
            }
          }          
        }

        if (possible) {
          pr.println("YES");
        } else pr.println("NO");
      }


    }

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

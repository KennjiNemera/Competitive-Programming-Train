import java.io.*;
import java.util.*;

public class C {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int a = fr.nextInt();
      int b = fr.nextInt();
      char[] s = fr.nextLine().toCharArray();
      int n = a + b;
      boolean flag = true;

      // edge case -> length 1
      if (n == 1) {
        if (s[0] == '?') {
          if (a > b) {
            a--;
            s[0] = '0';
          } else {
            b--;
            s[0] = '1';
          }
        } else {
          if (s[0] == '1') {
            b--;
          } else a--;
        }
        if (a < 0 || b < 0) flag = false;
      } else {
        for (int i = 0; i < n / 2; i++) {
          if (s[i] == '?' && s[n - i - 1] == '?') {
            if (a > b) {
              // use 0
              s[i] = '0';
              s[n - i - 1] = '0'; 
              a -= 2;
            } else {
              // use 1
              s[i] = '1';
              s[n - i - 1] = '1';
              b -= 2;
            }
          } else {
            // assign the partners value
            if (s[i] != '?' && s[n - i - 1] != '?') {
              if (s[i] != s[n - i - 1]) {
                flag = false;
                break;
              } else {
                if (s[i] == '0') {
                  a -= 2;
                } else {
                  b -= 2;
                }
              }     
            } else {
              if (s[i] == '?') {
                if (s[n - i - 1] == '0') {
                  a -= 2;
                  s[i] = '0';
                } else {
                  b -= 2;
                  s[i] = '1';
                }
              } else {
                if (s[i] == '0') {
                  a -= 2;
                  s[n - i - 1] = '0';
                } else {
                  b -= 2;
                  s[n - i - 1] = '1';
                }
              }
            }
          }
  
          if (a < 0 || b < 0) {
            flag = false;
            break;
          }
        }
        // check for odd and count the middle character
        if (n % 2 != 0) {
          if (s[(n/2)] == '1') b--;
          else if (s[(n/2)] == '0') a--;
          else {
            if (a > b) {
              s[(n/2)] = '0';
              a--;
            } else {
              s[(n/2)] = '1';
              b--;
            }
          }
        }

        if (a < 0 || b < 0) {
          flag = false;
        }
      }

      if (!flag || a != 0 || b != 0) {
        pr.println(-1);
      } else {
        for (char c : s) {
          pr.print(c);
        }
        pr.print("\n");
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

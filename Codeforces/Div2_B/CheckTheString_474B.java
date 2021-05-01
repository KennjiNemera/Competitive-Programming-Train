import java.util.*;

public class CheckTheString_474B {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    String s = fr.nextLine();
    int[] count = new int[3];
    
    // check the ordering
    if (s.lastIndexOf("a") > s.indexOf("b") || s.lastIndexOf("b") > s.indexOf("c")) {
        pr.println("NO");
    } else {
        // perform a count
        for (int i = 0; i  < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // perform a check to see that we have all of the characters.
        if (count[0] == 0 || count[1] == 0 || count[2] == 0) {
            pr.println("NO");
        } else if (count[2] == count[0] || count[2] == count[1]) {
            pr.println("YES");
        } else pr.println("NO");
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

import java.io.*;
import java.util.*;

public class SillyMistakes {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int[] arr = new int[1000001];
    ArrayList<Integer> lengths = new ArrayList<>();
    ArrayList<Integer> current = new ArrayList<>();
    int currentactive = 0;

    for (int i = 0; i < n; i++) {
      int a = fr.nextInt();
      int abs = Math.abs(a);

      current.add(abs);

      if (a < 0) {
        if (arr[abs] < 1) {
          // either a signout of someone that hasn't signed in or has already left.
          pr.println(-1);
          pr.close();
          return;
        } else if (arr[abs] == 1) {
          arr[abs] = -1;
          currentactive--;
        }
      } else {
        // check that the employee has only came to the office once that day
        if (arr[a] != 0) {
          // another impossible case
          pr.println(-1);
          pr.close();
          return;
        } else {
          arr[a] = 1;
          currentactive++;
        }
      }

      // check currentactive
      if (currentactive == 0) {
        lengths.add(current.size()); // append the length of the valid sequence
        // reset structures
        for (Integer val : current) {
          arr[Math.abs(val)] = 0;
        }
        current.clear();
      }
    }

    // remember to validate the sequence after the final action -> I suspect that it is a final sequence check :(
    if (!current.isEmpty()) {
      pr.println(-1);
      pr.close();
      return;  
    } 

    pr.println(lengths.size());
    StringBuilder sb = new StringBuilder();
    for (Integer integer : lengths) {
      sb.append(integer + " ");
    }
    pr.println(sb.toString().trim());
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

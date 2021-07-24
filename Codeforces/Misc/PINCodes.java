import java.io.*;
import java.util.*;

public class PINCodes {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int t = fr.nextInt();

    while (t-- > 0) {
      int n = fr.nextInt();
      ArrayList<String> pin = new ArrayList<>();
      int changecount = 0;

      for (int i = 0; i < n; i++) {
        pin.add(fr.nextLine()); 
      }
      
      for (int i = n-1; i >= 0; i--) {
        String str = pin.get(i);
        if (pin.lastIndexOf(str) != getfirst(pin, str)) { // means that there is more than 1 value
          boolean foundunique = false;
          for (int j = 0; j < 4 && !foundunique; j++) {
            for (int k = 0; k < 10; k++) {
              String newstr = str.substring(0,j) + String.valueOf(k);
              if (j != 3) newstr += str.substring(j + 1);
              if (!pin.contains(newstr)) {
                foundunique = true;
                changecount++;
                pin.set(i, newstr);
                break;
              }
            }
          }
        }
      }


      pr.println(changecount);

      for (String a : pin) {
        pr.println(a);
      }
    }

    pr.close();
  }

  static int getfirst(ArrayList<String> list, String str) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(str)) return i;
    }
    return -1;
  }

  static class Pair {
      String x; int y;
      public Pair(String x, int y) {
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

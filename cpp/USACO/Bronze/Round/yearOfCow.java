import java.io.*;
import java.util.*;

public class yearOfCow {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    String[] arr = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
    int n = fr.nextInt();
    Pair[] cows = new Pair[n+1];
    cows[0] = new Pair("Bessie", 0, 0);

    for (int i = 1; i <= n; i++) {
      String[] in = fr.nextLine().split(" ");
      String s = in[0];
      String year = in[4];
      String relative = in[7];
      if (in[3].equals("previous")) {
        int findYear = findYear(arr, year);
        int relYear = getCowSign(cows, relative);
        int dif = 0;
        if (findYear >= relYear) {
          dif += relYear + 1;
          dif += (11 - findYear);
        } else {
          dif = relYear - findYear;
        }
        cows[i] = new Pair(s, findYear, getCowRel(cows, relative) - dif);
      } else {
        int findYear = findYear(arr, year);
        int relYear = getCowSign(cows, relative);
        int dif = 0;
        if (findYear <= relYear) {
          dif += (11 - relYear);
          dif += findYear + 1;
        } else {
          dif = findYear - relYear;
        }
        cows[i] = new Pair(s, findYear, getCowRel(cows, relative) + dif);
      }
    }

    // for (Pair pair : cows) {
    //   System.out.println(pair.name + " " + pair.sign + " " + pair.difference);
    // }

    int ans = getDif(cows);
      pr.println(ans);
      pr.close();
  }

  static int getDif(Pair[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].name.equals("Elsie")) return Math.abs(arr[i].difference);
    }
    return 0;
  }

  static int getCowSign(Pair[] arr, String name) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].name.equals(name)) return arr[i].sign;
    }
    return 0;
  }

  static int getCowRel(Pair[] arr, String name) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].name.equals(name)) return arr[i].difference;
    }
    return 0;
  }

  static int findYear(String[] arr, String find) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(find)) return i;
    }
    return 0;
  }

  static class Pair {
      String name;
      int sign, difference;
      public Pair(String s, int x, int y ) {
          name = s;
          sign = x;
          difference = y;
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

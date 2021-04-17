import java.io.*;
import java.util.*;

public class StudentsAndShoelaces_94B {

  static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
  static int n, m;

  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    int m = fr.nextInt();
    
    for (int i = 0; i < n; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int a = fr.nextInt();
      int b = fr.nextInt();

      arr.get(a-1).add(b-1);
      arr.get(b-1).add(a-1);
    }

    boolean naughty = true;
    int count = 0;

    while (naughty) {
      naughty = false;
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        if (arr.get(i).size() == 1) {
          set.add(i);
          naughty = true;
        }
      }

      for (int i = 0; i < n; i++) {
        if (set.contains(i)) {
          continue;
        }
        for (int j = 0; j < arr.get(i).size(); j++) {
          int test = arr.get(i).get(j);
          if (set.contains(test)) {
            arr.get(i).remove(test);
          } else {
            int sub = test;
            arr.get(i).remove(test);
            arr.get(i).add(sub - count);
          }
        }
      }
      
      for (Integer integer : set) {
        arr.remove(integer);
      }

      System.out.println(set.toString());

      if (naughty) count++;
      n -= set.size();
    }

    pr.println(count);
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

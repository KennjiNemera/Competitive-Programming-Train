import java.util.*;
import java.io.*;

public class bcount {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("bcount.out")));
    int n = fr.nextInt();
    int m = fr.nextInt();
    Set[] arr = new Set[n];

    // start prefix

    int a = 0;
    int b = 0;
    int c = 0;
    for (int i = 0; i < arr.length; i++) {
      int val = fr.nextInt();
      switch (val) {
        case 1: a++; break;
        case 2: b++; break;
        case 3: c++; break;
      }
      arr[i] = new Set(a, b, c);
    }

    for (int i = 0; i < m; i++) {
      int L = fr.nextInt()-1;
      int R = fr.nextInt()-1;
      if (L == 0) {
        pr.println(arr[R].a + " " + arr[R].b + " " + arr[R].c);
      } else {
        int b1 = arr[R].a - arr[L-1].a;
        int b2 = arr[R].b - arr[L-1].b;
        int b3 = arr[R].c - arr[L-1].c;
        pr.println(b1 + " " + b2 + " " + b3);
      }
    }

    pr.close();
  }

  static class Set {
    int a, b, c;
    public Set(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("bcount.in")); 
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

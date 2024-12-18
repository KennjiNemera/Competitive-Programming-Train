import java.util.*;
import java.io.*;

public class homework {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("homework.out")));
    int n = fr.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int[] arr = new int[n];
    int[] prefix = new int[n];
    arr[0] = fr.nextInt();
    prefix[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      int a = fr.nextInt();
      arr[i] = a; 
      prefix[i] = a + prefix[i-1];
      pq.offer(a);
    }
    int maxAvg = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    for (int j = 0; j < arr.length-1; j++) {
      pq.remove(arr[j]);
      int min = pq.peek();
      int div = n - j - 2;
      if (div <= 0) {
        div = 1;
      }
      if ((arr[n-1] - arr[j] - min) / div > maxAvg) {
        maxAvg = (arr[n-1] - arr[j] - min) / div;
        ans.add(j + 1);
      }
    }
    for (Integer integer : ans) {
      pr.println(integer);
    }
    pr.close();

  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("homework.in")); 
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

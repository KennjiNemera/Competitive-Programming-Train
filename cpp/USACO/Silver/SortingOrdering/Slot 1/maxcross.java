import java.util.*;
import java.io.*;

public class maxcross {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("maxcross.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();
    int b = fr.nextInt();
    Set<Integer> broken = new HashSet<>();
    for (int i = 0; i < b; i++) {
      broken.add(fr.nextInt());
    }
    int[] arr = new int[n];

    int total = 0;
    for (int i = 0; i < arr.length; i++) {
      if (!broken.contains(i+1)) {
        total += 1;
      }
      arr[i] = total;
    }


    // traversal for the subarr of maxdiff sum
    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= arr.length - k; i++) {
      int dif = 0;
      if (i != 0) {
        dif = arr[i+k-1] - arr[i-1];
      }
      int repair = k - 1;
      if (repair >= 0) min = Math.min(min, k - dif);
    }

    pr.println(min);
    pr.close();

  }

  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException 
        { 
            br = new BufferedReader(new FileReader(new File("maxcross.in"))); 
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

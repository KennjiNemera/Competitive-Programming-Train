import java.io.*;
import java.util.*;
public class diamond {
	public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("diamond.out")));
    int n = fr.nextInt();
    int k = fr.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = fr.nextInt();
    }
    Arrays.sort(arr);
    // we want to get the indices of the left-most values for arr[i]
    int[] leftmostindex = getLeftMost(arr, k);

    // generate the max sizes of segments with greatest value arr[i]
    int[] leftSize = new int[n];
    for (int i = 0; i < leftSize.length; i++) {
      leftSize[i] = i - leftmostindex[i] + 1;
      if (i > 0) {
        leftSize[i] = Math.max(leftSize[i], leftSize[i-1]);
      }
    }

    // indices of the right-most values for arr[i]
    int[] rightmostindex = getRightMost(arr, k);
    int[] rightSize = new int[n];

    for (int i = n - 1; i >= 0; i--) {
      rightSize[i] = rightmostindex[i] - i + 1;
      if (i < n - 1) {
        rightSize[i] = Math.max(rightSize[i], rightSize[i+1]);
      }
    }

    // find greatest amount of diamonds. Thus we need to find the max sum of leftsize[i] and rightmost [i+1]
    int ret = 0;
    for (int i = 0; i < n-1; i++) {
      ret = Math.max(ret, leftSize[i] + rightSize[i+1]);
    }

    pr.println(ret);
    pr.close();
  }

  static int[] getLeftMost(int[] arr, int k) {
    int[] ret = new int[arr.length];
    int j = 0;
    for (int i = 0; i < ret.length; i++) {
      while (j < arr.length && arr[i] - arr[j] > k) {
        j++;
      }
      ret[i] = j;
    }
    return ret;
  }

  static int[] getRightMost(int[] arr, int k) {
    int n = arr.length;
    int[] ret = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      int j = n - 1;
      while (j >= 0 && arr[j] - arr[i] > k) {
        j--;
      }
      ret[i] = j;
    }
    return ret;
  }
  
  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new FileReader("diamond.in")); 
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
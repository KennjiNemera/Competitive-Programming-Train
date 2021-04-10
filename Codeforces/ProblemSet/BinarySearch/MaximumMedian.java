import java.util.*;
import java.io.*;

public class MaximumMedian {

	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
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

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		long k = fr.nextLong();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = fr.nextLong();
		}
		Arrays.sort(arr);
		long low = 0;
		long high = (long)Integer.MAX_VALUE;
		long ans = 0;

		while (low <= high) {
			long mid = (low + high) / 2;
			long res = operations(arr, mid);
			if (res <= k) {
				ans = Math.max(ans, mid);
				low = mid + 1;
			} else high = mid - 1;
		}
		System.out.println(ans);
	}

	static long operations(long[] arr, long x) {
		long mid = (long) arr.length / 2;
		long needed = 0;
		for (int i = (int)mid; i < arr.length; i++) {
			if (arr[i] < x) needed += (long)x - arr[i];
		}
		return needed;
	}
}
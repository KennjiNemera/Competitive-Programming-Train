import java.util.*;
import java.io.*;

public class Lanterns {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		long n = fr.nextLong();
		long l = fr.nextLong();
		String[] tempArr = fr.nextLine().split(" ");
		long[] arr = new long[(int)n];

		for (long num = 0; num < n; num++) {
			arr[(int)num] = Long.parseLong(tempArr[(int)num]);
		}

		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));
		double maxGap = 0;
		for (long k = 0; k < n-1; k++) {
			if (Math.abs(arr[(int)k] - arr[(int)k+1]) / 2.0d > maxGap) {
				maxGap = Math.abs(arr[(int)k] - arr[(int)k+1]) / 2.0d;
			}
		}

		boolean noEdge = false;
		if (Math.abs(arr[(int)arr.length-1] - l) > maxGap) {
			maxGap = Math.abs(arr[arr.length-1] - l);
			noEdge = true;
		} 
		if (arr[0] > maxGap) {
			noEdge = true;
			maxGap = arr[0];
		}

		System.out.println(maxGap);
	}


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
}
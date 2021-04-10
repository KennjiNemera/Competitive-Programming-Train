import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.Arrays;

public class SageBirthday {

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
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = fr.nextInt();
		}
		Arrays.sort(arr);
		if (n <= 3) {
			System.out.println(0);
			for (int i : arr) {
				System.out.print(i + " ");
			}
			return;
		}
		int L = 0, R = n-1;
		int mid = (n-1) / 2;
		System.out.println(mid);
		while (L <= mid) {
			System.out.print(arr[L+mid] + " ");
			if (L < mid) System.out.print(arr[L] + " ");
			L++;
		}
		for (int j = 2 * mid+1; j < n; j++) {
			System.out.print(arr[j] + " ");
		}

	}
}
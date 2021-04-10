import java.util.*;
import java.io.*;

public class DeliveryDilemma {

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
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt();
			Shop[] arr = new Shop[n];
			// fr.nextLine();
			String[] a = fr.nextLine().split(" ");

			for (int i = 0; i < n; i++) {
				arr[i] = new Shop(Integer.parseInt(a[i]), fr.nextInt());
			}
			Arrays.sort(arr);

			// Find min difference between a[i] and a[i+1]
			long min = arr[n-1].a;
			long sum = 0;

			for (int i = n-1; i >= 0; i--) {
				long tm = 0;
				if (i > 0) tm = arr[i-1].a;
				sum += arr[i].b;
				if (sum > min) {
					break;
				}

				min = Math.min(Math.max(tm, sum), min);
			}

			System.out.println(min);
		}	
	}

	static class Shop implements Comparable<Shop> {
		int a, b;
		public Shop(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Shop o) {
			return a - o.a;
		}
	}
}
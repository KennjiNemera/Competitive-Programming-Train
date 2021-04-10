import java.util.*;
import java.io.*;

public class AnyolaFridge {


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
		long h = fr.nextLong();
		long[] arr = new long[n];

		for (int i = 0; i < n; i++) arr[i] = fr.nextLong();

		int ans = 1;

		for (int i = 0; i < n; i++) {
			ArrayList<Long> temp = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				temp.add(arr[j]);
			}
			Collections.sort(temp, Collections.reverseOrder());
			long need = 0;
			for (int j = 0; j < temp.size(); j+=2) {
				need += temp.get(j);
			}
			if (need <= h) {
				ans = Math.max(ans, i+1);
			}
		}
		System.out.println(ans);

	}
}
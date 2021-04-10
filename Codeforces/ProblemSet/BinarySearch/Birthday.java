import java.util.*;
import java.io.*;

public class Birthday {

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
		long min = Long.MAX_VALUE;
		long max = 0;
		List<Long> ls = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			long l = fr.nextLong();
			if (l > max) max = l;
			ls.add(l);
		}

		long[] arr = new long[n];
		Collections.sort(ls);

		int count = 0;
		int size = ls.size();
		int mid = (size-1)/2;
		arr[mid] = max;
		ls.remove(size-1);
		boolean isLeft = false;
		while (count++ <= size/2) {

			if (ls.size() <= 0) break;

			if (mid - count > -1) {
				arr[mid - count] = ls.get(ls.size()-1);
				ls.remove(ls.size()-1);				
			} else isLeft = true;

			// System.out.println("Mid: " + mid + " Count: " + count);

			arr[mid + count] = ls.get(ls.size()-1);
			ls.remove(ls.size()-1);
		}

		for(long l : arr) {
			System.out.print(l + " ");
		}
	}
}
import java.util.*;
import java.io.*;

public class ToyBlocks {
	public static void main(String[] args)  throws IOException {
		FastReader fr = new FastReader();
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt();
			long sum = 0;
			long max = 0;
			for (int j = 0; j < n; j++) {
				long num = fr.nextLong();
				sum += num;
				if (num > max) {
					max = num;
				}
			}
            // System.out.println(max + " " + sum);
            // System.out.println("Sum: " + sum + " / " + (n-1) + " = " + Math.ceil(sum / (n-1)));
			double val = Math.ceil((double)sum / (double)(n-1));
            // System.out.println("max: " + max + " val" + val);
			val = Math.max(val, max);
            double add = ((n-1) * val) - sum;
            // System.out.println(max + " " + val + " " + sum +" = " + add);
			br.write((long)add + "\n");
		} 
		br.flush();
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
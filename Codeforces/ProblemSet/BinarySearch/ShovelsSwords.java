import java.util.*;
import java.io.*;

public class ShovelsSwords {

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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        OutputStream out = new BufferedOutputStream(System.out);
        int n = fr.nextInt();
        while (n-- > 0) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            if (a >= b * 2) {
                out.write((b + "\n").getBytes());
                continue;
            } else if (b >= 2 * a) {
                out.write((a + "\n").getBytes());
                continue;
            } else out.write((((a + b) / 3) + "\n").getBytes());
        }
        out.flush();
    }

}

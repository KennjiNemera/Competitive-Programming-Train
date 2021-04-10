import java.util.*;
import java.io.*;

public class Megacity {

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
		FastReader br = new FastReader();
		int n =  br.nextInt();
		int people = br.nextInt();
		Map<Double, Integer> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			int x = br.nextInt();
			int y = br.nextInt();
			int k = br.nextInt();
			double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			if (map.containsKey(dist)) {
				map.put(dist, map.get(dist) + k);
			} else map.put(dist, k);
		}

		int total = 0;
		int clicks = 0;
		for (Map.Entry<Double, Integer> ent : map.entrySet()) {
			total += ent.getValue();
			clicks++;
			if (people + total >= 1000000) {
				System.out.println(ent.getKey());
				return;
			}
		}

		System.out.println("-1");
	}
}
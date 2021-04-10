import java.util.*;
import java.io.*;

public class TwoTeams {

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
		FastReader scan = new FastReader();
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			Map<Integer, Integer> map = new TreeMap<>();
			int most = 1;
			int val = 0;
			for (int i = 0; i < n; i++) {
				int a = scan.nextInt();	
				if (map.containsKey(a)) {
					map.put(a, map.get(a) + 1);
					if (map.get(a) > most) {
						most = map.get(a);
						val = a;
					}
				} else {
					map.put(a, 1);
				}
			}

			if (n == 1) {
				System.out.println(0);
				continue;
			} else if (most == 1) {
				System.out.println(1);
				continue;
			}
			
			if (most >= map.size()) {
				System.out.println(Math.min(map.size(), most-1));
			} else System.out.println(Math.min(map.size(), most));
			
			// System.out.println("Eish: " + map.size() + " " + most) ;
			
		}
	}	
}
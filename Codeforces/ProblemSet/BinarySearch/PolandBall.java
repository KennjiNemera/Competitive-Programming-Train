import java.util.*;
import java.io.*;

public class PolandBall {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int p = fr.nextInt();
		int e = fr.nextInt();
		int k = 0;

		Set<String> set = new HashSet<>();
		int pol = p;
		int en = e;
		for (int i = 0; i < pol; i++) {
			String word = fr.nextLine();
			set.add(word);
		}

		for (int i = 0; i < en; i++) {
			String word = fr.nextLine();
			if (!set.add(word)) {
				k++;
			}
		}

		boolean first = (k % 2 == 0);

		// System.out.println(p + " " + e + " " + whoDoneIt);
		if (first) {
			first = p > e;
		} else {
			first = p >= e;
		}

		System.out.println(first ? "YES" : "NO");
		
	}

	static boolean exists(Set<String> set, String str) {
		for (String s : set) {
			if (s.equals(str)) return true;
		}
		return false;
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
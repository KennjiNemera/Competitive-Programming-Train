import java.util.*;
import java.io.*;

public class MeetsVadar {

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

    static class base implements Comparable<base> {
    	int d, g;
    	public base (int d, int g) {
    		this.d = d;
    		this.g = g;
    	}

    	@Override
    	public int compareTo(base o) {
    		return d - o.d;
    	}
    }

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		int ship = fr.nextInt();
		int b = fr.nextInt();

		long[] ships = new long[ship];
		for (int i = 0; i < ship; i++) {
			ships[i] = fr.nextLong();
		}

		base[] bases = new base[b];
		for (int c = 0; c < b; c++) bases[c] = new base(fr.nextInt(), fr.nextInt()); 

		Arrays.sort(bases);	
	 	

	 	// for (int r = 0; r < b; r++) {
	 	// 	System.out.println(bases[r].d + " " + bases[r].g);
	 	// }

	 	// Summate Gold Arr
		long[] sum = new long[b];
		sum[0] = bases[0].g;

		for (int k = 1; k < b; k++) {
			sum[k] = bases[k].g + sum[k-1];
		}

		// System.out.println(Arrays.toString(sum));

	 	// System.out.println(Arrays.toString(defense));
	 	// System.out.println(Arrays.toString(gold));

		for (int j = 0; j < ship; j++) {
			int ind = binary(bases, ships[j]);
			if (ind >= 0) {
				br.write(sum[binary(bases, ships[j])] + " ");				
			} else br.write("0 ");

		}

		br.flush();
	}

	static int binary(base[] arr, long j) {
		int L = 0, R = arr.length - 1;
		int ans = -1;
		while (L <= R) {
			int mid = L + ((R-L)/2);
			if (arr[mid].d <= j) {
				L = mid + 1;
				ans = mid;
			} else {
				R = mid - 1;
			}
		}
		return ans;
	}
}
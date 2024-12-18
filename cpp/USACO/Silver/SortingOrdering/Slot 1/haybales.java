import java.util.*;
import java.io.*;

public class haybales {

	public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        String[] in = fr.nextLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int q = Integer.parseInt(in[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < q; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            pr.println(binaryRangeSearch(arr, a, b));      
        }

        pr.close();

		// BEAT YOUR TIME
    }

    static int binaryRangeSearch(int[] arr, int a, int b) {
        int L = 0;
        int R = arr.length - 1;
        int left = -1;
        int right = -1;
        while (L <= R) {
            int mid = L + ((R-L) / 2);
            if (arr[mid] < a) {
                L = mid + 1;
                left = mid;
            } else R = mid - 1;
        }
        L = 0; R = arr.length - 1;
        while (L <= R) {
            int mid = L + ((R-L) / 2);
            if (arr[mid] <= b) {
                right = mid;
                L = mid + 1;
            } else R = mid - 1;
        }
        return right - left;
    }
    

	static class Pair implements Comparable<haybales.Pair> {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return x - o.x;
		}
	}

	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException 
        { 
            br = new BufferedReader(new FileReader(new File("haybales.in"))); 
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
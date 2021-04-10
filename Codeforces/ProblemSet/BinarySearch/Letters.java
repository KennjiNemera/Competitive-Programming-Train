import java.util.*;
import java.io.*;

public class Letters {

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
        int n = fr.nextInt();
        int m = fr.nextInt();
        String[] strNums;
        ArrayList<Long> rooms = new ArrayList<>();
        long[] arr = new long[n];
        long total = 0;
        strNums = fr.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            long c = Long.parseLong(strNums[i]);
            arr[i] = c;
            total += c;
            rooms.add(total);
        }
        OutputStream out = new BufferedOutputStream(System.out);
        for (int j = 0; j < m; j++) {
            long letter = fr.nextLong();
            int mid = bSearch(rooms, letter);
            if (rooms.get(mid) < letter) mid++;
            if (mid == 0) System.out.println((mid + 1) + " " + letter);
            else System.out.println((mid + 1) + " " + (letter - rooms.get(mid - 1)));
        }
        out.flush();
    }

    public static int bSearch(ArrayList<Long> arr, long n) {
        int L = 0;
        int R = arr.size()-1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R-L) / 2);
            if (arr.get(mid) ==  n) {
                break;
            }
            if (arr.get(mid) > n) {
                R = mid - 1;
            } else L = mid + 1;
        }
        return mid;
    }
}
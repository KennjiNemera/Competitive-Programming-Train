// package codeforces1;
import java.util.*;
import java.io.*;
 
public class Topics{
 
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
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = fr.nextInt();
        Integer[] arr = new Integer[n];
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = fr.nextInt();
        }

        for (int j = 0; j < n; j++) {
            b[j] = fr.nextInt();
            arr[j] = a[j] - b[j];
        }

// System.out.println(Arrays.toString(arr));

        // long total = 0;
        // Arrays.sort(arr);
        // for (int j = 0; j < n; j++) {
        //     if (arr[j] <= 0) continue;
        //     long pos = binary(arr, -1 * (arr[j]), j);
        //     // pos -= arr[0];
        //     long id = pos;
        //     total += pos - (j + 1);
        // }

        int L = 0, R = n-1;
        long total = 0;
        Arrays.sort(arr);        
        // System.out.println(Arrays.toString(arr));
        while (L < R) {
            if (arr[L] + arr[R] > 0) {
                // System.out.println("L:"  + L + " R: " + R + " Val: " + (arr[L] + arr[R]));
                total += R-L;
                R--;
            } else {
                L++;
            }
        }

        br.write(total + " ");
        br.flush();
    }

    // static long binary(long[] arr, long cut, int left) {
    //     int L = left + 1, R = arr.length-1;
    //     long ans = 0;
    //     // System.out.println("Cut: " + cut);
    //     // System.out.println(Arrays.toString(arr));
    //     while (L <= R) {
    //         int mid = L + ((R-L)/2);
    //         if (arr[mid] < cut) {
    //             // System.out.println("Mid: " + mid + " Val: " + (arr[mid]));
    //             L = mid + 1;
    //             ans = mid + 1;
    //         } else R = mid - 1;
    //     }
    //     // System.out.println("Ans: " + ans);
    //     return ans;
    // }



}

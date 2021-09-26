import java.util.*;

public class SegmentTree {

    static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // length of the array
        int len = (int) Math.pow(2, Math.ceil(Math.log(n)/Math.log(2))); // little log trick to get first power of 2 >= n

        arr = new int[2*len];

        // add the values through all the dependant values O ( log n )
        for (int i = 0; i < len; i++) {
            int a;

            // append values if length of the array is not a power of 2
            if (i > n) {
                a = 0;
            } else a = scan.nextInt();

            // add a value through all its parent values.
            add(i + len, a);
        }

        int q = scan.nextInt(); // number of queries

        while (q-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            System.out.println(sum(a + len, b + len));
        }
    }

    // Performs O(log n) addition operations to all dependant values
    static void add(int k, int x) {
        arr[k] += x;
        for (k /= 2; k >= 1; k /= 2) {
            arr[k] = arr[2 * k] + arr[2 * k + 1];
        }
    }

    // Performs O(log n) operations to find the highest values that correspond to a precalculated subrange
    static int sum(int a, int b) {
        int s = 0;
        while (a <= b) {
            if (a % 2 == 1) s += arr[a++];
            if (b % 2 == 0) s += arr[b--];
             a /= 2; b /= 2;
        }
        return s;
    }


}
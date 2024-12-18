package codeforces.cf845d2;

import java.util.*;
import java.io.*;

public class B {

    static int MOD = (int)(1e9 + 7);

    public static long fact(long n) {
        if (n == 1) return 1;
        return n * fact(n - 1) % MOD;
    }
    public static void solve(Scanner sc) {
        long n = sc.nextLong();
        // System.out.format("Val: %d", n);
        // System.out.println(fact(n));
        long ans = ((n * (n - 1) % MOD) * fact(n)) % MOD;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        // TESTING
        // File f = new File("src/codeforces/cf845d2/B.in");
        // Scanner sc;
        // try {
        //     sc = new Scanner(f);
        //     int t = sc.nextInt();
        //     while (t-- > 0) solve(sc);
        // } 
        // catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // }

        // CODEFORCES SUBMISSION
        // *******************************************
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) solve(sc);
    }
}

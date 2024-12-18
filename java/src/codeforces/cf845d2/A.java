package codeforces.cf845d2;

import java.util.*;
import java.io.*;

public class A {

    public static void solve(Scanner sc) {
        PrintWriter pw = new PrintWriter(System.out, true);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int count = 0, pos = 0;
        while (pos < n - 1) {
            if (arr[pos] % 2 == arr[pos+1] % 2) count++;
            pos++;
        }
        pw.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) solve(sc);
    }
}

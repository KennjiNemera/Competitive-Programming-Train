import java.util.*;
import java.io.*;

public class MinimumQuery {

  static int[][] mem;
  static int[] arr;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    arr = new int[n];
    int j = getfloor(n);
    mem = new int[n][500]; 

    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }

    mini(n);

    int t = scan.nextInt();

    while (t-- > 0) {
      int a = scan.nextInt();
      int b = scan.nextInt();

      System.out.println(search(a,b));
    }
  }

  static int search(int a, int b) {
    int k = getfloor(b-a+1);

    return Math.min(mem[a][k-1], mem[b-(1 << (k-1))][k-1]);
  }

  static void mini(int n) {
    
    for (int i = 0; i < arr.length; i++) mem[i][0] = arr[i];

    // number of lengths that are powers of 2
    for (int i = 1; (1 << i) <= n; i++) {
      for (int j = 0; j + (1 << i) - 1 < n; j++) {
        mem[j][i] = Math.min(mem[j][i-1], mem[j + (1 << (i - 1))][i - 1]);
      }
    }   
  }

  static int getfloor(int n) {
    int i = 0;
    if (n == 1) return 0;
    while (Math.pow(2, i) <= n) {
      i++;
    }
    return i-1;
  }
}
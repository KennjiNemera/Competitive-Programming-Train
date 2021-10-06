import java.util.*;

public class LIS {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }

    int[] d = new int[n+1];

    Arrays.fill(d, Integer.MAX_VALUE);

    d[0] = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
        int j = binarysearch(d, arr[i]);
        if (d[j-1] < arr[i] && arr[i] < d[j]) d[j] = arr[i]; 
    }

    int max = 0;

    for (int j = 0; j < d.length; j++) {
      if (d[j] < Integer.MAX_VALUE) {
        max = j;
      }
    }

    System.out.println(max);
  }

  static int binarysearch(int[] arr, int j) {
    int lo = 0;
    int hi = arr.length - 1;
    int ans = -1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if (arr[mid] > j) {
        ans = mid;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return ans;
  }


}

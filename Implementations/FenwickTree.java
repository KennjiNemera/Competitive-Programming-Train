import java.util.*;

public class FenwickTree {

  static int[] arr, tree;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    arr = new int[n+1];
    tree = new int[n+1];

    for (int i = 1; i <= n; i++) {
      arr[i] = scan.nextInt();
    }

    // build the tree
    for (int i = 1; i <= n; i++) {
      int left = i - (i & -i) + 1;
      int sum = 0;
      for (int j = left; j <= i; j++) {
        sum += arr[j];
      }
      tree[i] = sum;
    }

    System.out.println(Arrays.toString(tree));
  }  

  static int sum(int b) {
    int sum = 0;
    while (b >= 1) {
      sum += tree[b];
      b -= b & -b;
    }
    return sum;
  } 

  static void update(int x, int val) {
    while (x <= tree.length) {
      tree[x] += val;
      x += x & -x;
    }
  }
}

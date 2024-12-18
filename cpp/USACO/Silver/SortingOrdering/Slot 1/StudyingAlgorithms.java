import java.util.*;

public class StudyingAlgorithms {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int x = scan.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scan.nextInt();
    }
    Arrays.sort(arr);
    int count = 0;
    int i = 0;
    while (i < n && count + arr[i] <= x) {
      count += arr[i];
      i++;
    }
    System.out.println(i);
  }
}

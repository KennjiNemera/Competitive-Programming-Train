import java.util.ArrayList;

public class Figurate {

  public static ArrayList<ArrayList<Integer>> arr;
  public static int[] ans;

  public static void generate(int type) {
    int n = 0;
    int val = 0;
    ArrayList<Integer> arr = new ArrayList<>();

    while (val < 10000) {
      n++;
      switch (type) {
        case 0:
          val = (int) ((n * (n + 1)) / 2);
          break;
        case 1:
          val = (int) (n * n);
          break;
        case 2:
          val = (int) ((n * (3 * n - 1)) / 2);
          break;
        case 3:
          val = (int) (n * (2 * n - 1));
          break;
        case 4:
          val = (int) (n * (5 * n - 3)) / 2;
          break;
        case 5:
          val = (int) n * (3 * n - 2);
          break;
      }
      if (val > 999 && val < 10000) {
        arr.add(val);
      }
    }

    Figurate.arr.add(arr);
  }

  static boolean search(int len, int prev) {
    for (int i = 0; i < ans.length; i++) {

      // check that it hasn't been found
      if (ans[i] != 0) continue;

      // check all the values in that figurate set
      for (int j = 0; j < arr.get(i).size(); j++) {
        
        // check that the value is unique before you validate
        boolean flag = true;

        for (int k = 0; k < ans.length; k++) {
          if (ans[k] == arr.get(i).get(j)) {
            flag = false;
            break;
          }
        }

        // validate ONLY THE UNIQUE VALUES
        if (flag) {
          if ((arr.get(i).get(j) / 100) == (ans[prev] % 100)) {
            ans[i] = arr.get(i).get(j);

            // check that the cycle can be closed by checking it with the 5th value that was placed in the list without validation.
            if (len == 5) {
              if (ans[5] / 100 == ans[i] % 100) return true;
            }
            if (search(len + 1, i)) return true;
          }
        }
      }
      ans[i] = 0;
    }
    return false;
  }

  public static void main(String[] args) {

    arr = new ArrayList<>();

    // prebuild values for each figurate to avoid RECURSIVE HELL
    for (int i = 0; i < 6; i++) {
      generate(i);
    }

    ans = new int[6]; // will hold temporary solution

    /* 
      Because we know that the octagonal set must be included, it also has the smallest set so then we know that we can then just     
      test each value from the octagonal set and just backtrack it until we eventually find a valid solution.
    */

    for (int i = 0; i < arr.get(5).size(); i++) {
      ans[5] = arr.get(5).get(i);

      if(search(1, 5)) break; // brute force all possible octagonal combinations
    }

    int sum = 0;

    for (int i = 0; i < ans.length; i++) {
      sum += ans[i];
    }

    System.out.println(sum);

    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
    }
  }
}

import java.util.*;
import java.io.*;

public class ForestQueries {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][n];
    for (int i = 0; i < map.length; i++) {
      char[] temp = br.readLine().toCharArray();
      for (int j = 0; j < map.length; j++) {
        int add = temp[j] == '*' ? 1 : 0;
        map[i][j] = getVal(map, i-1, j) + getVal(map, i, j-1) - getVal(map, i-1, j-1) + add; 
      }
    }

    while (m-- > 0) {
      String[] arr = br.readLine().split(" ");
      int x1 = Integer.parseInt(arr[1]) - 1;
      int y1 = Integer.parseInt(arr[0]) - 1;
      int x2 = Integer.parseInt(arr[3]) - 1;
      int y2 = Integer.parseInt(arr[2]) - 1;
      pr.println(getVal(map, y2, x2) - getVal(map, y1-1, x2) - getVal(map, y2, x1-1) + getVal(map, y1-1, x1-1));
    }
    pr.close();
  }

  static int getVal(int[][] arr, int x, int y) {
    int n = arr.length;
    if (x >= n || x < 0 || y >= n || y < 0) {
      return 0;
    }
    return arr[x][y];
  }
}
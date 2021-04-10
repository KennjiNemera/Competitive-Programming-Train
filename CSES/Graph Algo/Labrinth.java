import java.util.*;

class Pair {
   public int first;
   public int second; 

   public Pair (int first, int second) {
      this.first = first;
      this.second = second;
   }

}

public class Labrinth {

   static char[][] grid;
   static boolean[][] vis;
   static Pair[][] path;
   static int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};
   static int n,m;
   static int sx,sy,ex,ey;


   // perform a breadth first search over the grid
   public static void bfs() {
      Queue<Pair> q = new LinkedList<Pair>();
      Pair root = new Pair(sx,sy);
      q.offer(root);
      while(!q.isEmpty()) {
         int cx = q.peek().first;
         int cy = q.peek().second;
         q.poll();
         for (int[] pair : moves) {
            int mvx = pair[0];
            int mvy = pair[1];

            if (isValid(cx + mvx, cy + mvy)) {
               q.offer(new Pair(cx + mvx,cy + mvy));
               vis[cx + mvx][cy + mvy] = true;
               path[cx + mvx][cy + mvy] = new Pair(mvx, mvy);
            }
         }
      }

   }

   // checks if move is valid
   public static boolean isValid(int x, int y) {
      if (x < 0 || x >= n || y < 0 || y >= m) return false; // checks if in range
      if (vis[x][y]) return false; // checks if we have visited
      return true;
   }
   
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);   
      n = scan.nextInt();
      m = scan.nextInt();
      scan.nextLine();

      // sizing our structures
      grid = new char[n][m];
      vis = new boolean[n][m];
      path = new Pair[n][m];

      // populate the grid
      for (int i = 0; i < n; i++) {
         grid[i] = scan.nextLine().toCharArray();
      }

      // populate the structures
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {

            path[i][j] = new Pair(-1,-1); // the path with null values

            char c = grid[i][j];
            
            // populate the visited co-ords
            switch (c) {
               case '#' : vis[i][j] = true;
                          break;
               case 'A' : sx = i;
                          sy = j;
                          break;
               case 'B' : ex = i;
                          ey = j;
                          break;     
            }
         }
      }

      bfs();

      if (!vis[ex][ey]) {
         System.out.println("NO");
         return;
      } else {
         System.out.println("YES");
      }

      // The actual path retrieval algorithm
         ArrayList<Pair> ans = new ArrayList();
         Pair end = new Pair(ex,ey);
         // StringBuffer sb = new StringBuffer();

         while (end.first != sx || end.second != sy) {
            ans.add(path[end.first][end.second]);
            // System.out.println(ans.get(ans.size()-1).first + "," + ans.get(ans.size()-1).second);
            end.first -= ans.get(ans.size()-1).first;
            end.second -= ans.get(ans.size()-1).second;
         }

         Collections.reverse(ans);
         System.out.println(ans.size(  ));

      for (Pair set : ans) {
         if (set.first == 1 && set.second == 0) System.out.print("D");
         else if (set.first == -1 && set.second == 0) System.out.print("U");
         else if (set.first == 0 && set.second == 1) System.out.print("R");
         else if (set.first == 0 && set.second == -1) System.out.print("L");
      }

   }

}
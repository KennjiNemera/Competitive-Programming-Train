import java.io.*;
import java.util.*;

public class buildingteams {
  
  static ArrayList<Player> arr;
  static boolean[] vis;
  static int m, n;
  static boolean impossible = false;
  
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    n = fr.nextInt();
    m = fr.nextInt();

    arr = new ArrayList<>();
    vis = new boolean[n];

    for (int i = 0; i < n; i++) {
      arr.add(new Player(i));
    }

    // build graph structure
    for (int i = 0; i < m; i++) {
      int a = fr.nextInt();
      int b = fr.nextInt();
      arr.get(a-1).neighbours.add(arr.get(b-1));
      arr.get(b-1).neighbours.add(arr.get(a-1));
    }
    
    // process components
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        biparDFS(i, 1);
      }
    }

    if (impossible) {
      pr.println("IMPOSSIBLE");
    } else {
      for (Player p : arr) {
            pr.print(p.colour + " ");
          }      
    }

    pr.close();
  }

  static void biparDFS(int x, int c) {
    vis[x] = true;
    arr.get(x).colour = c;
    int team = c == 1 ? 2 : 1;
    for (Player player : arr.get(x).neighbours) {
      if (player.colour == c) {
        impossible = true;
      }
      if (!vis[player.index] && !impossible) {
        biparDFS(player.index, team);
      }
    }
  }

  static class Player {
    int colour, index;
    ArrayList<Player> neighbours;
    public Player(int index) {
      this.index = index;
      neighbours = new ArrayList<>();
    }
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader() throws FileNotFoundException 
      { 
          br = new BufferedReader(new InputStreamReader(System.in)); 
      } 

      String next() 
      { 
          while (st == null || !st.hasMoreElements()) 
          { 
              try
              { 
                  st = new StringTokenizer(br.readLine()); 
              } 
              catch (IOException  e) 
              { 
                  e.printStackTrace(); 
              } 
          } 
          return st.nextToken(); 
      } 

      int nextInt() 
      { 
          return Integer.parseInt(next()); 
      } 

      long nextLong() 
      { 
          return Long.parseLong(next()); 
      } 

      double nextDouble() 
      { 
          return Double.parseDouble(next()); 
      } 

      String nextLine() 
      { 
          String str = ""; 
          try
          { 
              str = br.readLine(); 
          } 
          catch (IOException e) 
          { 
              e.printStackTrace(); 
          } 
          return str; 
      } 
  }
}

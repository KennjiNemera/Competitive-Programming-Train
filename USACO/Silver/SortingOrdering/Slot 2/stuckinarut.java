import java.io.*;
import java.util.*;

public class stuckinarut {
  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    int n = fr.nextInt();
    ArrayList<Cow> Ncows = new ArrayList<>();
    ArrayList<Cow> Ecows = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String s = fr.next();
      if (s.charAt(0) == 'N') {
        Ncows.add(new Cow(fr.nextInt(), fr.nextInt(), i));
      } else {
        Ecows.add(new Cow(fr.nextInt(), fr.nextInt(), i));
      }
    }

    // arrays need to be sorted
    Collections.sort(Ncows, new NComp());
    Collections.sort(Ecows, new EComp());

    // structures for tracking
    int[] stopCount = new int[n];

    // perform complete search over the set, anchoring the north facing cows
    for (int j = 0; j < Ncows.size(); j++) {
      Cow cow = Ncows.get(j);
      for (int i = 0; i < Ecows.size(); i++) {
        if (Ecows.get(i).b || cow.b) continue; // already stopped cow
        if (Ecows.get(i).x < cow.x && Ecows.get(i).y > cow.y) {
          // intersect @ x = Nx, y = Ey
          // find the cow that reaches intersection first
          if (cow.x - Ecows.get(i).x < Ecows.get(i).y - cow.y) { // case of East reaching first
            cow.b = true;
            stopCount[Ecows.get(i).index] += stopCount[cow.index] + 1;            
          } else if (cow.x - Ecows.get(i).x > Ecows.get(i).y - cow.y) {
            Ecows.get(i).b = true;
            stopCount[cow.index] += stopCount[Ecows.get(i).index] + 1;
          }
        }
      }
    }

    for (int i = 0; i < stopCount.length; i++) {
      pr.println(stopCount[i]);
    }

    pr.close();
  }

  static class NComp implements Comparator<stuckinarut.Cow> {
    public int compare(Cow a, Cow b) {
      return a.x - b.x;
    }
  }

  static class EComp implements Comparator<stuckinarut.Cow> {
    public int compare(Cow a, Cow b) {
      return a.y - b.y;
    }
  }

  static class Cow {
      int x, y, index;
      boolean b;
      public Cow(int x, int y, int index) {
          this.x = x;
          this.y = y;
          this.index = index;
          b = false;
      }
  }

  static int toInt(String s) {
    return Integer.parseInt(s);
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

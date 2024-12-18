import java.util.*;
import java.io.*;

public class rental {

  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new FileWriter(new File("rental.out")));
    int n = Integer.parseInt(fr.next());
    int m = Integer.parseInt(fr.next());
    int r = Integer.parseInt(fr.next());

    int[] cows = new int[n];
    for (int i = 0; i < cows.length; i++) {
      cows[i] = fr.nextInt();
    }
    Arrays.sort(cows);
    Pair[] shops = new Pair[m];
    for (int i = 0; i < shops.length; i++) {
      shops[i] = new Pair(fr.nextInt(), fr.nextInt());
    }

    Arrays.sort(shops);

    int[] rental = new int[r];
    for (int i = 0; i < rental.length; i++) {
      rental[i] = fr.nextInt();
    }

    Arrays.sort(rental);

    // Tabulate
    int[][] payment = new int[n][2];

    // Fill rental column
    for (int i = 0; i < payment.length; i++) {
      if (i >= rental.length) {
        payment[i][0] = 0;
      } else payment[i][0] = rental[r-i-1];
    }

    // Fill the shop amount
    int curShop = shops.length - 1;
    for (int i = payment.length-1; i >= 0; i--) {
      int bag = 0;
      while (cows[i] > 0) {
        if (curShop == 0 && shops[curShop].x == 0) break;
        // System.out.println("Cow: " + cows[i] + " Shop: " + curShop);
        if (shops[curShop].x >= cows[i]) {
          bag += cows[i] * shops[curShop].y;
          shops[curShop].x -= cows[i];
          cows[i] = 0;
        } else {
          bag += shops[curShop].x * shops[curShop].y;
          cows[i] -= shops[curShop].x;
          shops[curShop].x = 0;
          curShop--;      
        }
      }
      payment[i][1] = bag;
    }

    long sum = 0;
    for (int[] is : payment) {
      sum += Math.max(is[0], is[1]);
    }
    pr.println(sum);
    pr.close();
  }
  
  static class Pair implements Comparable<rental.Pair> {
		int x, y;

    public Pair(int x, int y) {
      this.x = x; 
      this.y = y;
    }

		@Override
		public int compareTo(Pair o) {
			return y - o.y;
		}
  }
  
  // static void printBuyers(Pair[] arr) {
  //   for (Pair pair : arr) {
  //     System.out.println(pair.x + " " + pair.y);
  //   }
  //   System.out.println("-----------");
  // }

	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException 
        { 
            br = new BufferedReader(new FileReader(new File("rental.in"))); 
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

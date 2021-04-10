import java.util.*;
import java.io.*;

public class wormsort {

  static int minimum = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        
        // BEAT YOUR TIME
        String[] in = fr.nextLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        // Fill the cow array
        in = fr.nextLine().split(" ");
        Pair[] cows = new Pair[n];
        for (int i = 0; i < cows.length; i++) {
          cows[i] = new Pair(i+1, Integer.parseInt(in[i]));
        }

        System.out.println(Arrays.toString(cows));

        Wormhole[] holes = new Wormhole[m];
        // Fill the wormhole array
        for (int i = 0; i < holes.length; i++) {
          String[] aWorm = fr.nextLine().split(" ");
          int a = Integer.parseInt(aWorm[0]);
          int b = Integer.parseInt(aWorm[1]);
          int w = Integer.parseInt(aWorm[2]);
          holes[i] = new Wormhole(a, b, w);
        }

        Arrays.sort(holes);

        // Perform operations
        while (true) {
          int max = greedy(holes, cows);
          if (max != -1) {
            int temp = cows[holes[max].a-1].pos;
            cows[holes[max].a-1].pos = cows[holes[max].b-1].pos;
            cows[holes[max].b-1].pos = temp;
          } else {
            break;
          } 
        }

        if (minimum == Integer.MAX_VALUE) {
          pr.println(-1);
        } else {
          pr.println(minimum);
        }

        pr.close();
    }

    static int greedy(Wormhole[] arr, Pair[] cows) {
        for (int i = arr.length - 1; i >= 0; i--) {
          int min = Math.min(arr[i].a, arr[i].b);
          int max = Math.max(arr[i].a, arr[i].b);
          if (cows[min-1].pos - cows[max-1].pos > 0) {
            minimum = arr[i].w < minimum ? arr[i].w : minimum;
            return i;
          }
        }
        return -1;
    }

  static class Wormhole implements Comparable<wormsort.Wormhole> {
    int a, b, w;
    public Wormhole(int a, int b, int w) {
      this.a = a;
      this.b = b;
      this.w = w;
    }

    @Override
    public int compareTo(Wormhole hole) {
      return w - hole.w;
    }
  }
    

	static class Pair implements Comparable<wormsort.Pair> {
		int num = 0, pos = 0;
		public Pair(int num, int pos) {
			this.num = num;
			this.pos = pos;
		}

		@Override
		public int compareTo(Pair o) {
			return num - o.num;
		}
	}

	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException 
        { 
            br = new BufferedReader(new FileReader(new File("wormsort.in"))); 
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
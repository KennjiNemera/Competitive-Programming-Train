import java.util.*;
import java.io.*;

public class USB {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader();
    int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();
    int m = fr.nextInt();
    long cost = 0;
    long count = 0;

    PriorityQueue<Integer> usb = new PriorityQueue<>();
    PriorityQueue<Integer> ps2 = new PriorityQueue<>();

    for (int i = 0; i < m; i++) {
      String[] in = fr.nextLine().split(" ");
      if (in[1].equals("USB")) {
        usb.offer(Integer.parseInt(in[0]));
      } else ps2.offer(Integer.parseInt(in[0]));
    }

    while (!usb.isEmpty() || !ps2.isEmpty() && a > 0 || b > 0) {    
      boolean flag = false;
      // if there are type specific computers then we need to subtract from them else we pick min;
      if (a > 0 && !usb.isEmpty()) {
        cost += usb.poll();
        count++;
        a--;
        flag = true;
      }
      if (b > 0 && !ps2.isEmpty()) {
        cost += ps2.poll();
        count++;
        b--;
        flag = true;
      }
      if (!flag) {
        // System.out.println(a + " " + b);
        break;
      }
    }

    while (c > 0 && !ps2.isEmpty() || !usb.isEmpty()) {
      if (c == 0) break;
      if (usb.isEmpty() && !ps2.isEmpty()) {
        cost += ps2.poll();
      } else if (!usb.isEmpty() && ps2.isEmpty()) {
        cost += usb.poll();
      } else {
        if (usb.peek() > ps2.peek()) {
          cost += ps2.poll();
        } else cost += usb.poll();
      }
      c--;
      count++; 
    }
    System.out.println(count + " " + cost);
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

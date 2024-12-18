import java.util.*;
import java.io.*;

public class RoomAllocation {

  static int[] ans;
  public static void main(String[] args) {
    FastReader fr = new FastReader();
    PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n = fr.nextInt();
    ans = new int[n];
    Customer[] rawArr = new Customer[n];
    for (int i = 0; i < n; i++) {
      String[] in = fr.nextLine().split(" ");
      rawArr[i] = new Customer(new Pair(Integer.parseInt(in[0]), Integer.parseInt(in[1])), i);
    }
    Customer[] arr = rawArr;
    Arrays.sort(arr);
    int rooms = 0;
    int lastRoom = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<>(); 
    for (int i = 0; i < n; i++) {
      if (pq.isEmpty()) {
        lastRoom++;
        pq.offer(new Pair(-(arr[i].a.y), lastRoom)); // Adds the departure time and the room number to the min heap. Making the departure time negative sorts the priority queue for us.
        ans[arr[i].y] = lastRoom;
      } else {
        Pair p = pq.peek();
        System.out.println("Pair: " + p.x + " " + p.y);
        if (-p.x < arr[i].a.x) {
          pq.poll();
          pq.offer(new Pair(arr[i].a.y, p.y));
          ans[arr[i].y] = p.y;  
        } else {
          lastRoom++;
          pq.offer(new Pair(arr[i].a.y, lastRoom));
          ans[arr[i].y] = lastRoom;  
        }
      }

      rooms = Math.max(rooms, pq.size());
    }

    for (Integer i : ans) {
     sb.append(i + " ");
    }
    pr.println(rooms);
    pr.println(sb.toString());
    pr.close();
  }

  static class Pair implements Comparable<RoomAllocation.Pair> {
    int x, y;
    public Pair (int x, int y) {
      this.x = x;
      this.y = y;
    }
    @Override
    public int compareTo(Pair a) {
      return x  - a.x;
    }
  }

  static class Customer implements Comparable<RoomAllocation.Customer> {
    Pair a;
    int y;
    public Customer(Pair a, int y) {
      this.a = a;
      this.y = y;
    }
    @Override
    public int compareTo(Customer c) {
      return a.x - c.a.x;
    }
  }

  static class FastReader 
  { 
      BufferedReader br; 
      StringTokenizer st; 

      public FastReader()
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


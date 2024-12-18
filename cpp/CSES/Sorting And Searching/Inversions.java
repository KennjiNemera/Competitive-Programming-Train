import java.io.*;
import java.util.*;

class Inversions {
   public static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
   public static String s;
   public static int m;
   public static TreeSet<Integer> dif = new TreeSet<Integer>();
   public static int cnt[];
   public static void add(int x){
      cnt[x]++;
      pq.add(x);
   }
   public static void modify(int x){
      if(x == 0 || x == s.length()) return;
      if(dif.contains(x)){ // x is currently present in dif, remove it
         int a = dif.lower(x), b = dif.higher(x);
         cnt[x-a]--; cnt[b-x]--; // update ret
         add(b-a);
         dif.remove(x); // remove x from dif
      }
      else{
        dif.add(x); // insert x into dif
        int a = dif.lower(x), b = dif.higher(x);
        cnt[b-a]--; // update ret
        add(x-a); add(b-x);
      }
   }
   public static void main(String[] args) throws IOException
   {
      BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      s = sc.readLine();
      m = Integer.parseInt(sc.readLine());
      cnt = new int[s.length()+1];
      dif.add(0); dif.add(s.length());
      for (int i = 0; i < s.length() -1; i++){
         if(s.charAt(i) != s.charAt(i+1)) dif.add(i+1); // initialize dif
      }
      for (int it : dif){
         if(dif.higher(it) != null){
            add(dif.higher(it) - it);
         }
      }
      StringTokenizer st = new StringTokenizer(sc.readLine());
      for (int i = 0; i < m; i++){
         int x = Integer.parseInt(st.nextToken()); // 1-indexed position
         modify(x-1); modify(x);
         while(cnt[pq.peek()] == 0) pq.poll();
         // pop elements that should no longer be present in priority queue
         out.print(pq.peek() + " ");
      }
      out.close();
   }

}
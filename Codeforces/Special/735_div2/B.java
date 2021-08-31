import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class B {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt(); long k = fr.nextLong();

            TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
            ArrayList<Integer> dist = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int a = fr.nextInt();

                if (!map.containsKey(a)) {
                    map.put(a, new PriorityQueue<>());
                    dist.add(a);
                }

                map.get(a).offer(i+1);

            }

            Collections.sort(dist);
            
            long ans = Integer.MIN_VALUE;

            for (int i = 0; i < dist.size(); i++) {
                int a = dist.get(i);
                for (int j = i; j < i + 2 && j < dist.size() ; j++) {
                    int b = dist.get(j);
                    if (j == i && map.get(a).size() > 1) {
                        int save = map.get(a).poll();
                        int use = map.get(a).peek();
                        map.get(a).offer(save);

                        long temp = use * save - k * (a);
                        ans = Math.max(temp, ans);
                    } else if (j != i) {
                        int prod = map.get(a).peek() * map.get(b).peek();
                        long temp = prod - k * (a | b);
                        ans = Math.max(temp, ans);
                    }
                }
            }

            pr.println(ans);
        }

        pr.close();
    }

    static class Comp implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return Long.compare(a.x, b.x);
        }
    }

    static class Pair {
        long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    // MERGE SORT IMPLEMENTATION
    void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            // call merge
            merge(arr, l, m, r);
        }
    }

    void merge(int[] arr, int l, int m, int r) {
        // find sizes
        int len1 = m - l + 1;
        int len2 = r - m;

        int[] L = new int[len1];
        int[] R = new int[len2];

        // push to copies
        for (int i = 0; i < L.length; i++)
            L[i] = arr[l + i];
        for (int i = 0; i < R.length; i++) {
            R[i] = arr[m + 1 + i];
        }

        // fill in new array
        int i = 0, j = 0;
        int k = l;
        while(i < len1 && j < len2) {
            if (L[i] < R[i]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[i];
                j++;
            }
            k++;
        }

        // add remaining elements
        while (i < len1) {
            arr[k] = L[i];
            i++;k++;
        }

        while (j < len2) {
            arr[k] = R[j];
            j++; k++;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

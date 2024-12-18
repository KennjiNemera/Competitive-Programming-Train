import java.util.*;
import java.io.*;

public class decryption {

	static ArrayList<String> dict;
	static HashSet<Integer> len;

	public static void main(String[] args) {

		FastReader fr = new FastReader();
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

		int n = fr.nextInt();
		len = new HashSet<Integer>();
		
		String str = null;
		String[] sen = new String[n];

		for (int i = 0; i < n; i++) {
			String temp = fr.next();

			if (str == null) str = temp;
			else {
				if (str.length() >= temp.length()) {
					str = temp;
				}
			}
			
			len.add(temp.length());
			
			sen[i] = temp;
		}

		// sort the shortest word
		str = sort(str);

		ArrayList<String> temp = new ArrayList<String>();

		for (int i = 0; i <= 25; i++) {
			temp.add(sort(caeser(str, i)));
		}

		dict = new ArrayList<>();

		int k = -1;

		for (int i = 0; i < 71778; i++) {
			String next = fr.next();
			if (len.contains(next.length())) {
				dict.add(next);
			} else continue;

			if (k == -1) {
				if (next.length() == str.length()) {
					next = sort(next);

					int ind = temp.indexOf(next);

					if (ind != -1) {
						k = ind;
					}
				}
			}
		}

		Collections.sort(dict, (a, b) -> a.length() - b.length());

		// what do we do now that we have k

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String search = sort(caeser(sen[i], k));
			int first = lowerbound(search.length());
			int len = search.length();

			while (dict.get(first).length() == len) {
				String get = dict.get(first);
				if (sort(get).equals(search)) {
					sb.append(get + " ");
					break;
				}
				first++;
			}
		}

		pr.println((26 - k) % 26);
		pr.println(sb.toString().trim());

		pr.close();

	}

	static int lowerbound(int size) {
		int lo = 0;
		int hi = dict.size()-1;
		int ans = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (dict.get(mid).length() >= size) {
				hi = mid - 1;
				ans = mid;
			} else
				lo = mid + 1;
		}
		return ans;
	}

	static String sort(String str) {
		char[] c = str.toCharArray();

		Arrays.sort(c);

		String st = "";
		for (char d : c) {
			st += d;
		}

		return st;
	}

	static String caeser(String str, int rotate) {
		String out = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			char temp = (char) (c + rotate);

			if (temp > 'Z')
				temp -= 26;

			out += temp;

		}
		return out;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
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

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
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

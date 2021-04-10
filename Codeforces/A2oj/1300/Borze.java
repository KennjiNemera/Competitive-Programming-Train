import java.util.*;

public class Borze {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		String out = "";

		for (int i = 0; i < in.length(); ++i)
		{
			switch(in.charAt(i))
			{
				case '-':
					if (i != in.length()-1) {
						if (in.charAt(i+1) == '.') {
							out += "1";
							i++;
						} else if (in.charAt(i+1) == '-') {
							out += "2";
							i++;
						}						
					}
					break;
				case '.':
					out += "0";
					break;
			}
		}

		System.out.println(out);
	}
}
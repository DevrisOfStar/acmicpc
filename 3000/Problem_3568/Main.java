package Problem_3568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str, ", ");
		String common = st.nextToken();
		String temp;
		StringBuilder sb;
		StringBuilder sb2;
		do {
			sb = new StringBuilder();
			sb2 = new StringBuilder();
			temp = st.nextToken();
			for(int i = 0; i<temp.length();i++) {
				if(temp.charAt(i) == '[') sb.append(']');
				else if(temp.charAt(i) == ']') sb.append('[');
				else if(temp.charAt(i) == ';') continue;
				else if(temp.charAt(i)-'A' >= 0 && temp.charAt(i) - 'A' < 26) sb2.append(temp.charAt(i));
				else if(temp.charAt(i)-'a' >= 0 && temp.charAt(i) - 'a' < 26) sb2.append(temp.charAt(i));
				else sb.append(temp.charAt(i));
			}
			System.out.println(common + sb.reverse().toString() + " " + sb2.toString()+";");
		}while(!temp.contains(";"));
	}
}

package Problem_17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, ">");
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for(;st.hasMoreTokens();) {
			String temp = st.nextToken();
			if(temp.contains("<")) {
				int t = temp.indexOf("<");
				String sub1 = temp.substring(0, t);
				String sub2 = temp.substring(t);
				if(sub1.length() != 0) {
					StringTokenizer st2 = new StringTokenizer(sub1);
					for(;st2.hasMoreTokens();) {
						sb2.append(st2.nextToken());
						sb.append(sb2.reverse().toString());
						if(st2.hasMoreTokens()) sb.append(" ");
						sb2.setLength(0);	
					}
				}
				sb.append(sub2).append(">");
			}
			else {
				StringTokenizer st2 = new StringTokenizer(temp);
				for(;st2.hasMoreTokens();) {
					sb2.append(st2.nextToken());
					sb.append(sb2.reverse().toString());
					if(st2.hasMoreTokens()) sb.append(" ");
					sb2.setLength(0);	
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}
}

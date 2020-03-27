package Problem_4900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static String[] number = {"063", "010", "093", "079", "106", "103", "119", "011", "127", "107"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		long a_,b_;
		int idx;
		while(!str.equals("BYE")) {
			StringTokenizer st = new StringTokenizer(str,"+");
			String a = st.nextToken();
			String b = st.nextToken().replace('=', '\0');
			Stack<Long> s = new Stack<>();
			
			a_ = 0;
			b_ = 0;
			for(int i = 3; i<=a.length();i=i+3) {
				String n = a.substring(i-3, i);
				for(int j = 0; j<10; j++) {
					if(number[j].equals(n)) {
						a_ = a_*10 + j;
						break;
					}
				}
				
			}
			
			for(int i = 3; i<=b.length();i=i+3) {
				String n = b.substring(i-3, i);
				for(int j = 0; j<10; j++) {
					if(number[j].equals(n)) {
						b_ = b_*10 + j;
						break;
					}
				}
			}
			
			a_ +=b_;
			do {
				s.add(a_%10);
				a_/=10;
			} while(a_!=0);
			
			
			while(!s.isEmpty()) {
				idx = s.pop().intValue();
				str += number[idx];
			}
			sb.append(str).append("\n");
			
			str = br.readLine();
		}
		
		System.out.println(sb.toString());
		
		
	}
}

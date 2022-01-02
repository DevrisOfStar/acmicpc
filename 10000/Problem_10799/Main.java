package Problem_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<Character> st = new Stack<>();
		int answer = 0;
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') st.add(c);
			else {
				st.pop();
				if(str.charAt(i-1) == '(') answer += st.size();
				else answer++;
			}
		}
		System.out.println(answer);	
	}
}

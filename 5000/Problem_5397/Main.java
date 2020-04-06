package Problem_5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for(int i = 0; i < str.length(); i++) {
				switch(str.charAt(i)) {
				case'<':
					if(!left.isEmpty()) {
						right.add(left.pop());
					}
					break;
				case'>':
					if(!right.isEmpty()) {
						left.add(right.pop());
					}
					break;
				case'-':
					if(!left.isEmpty()) left.pop();
					break;
				default:
					left.add(str.charAt(i));
					break;
				}
				
				
			}
			while(!left.isEmpty()) right.add(left.pop());
			StringBuilder sb = new StringBuilder();
			while(!right.isEmpty()) sb.append(right.pop());
			System.out.println(sb.toString());
		}

	}
}

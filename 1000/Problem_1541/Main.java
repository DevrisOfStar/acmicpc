package Problem_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int value = 0;
		int number = 0;
		Queue<Integer> q_n = new LinkedList<>();
		Queue<Character> q_s = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int i =0; i<str.length();i++) {
			switch(str.charAt(i)) {
			case '-':				
			case '+':
				q_n.add(number);
				q_s.add(str.charAt(i));
				number = 0;
				break;
			default:
				number = number * 10 + str.charAt(i) - '0';
				
			}
		}
		
		q_n.add(number);
		number = 0;
		
		value = q_n.poll();
		
		while(!q_n.isEmpty()) {
			char c = q_s.poll();
			int num = q_n.poll();
			
			if(c == '-') {
				if(stack.isEmpty()) {
					stack.add(num);
				}else {
					stack.add(stack.pop() + num);
				}
			}
			else if(c == '+') {
				if(stack.isEmpty()) value += num;
				else stack.add(stack.pop() + num);
			}
			
		}
		if(!stack.isEmpty())
		value -= stack.pop();
		System.out.println(value);
		
	}
}

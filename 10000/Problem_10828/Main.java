package Problem_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class myStack {
		int[] stack;
		int top;
		myStack() {
			stack = new int[10001];
			top = -1;
		}
		
		void push(int num) {
			if(top == 10001) return; 
			stack[++top] = num;
		}
		
		int pop() {
			if(top == -1) return -1;
			return stack[top--];
		}
		
		void size() {
			System.out.println(top+1);
		}
		
		int empty() {
			if(top == -1) return 1;
			return 0;
		}
		
		int top() {
			if(top == -1) return -1;
			return stack[top];
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		myStack s = new myStack();
		for(int i = 0; i <N; i++) {
			String str = br.readLine();
			
			if(str.contains("push")) {
				s.push(Integer.parseInt(str.split(" ")[1]));
			}
			else {
				switch(str) {
				case "top":
					System.out.println(s.top());
					break;
				case "size":
					s.size();
					break;
				case "empty":
					System.out.println(s.empty());
					break;
				case "pop":
					System.out.println(s.pop());
					break;
				}
			}
			
		}
	}
}

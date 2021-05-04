package Problem_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int data;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N;i++) {
			str = br.readLine();
			switch(str.split(" ")[0]) {
			case "add":
				add(Integer.parseInt(str.split(" ")[1]));
				break;
			case "remove":
				remove(Integer.parseInt(str.split(" ")[1]));
				break;
			case "check":
				sb.append(check(Integer.parseInt(str.split(" ")[1]))?1:0).append("\n");
				break;
			case "toggle":
				toggle(Integer.parseInt(str.split(" ")[1]));
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void add(int x) {
		data |= 1 << x;
	}
	
	public static void remove(int x) {
		int temp = ((1<<21) -1) - (1<<x);
		data &= temp;
	}
	
	public static boolean check(int x) {
		if((data & (1<<x)) == (1<<x)) return true;
		else return false;
	}
	
	public static void toggle(int x) {
		if(check(x)) remove(x);
		else add(x);
	}
	
	public static void all() {
		data = ((1<<21) -1);
	}
	public static void empty() {
		data = 0;
	}
}

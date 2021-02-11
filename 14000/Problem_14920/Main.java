package Problem_14920;

import java.util.Scanner;

public class Main {
	static int n;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer(n);	
		System.out.println(cnt);
	}
	
	public static void answer(int n) {
		for(int t = n;t!=1;) {
			if(t%2 == 0) t = t/2;
			else t = t*3 + 1;
			cnt++;
		}
		cnt++;
	}
}

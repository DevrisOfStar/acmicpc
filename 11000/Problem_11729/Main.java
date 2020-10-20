package Problem_11729;

import java.util.Scanner;

public class Main {
	static int number;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println( (1 << N) - 1);
		StringBuilder sb = new StringBuilder();
		solve(N, 1, 3, sb);
		System.out.println(sb.toString());
	}
	
	public static void solve(int n, int x, int y, StringBuilder sb) {
		if(n == 0) return;
		
		solve(n-1, x, 6-x-y, sb);
		sb.append(x + " " + y + "\n");
		solve(n-1, 6-x-y, y, sb);
	}
}

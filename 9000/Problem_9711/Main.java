package Problem_9711;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long P, Q;
		long a, b, c = 0;
		StringBuilder sb = new StringBuilder();
		for(int k = 1; k <= N; k++) {
			sb.append("Case #").append(k).append(": ");
			P = sc.nextLong(); Q = sc.nextLong();
			a = 0; b = 1;
			for(int i = 1 ; i<=P;i++) {
				c = (a + b) % Q;
				b = a;
				a = c;
			}
			sb.append(c).append("\n");
		}
		System.out.print(sb.toString());
	}
}

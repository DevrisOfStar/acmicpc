package Problem_11006;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, M;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			N = sc.nextInt(); M = sc.nextInt();
			sb.append(M*2 - N).append(" ").append(N-M).append("\n");
		}
		System.out.println(sb.toString());
	}
}

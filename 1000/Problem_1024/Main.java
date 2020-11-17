package Problem_1024;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();

		for (int i = L; i <= 100; i++) {
			int t = N - (i * (i + 1) / 2);
			int x = t / i;
			if (t % i == 0) {
				if (x + 1 >= 0) {
					StringBuilder sb = new StringBuilder();
					for (int k = 1; k <= i; k++) sb.append(x + k).append(" ");
					System.out.println(sb.toString().trim());
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
package Problem_9625;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] dp_a = new int[46];
		int[] dp_b = new int[46];
		dp_a[0] = 1;
		for(int k = 1; k<=K; k++) {
			dp_a[k] = dp_b[k-1];
			dp_b[k] = dp_a[k-1] + dp_b[k-1];
		}
		System.out.println(dp_a[K] + " " + dp_b[K]);
	}
}
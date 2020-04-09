package Problem_1793;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;


public class Main {
	static BigInteger[] dp = new BigInteger[251];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 251; i++)
			dp[i] = BigInteger.ZERO; // init

		dp[0] = BigInteger.valueOf(1);
		dp[1] = BigInteger.valueOf(1);
		while (sc.hasNextInt()) {
			int N = Integer.parseInt(sc.nextLine().trim());
			for (int i = 2; i <= N; i++) {
				if (dp[i].toString().equals("0")) {
					dp[i] = dp[i].add(dp[i - 1]);
					dp[i] = dp[i].add(dp[i - 2]);
					dp[i] = dp[i].add(dp[i - 2]);
				}
			}

			System.out.println(dp[N].toString());

		}
	}
}

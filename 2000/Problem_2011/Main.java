package Problem_2011;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		char[] str = string.toCharArray();

		long[] dp = new long[str.length + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= str.length; i++) {
			if (str[i - 1] - '0' > 0)
				dp[i] = dp[i - 1];

			int now = (str[i - 2] - '0') * 10 + (str[i - 1] - '0');
			if (now >= 10 && now <= 26) {
				dp[i] = (dp[i] + dp[i - 2]) % 1000000;
			}

		}
		if (str[0] == '0') {
			System.out.println("0");
		} else {
			System.out.println(dp[str.length]);
		}

	}
}

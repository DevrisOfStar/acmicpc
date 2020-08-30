package Problem_12886;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int a, b, c, d;
	static boolean[][] isvisited;

	public static void solve(int a, int b) {
		if (isvisited[a][b])
			return;
		isvisited[a][b] = true;

		int[] rock = { a, b, d - a - b };

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (rock[i] < rock[j]) {
					int[] temp = { a, b, d - a - b };
					temp[i] += rock[i];
					temp[j] -= rock[i];
					solve(temp[0], temp[1]);
				}

			}
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = a + b + c;
		isvisited = new boolean[d][d];
		if (d % 3 != 0) {
			System.out.println("0");
			System.exit(0);
		}

		solve(a, b);

		System.out.println(isvisited[d / 3][d / 3] == false ? "0" : "1");

	}
}

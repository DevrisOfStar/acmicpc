package Problem_15645;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[3];
		int[] tmp = new int[3];
		int[] dp_x = new int[3]; // max
		int[] dp_n = new int[3]; // min

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) arr[j] = sc.nextInt();
			tmp[0] = Math.min(dp_n[0] + arr[0], dp_n[1] + arr[0]);
			tmp[1] = Math.min(Math.min(dp_n[0] + arr[1], dp_n[1] + arr[1]), dp_n[2] + arr[1]);
			tmp[2] = Math.min(dp_n[2] + arr[2], dp_n[1] + arr[2]);
			for (int j = 0; j < 3; j++) dp_n[j] = tmp[j];

			tmp[0] = Math.max(dp_x[0] + arr[0], dp_x[1] + arr[0]);
			tmp[1] = Math.max(Math.max(dp_x[0] + arr[1], dp_x[1] + arr[1]), dp_x[2] + arr[1]);
			tmp[2] = Math.max(dp_x[2] + arr[2], dp_x[1] + arr[2]);
			for (int j = 0; j < 3; j++) dp_x[j] = tmp[j];
		}

		int max, min;
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) if (max < dp_x[i]) max = dp_x[i];
		for (int i = 0; i < 3; i++) if (min > dp_n[i]) min = dp_n[i];
		System.out.println(max + " " + min);

	}
}

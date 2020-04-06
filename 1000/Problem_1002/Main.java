package Problem_1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		double k = 0;
		double r = 0;
		String str;
		int answer = 0;
		for (int t = 1; t <= T; t++) {
			str = br.readLine();
			for (int i = 0; i < 6; i++)
				arr[i] = Integer.parseInt(str.split(" ")[i]);
			k = Math.sqrt(Math.pow(arr[4] - arr[1], 2) + Math.pow(arr[3] - arr[0], 2));
			r = arr[2] + arr[5];
			if (arr[0] == arr[3] && arr[1] == arr[4] && arr[2] == arr[5])
				answer = -1;
			else if (k < r) {
				double l = Math.abs(arr[2] - arr[5]);
				if (l < k) {
					answer = 2;
				} else if (l == k) {
					answer = 1;
				} else {
					answer = 0;
				}
			} else if (k == r) {
				answer = 1;
			}

			else {
				answer = 0;
			}

			System.out.println(answer);
		}
	}
}

package Problem_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	static int[] Symbol;
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	static void answer(int idx, int sum) {
		if (idx == N - 1) {
			if (max < sum)
				max = sum;
			if (min > sum)
				min = sum;
		} else {
			int sum_temp = sum;
			for (int i = 0; i < 4; i++) {
				if (Symbol[i] != 0) {
					Symbol[i]--;
					switch (i) {
					case 0:
						answer(idx + 1, sum + arr[idx + 1]);
						break;
					case 1:
						answer(idx + 1, sum - arr[idx + 1]);
						break;
					case 2:
						answer(idx + 1, sum * arr[idx + 1]);
						break;
					case 3:
						if (arr[idx + 1] != 0)
							answer(idx + 1, sum / arr[idx + 1]);
						break;

					}
					Symbol[i]++;
				}
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int idx = 0;
		for (String str : br.readLine().split(" ")) {
			arr[idx++] = Integer.parseInt(str);
		}
		idx = 0;
		Symbol = new int[4];
		for (String str : br.readLine().split(" ")) {
			Symbol[idx++] = Integer.parseInt(str);
		}

		answer(0, arr[0]);
		System.out.println(max);
		System.out.println(min);

	}
}

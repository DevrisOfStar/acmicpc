package Problem_13702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int K;

	static int[] arr;

	public static int ans(int num) {
		int start = 0;
		int end = num;
		int mid;
		int ans = Integer.MIN_VALUE;
		while (start <= end) {
			mid = (start + end) / 2;
			int cnt = 0;
			for (int i = 0; i < N; i++)
				cnt += (arr[i] / mid);
			if (cnt >= K) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return end;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		N = Integer.parseInt(str.split(" ")[0]);
		K = Integer.parseInt(str.split(" ")[1]);
		arr = new int[N];

		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i])
				max = arr[i];
		}

		System.out.println(ans(max));

	}
}

package Problem_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, arr_;
	static int[] answer;

	public static int ans(int idx) { // Lower bound
		int target = arr_[idx];
		int start = 0;
		int end = arr.length - 1;
		int mid;

		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}

	public static int ans2(int idx) { // Upper bound
		int target = arr_[idx];
		int start = 0;
		int end = arr.length - 1;
		int mid;

		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		arr_ = new int[M];
		answer = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			arr_[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int lower = ans(i);
			int upper = ans2(i);

			if (upper == N - 1 && arr[N - 1] == arr_[i]) // last boundary value.
				upper++;

			answer[i] = upper - lower;
		}

		for (int i = 0; i < M; i++) {
			sb.append(answer[i]).append(" ");
		}

		System.out.println(sb);

	}
}

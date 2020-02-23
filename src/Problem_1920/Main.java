package Problem_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[] arr;
	static int[] arr_;
	static StringBuilder sb = new StringBuilder();

	static void ans(int target) {
		int start = 0;
		int end = N - 1;
		int mid;
		boolean isSelect = false;
		while (end - start >= 0) {
			mid = (start + end) / 2;

			if (arr[mid] == target) {
				sb.append("1\n");
				isSelect = true;
				return;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		if (!isSelect)
			sb.append("0\n");
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		arr_ = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++)
			arr_[i] = Integer.parseInt(st.nextToken());
		int target;

		for (int i = 0; i < M; i++) {
			target = arr_[i];
			ans(target);
		}	

		System.out.println(sb);
	}
}

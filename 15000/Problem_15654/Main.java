package Problem_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] arr;
	public static int[] idx;
	public static boolean[] tr;
	public static StringBuilder sb;

	public static void ans(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				sb.append(arr[idx[i]]).append(" ");
			sb.append("\n");
		} else {
			for (int i = 0; i < N; i++) {
				if (!tr[i]) {
					idx[cnt] = i;
					tr[i] = true;
					ans(cnt + 1);
					tr[i] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		sb = new StringBuilder();
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);

		buffer = br.readLine();
		StringTokenizer st = new StringTokenizer(buffer, " ");
		arr = new int[N];
		tr = new boolean[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		idx = new int[M];
		Arrays.sort(arr);
		ans(0);
		System.out.print(sb.toString());
	}
}

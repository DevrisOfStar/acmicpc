package Problem_1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		int cnt = 0;
		int idx = -1;
		int answer = Integer.MAX_VALUE;
		int N = Integer.parseInt(buf.split(" ")[0]);
		int M = Integer.parseInt(buf.split(" ")[1]);
		int map[][] = new int[N][M];
		boolean[] chk = new boolean[M];

		for (int i = 0; i < N; i++) {
			buf = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(buf.split(" ")[j]);
			}
		}

		for (int c = 0; c < N; c++) {
			int cur = N - 1;

			Arrays.fill(chk, false);
			for (int i = 0; i < N; i++) {
				cnt = 0;
				idx = -1;
				if (i == c)
					continue;
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0) {
						cnt++;
						idx = j;
					}
				}
				if (cnt == 0)
					cur--;
				if (cnt == 1)
					chk[idx] = true;
			}

			int t = 0;
			for (int i = 0; i < M; i++)
				if (chk[i])
					t++;
			answer = Math.min(answer, cur - t);
		}
		System.out.println(answer);
	}
}

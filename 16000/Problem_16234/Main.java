package Problem_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] arr;
	static boolean[][] isvisited;
	static int N, L, R;

	public static void solve() {
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> t_data = new LinkedList<>();
		int cnt = 0;
		boolean flag = true;
		while (flag) {
			int num = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = 0;
					int ea = 0;
					if (!isvisited[i][j]) {
						q.add(new int[] { i, j });
						t_data.add(new int[] { i, j });
						isvisited[i][j] = true;
						sum += arr[i][j];
						ea++;
						num++;
					}
					while (!q.isEmpty()) {
						int[] data = q.poll();
						for (int k = 0; k < 4; k++) {
							int dx_ = data[0] + dx[k];
							int dy_ = data[1] + dy[k];

							if (dx_ < 0 || dy_ < 0 || dx_ >= N || dy_ >= N)
								continue;
							int sub = Math.abs(arr[data[0]][data[1]] - arr[dx_][dy_]);
							if (L > sub || R < sub)
								continue;
							if (isvisited[dx_][dy_])
								continue;
							q.add(new int[] { dx_, dy_ });
							t_data.add(new int[] { dx_, dy_ });
							isvisited[dx_][dy_] = true;
							ea++;
							sum += arr[dx_][dy_];

						}
					}
					if (ea != 0 && ea != 1) {

						sum /= ea;
						
						while (!t_data.isEmpty()) {

							int[] data = t_data.poll();
							arr[data[0]][data[1]] = sum;
						}
					
					} else {
						while (!t_data.isEmpty()) {
							t_data.poll();
						}
					}
				}
			} // end for
			if (num == N * N) {
				flag = false;
			}
			if (flag) {
				cnt++;
				for(int i = 0; i<N;i++) Arrays.fill(isvisited[i], false);
			}
			
			
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		L = Integer.parseInt(str.split(" ")[1]);
		R = Integer.parseInt(str.split(" ")[2]);

		arr = new int[N][N];
		isvisited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		solve();
	}
}

package Problem_16946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
	static int N, M;
	static boolean[][] map;
	static boolean[][] isvisited;
	static int[][] zero_num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		map = new boolean[N][M]; // 1 true, 0 false
		isvisited = new boolean[N][M];
		zero_num = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) == '1' ? true : false;
			}
		}

		answer();
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void answer() {
		Queue<int[]> q = new LinkedList<>();
		ArrayList<Integer> zero_list = new ArrayList<>();
		zero_list.add(0);

		int zero_idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				if (!map[i][j] && !isvisited[i][j]) {
					cnt++;
					zero_num[i][j] = ++zero_idx;
					q.add(new int[] { i, j });
					isvisited[i][j] = true;

					while (!q.isEmpty()) {
						int[] data = q.poll();
						for (int k = 0; k < 4; k++) {
							int dx_ = data[0] + dx[k];
							int dy_ = data[1] + dy[k];

							if (dx_ < 0 || dy_ < 0 || dx_ >= N || dy_ >= M)
								continue;
							if (isvisited[dx_][dy_])
								continue;
							if (map[dx_][dy_])
								continue;

							cnt++;
							q.add(new int[] { dx_, dy_ });
							isvisited[dx_][dy_] = true;
							zero_num[dx_][dy_] = zero_idx;

						}
					}
				}

				if (cnt != 0) {
					zero_list.add(cnt);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int cnt_0 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i][j]) {
					sb.append("0");
					continue;
				}
				Set<Integer> set = new HashSet<>(); // set을 이용하여 고유하게 만들기.
				cnt_0 = 1;

				for (int k = 0; k < 4; k++) {
					int dx_ = i + dx[k];
					int dy_ = j + dy[k];
					if (dx_ < 0 || dy_ < 0 || dx_ >= N || dy_ >= M)
						continue;
					if (map[dx_][dy_])
						continue;
					set.add(zero_num[dx_][dy_]);
					
				}
				for (int id: set) {
					cnt_0 += zero_list.get(id);
				}
					
				
				sb.append(cnt_0%10);
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString());
	}

}

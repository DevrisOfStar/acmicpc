package Problem_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	// 11 : 26
	static int R, C;
	static int sr, sc, dr, dc;
	static int[][] map;
	static boolean[][] isvisited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<int[]> q_w = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		R = Integer.parseInt(buffer.split(" ")[0]);
		C = Integer.parseInt(buffer.split(" ")[1]);
		map = new int[R][C];
		isvisited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			buffer = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = buffer.charAt(j);
				switch (c) {
				case '*':
					map[i][j] = 1;
					q_w.add(new int[] { i, j });
					break;
				case 'X':
					map[i][j] = 2;
					break;
				case 'D':
					dr = i;
					dc = j;
					break;
				case 'S':
					sr = i;
					sc = j;
					break;
				default:
					break;
				}

			}
		}

		solve();
	}

	public static void solve() {
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		q.add(new int[] { sr, sc });
		isvisited[sr][sc] = true;

		while (!q.isEmpty()) {
			// 물 확산
			int size = q_w.size();
			for (int i = 0; i < size; i++) {
				int[] data = q_w.poll();
				for (int k = 0; k < 4; k++) {
					int r_ = data[0] + dx[k];
					int c_ = data[1] + dy[k];

					if (r_ < 0 || r_ >= R || c_ < 0 || c_ >= C)
						continue;
					if (r_ == dr && c_ == dc)
						continue;
					if (map[r_][c_] == 0) {
						q_w.add(new int[] { r_, c_ });
						map[r_][c_] = 1;
					}
				}
			}
			
			size = q.size();
			for (int i = 0; i < size; i++) {
				int[] data = q.poll();
				if (data[0] == dr && data[1] == dc) {
					System.out.println(cnt);
					return;
				}
				// 고슴도치 이동
				for (int k = 0; k < 4; k++) {
					int r_ = data[0] + dx[k];
					int c_ = data[1] + dy[k];

					if (r_ < 0 || r_ >= R || c_ < 0 || c_ >= C)
						continue;

					if (!isvisited[r_][c_] && map[r_][c_] == 0) {
						q.add(new int[] { r_, c_ });
						isvisited[r_][c_] = true;
					}
				}
			}

			cnt++;
		}

		// fail
		System.out.println("KAKTUS");
	}
}

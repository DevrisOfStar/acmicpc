package Problem_1799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, -1 };
	static int[] dy = { -1, 1 };
	static int N;
	static int[][] colors, map;
	static boolean[][] isvisited;
	static int[] answer = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		colors = new int[N][N];
		map = new int[N][N];
		isvisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 1 : black, 0 : white
				if (i % 2 == 0) { if (j % 2 == 0) colors[i][j] = 1; }
				else if (j % 2 == 1) { colors[i][j] = 1; }
			}
		}
		dfs(0, 0, 0);
		dfs(0, 0, 1);
		System.out.println(answer[0] + answer[1]);
	}

	static void dfs(int idx, int cnt, int color) {
		if (answer[color] < cnt) answer[color] = cnt;

		for (int i = idx; i < N * N; i++) {
			int x = i / N;
			int y = i % N;

			if (colors[x][y] != color || map[x][y] == 0 || !CanPosition(x, y)) continue;
			isvisited[x][y] = true;
			dfs(i + 1, cnt + 1, color);
			isvisited[x][y] = false;
		}
	}

	static boolean CanPosition(int x, int y) {
		for (int i = 0; i < 2; i++) {
			int x_ = x;
			int y_ = y;
			while (true) {
				if (x_ < 0 || y_ < 0 || x_ >= N || y_ >= N) break;
				if (isvisited[x_][y_]) return false;
				x_ = x_ + dx[i];
				y_ = y_ + dy[i];
			}
		}
		return true;
	}
}

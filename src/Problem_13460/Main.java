package Problem_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dir_x = { 0, 0, 1, -1 };
	static int[] dir_y = { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][][][] visited;
	static int r_x, r_y, o_x, o_y, b_x, b_y;

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r_x, r_y, b_x, b_y, 0 });
		visited[r_x][r_y][b_x][b_y] = true;
		int r_dx, r_dy, b_dx, b_dy;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[4] > 10)
				break;

			if (cur[0] == o_x && cur[1] == o_y) {
				return cur[4];
			}
			for (int i = 0; i < 4; i++) {
				r_dx = cur[0];
				r_dy = cur[1];
				b_dx = cur[2];
				b_dy = cur[3];

				while (true) {
					r_dx += dir_x[i];
					r_dy += dir_y[i];

					if (map[r_dx][r_dy] == '#') {
						r_dx -= dir_x[i];
						r_dy -= dir_y[i];
						break;
					} else if (map[r_dx][r_dy] == 'O') {
						break;
					}
				}

				while (true) {
					b_dx += dir_x[i];
					b_dy += dir_y[i];

					if (map[b_dx][b_dy] == '#') {
						b_dx -= dir_x[i];
						b_dy -= dir_y[i];
						break;
					} else if (map[b_dx][b_dy] == 'O') {
						break;
					}
				} // 이동완료

				// 충돌

				if (b_dx == o_x && b_dy == o_y)
					continue;

				if (r_dx == b_dx && r_dy == b_dy) {
					switch (i) {

					case (0):
						if (cur[1] < cur[3])
							r_dy--;
						else
							b_dy--;
						break;
					case (1):
						if (cur[1] < cur[3])
							b_dy++;
						else
							r_dy++;
						break;
					case (2):
						if(cur[0] < cur[2])
							r_dx--;
						else
							b_dx--;
						break;
					case (3):
						if(cur[0] < cur[2])
							b_dx++;
						else
							r_dx++;
						break;
					}
				}
				
				if(!visited[r_dx][r_dy][b_dx][b_dy]) {
					q.add(new int[] {r_dx,r_dy,b_dx,b_dy,cur[4]+1});
					visited[r_dx][r_dy][b_dx][b_dy] = true;
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf;
		int n, m;

		bf = br.readLine();
		n = Integer.parseInt(bf.split(" ")[0]);
		m = Integer.parseInt(bf.split(" ")[1]);

		map = new char[n][m];
		visited = new boolean[n][m][n][m];

		for (int i = 0; i < n; i++) {
			bf = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = bf.charAt(j);
				if (map[i][j] == 'R') {
					r_x = i;
					r_y = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'O') {
					o_x = i;
					o_y = j;
				} else if (map[i][j] == 'B') {
					b_x = i;
					b_y = j;
					map[i][j] = '.';
				}

			}
		}

		int result = bfs();
		System.out.println(result);
	}
}

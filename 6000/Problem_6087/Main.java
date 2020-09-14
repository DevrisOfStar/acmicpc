package Problem_6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int W, H;
	static char[][] map;
	static int sx, sy, ex, ey;
	static int[][][] isvisited;
	// 남 서 북 동
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();

		W = Integer.parseInt(bf.split(" ")[1]);
		H = Integer.parseInt(bf.split(" ")[0]);
		map = new char[W][H];
		isvisited = new int[W][H][4];

		boolean flag = true;
		for (int i = 0; i < W; i++) {
			bf = br.readLine();
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < 4; k++) {
					isvisited[i][j][k] = Integer.MAX_VALUE;
				}
				map[i][j] = bf.charAt(j);
				if (map[i][j] == 'C') {
					if (flag) {
						flag = false;
						sx = i;
						sy = j;
					} else {
						ex = i;
						ey = j;
					}
				}
			}
		}

		bfs();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++)
			if (min > isvisited[ex][ey][i])
				min = isvisited[ex][ey][i];
		System.out.println(min);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		// 모든 가능성 삽입
		for (int i = 0; i < 4; i++) {
			q.add(new int[] { sx, sy, i, 0 });
			isvisited[sx][sy][i] = 0;
		}

		while (!q.isEmpty()) {
			int[] data = q.poll();

			for (int i = 1; i <= 3; i += 2) {
				int dir_ = (data[2] + i) % 4;
				int x_ = data[0];
				int y_ = data[1];

				if (isvisited[x_][y_][dir_] > data[3] + 1) {
					q.add(new int[] { x_, y_, dir_, data[3] + 1 });
					isvisited[x_][y_][dir_] = data[3] + 1;
				}
			}

			int x_ = data[0] + dx[data[2]];
			int y_ = data[1] + dy[data[2]];

			if (x_ < 0 || y_ < 0 || x_ >= W || y_ >= H)
				continue;
			if (map[x_][y_] == '*')
				continue;
			if (isvisited[x_][y_][data[2]] > data[3]) {
				q.add(new int[] { x_, y_, data[2], data[3] });
				isvisited[x_][y_][data[2]] = data[3];
			}
		}

	}
}

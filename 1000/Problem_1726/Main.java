package Problem_1726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int M, N;
	static int[][] map;
	static boolean[][][] isvisited;
	static Queue<int[]> q = new LinkedList<>();
	static int a, b, c;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] dir = { { 3, 2 }, { 2, 3 }, { 0, 1 }, { 0, 1 } };

	static void bfs() {
		int t = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] data = q.poll();
				if (data[0] == a && data[1] == b && data[2] == c) {
					System.out.println(t);
					return;
				}
				for (int k = 1; k <= 3; k++) {
					int dx_ = data[0] + k * dx[data[2]];
					int dy_ = data[1] + k * dy[data[2]];

					if (dx_ < 0 || dy_ < 0 || dx_ >= M || dy_ >= N)
						continue;
					if(map[dx_][dy_] == 1) break;
					if (map[dx_][dy_] != 1 && !isvisited[dx_][dy_][data[2]]) {
						q.add(new int[] { dx_, dy_, data[2] });
						isvisited[dx_][dy_][data[2]] = true;
					}
				}

				for (int k = 0; k < 2; k++) {
					int dx_ = data[0];
					int dy_ = data[1];

					if (map[dx_][dy_] != 1 && !isvisited[dx_][dy_][dir[data[2]][k]]) {
						q.add(new int[] { dx_, dy_, dir[data[2]][k] });
						isvisited[dx_][dy_][dir[data[2]][k]] = true;
					}
				}
			}

			t++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		M = Integer.parseInt(str.split(" ")[0]);
		N = Integer.parseInt(str.split(" ")[1]);
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}

		isvisited = new boolean[M][N][4];
		str = br.readLine();
		// start line
		int[] ar = new int[3];
		ar[0] = Integer.parseInt(str.split(" ")[0]);
		ar[1] = Integer.parseInt(str.split(" ")[1]);
		ar[2] = Integer.parseInt(str.split(" ")[2]);
		ar[0]--;
		ar[1]--;
		ar[2]--;

		// end line
		str = br.readLine();
		a = Integer.parseInt(str.split(" ")[0]) - 1;
		b = Integer.parseInt(str.split(" ")[1]) - 1;
		c = Integer.parseInt(str.split(" ")[2]) - 1;
		q.add(new int[] { ar[0], ar[1], ar[2] });
		isvisited[ar[0]][ar[1]][ar[2]] = true;
		bfs();
	}
}

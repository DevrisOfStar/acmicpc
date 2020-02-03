package Problem_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] isvisited;
	static int sh_x, sh_y;
	static int shark_size = 2;
	static int shark_eat = 0;
	static int t = 0;
	static boolean isexisted = true;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void simulate() {
		Queue<int[]> q = new LinkedList<>();
		do {
			int fi_x = N;
			int fi_y = N;
			int min_s = Integer.MAX_VALUE;
			q.add(new int[] { sh_x, sh_y, 0 });
			isvisited[sh_x][sh_y] = true;
			isexisted = false;
			while (!q.isEmpty()) {
				int[] data = q.poll();
				for (int i = 0; i < 4; i++) {
					int x_ = data[0] + dx[i];
					int y_ = data[1] + dy[i];

					if (x_ < 0 || y_ < 0 || x_ >= N || y_ >= N)
						continue;
					if (arr[x_][y_] > shark_size)
						continue;

					if (!isvisited[x_][y_] && arr[x_][y_] < shark_size) {
						q.add(new int[] { x_, y_, data[2] + 1 });
						isvisited[x_][y_] = true;
						

						if (arr[x_][y_] != 0 && min_s > data[2] + 1) {
							isexisted = true;
							fi_x = x_;
							fi_y = y_;
							min_s = data[2] + 1;
						} else if (arr[x_][y_] != 0 && min_s == data[2] + 1 && fi_x > x_) {
							fi_x = x_;
							fi_y = y_;

						} else if (arr[x_][y_] != 0 && min_s == data[2] + 1 && fi_x == x_ && fi_y > y_) {
							fi_x = x_;
							fi_y = y_;
						}
					} else if (!isvisited[x_][y_] && arr[x_][y_] == shark_size) {
						q.add(new int[] { x_, y_, data[2] + 1 });
						isvisited[x_][y_] = true;
					}
				}
			} // end while

			// eat fish
			if (isexisted) {
				shark_eat++;
				t += min_s;
				arr[sh_x][sh_y] = 0;
				arr[fi_x][fi_y] = 9;
				sh_x = fi_x;
				sh_y = fi_y;
				if (shark_eat == shark_size) {
					shark_size++;
					shark_eat = 0;
				}

			}
			// init
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					isvisited[i][j] = false;
				}
			}

		} while (isexisted);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String buffer;
		arr = new int[N][N];
		isvisited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			buffer = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(buffer.split(" ")[j]);
				if (arr[i][j] == 9) {
					sh_x = i;
					sh_y = j;
				}
			}
		}

		simulate();
		System.out.println(t);
	}
}

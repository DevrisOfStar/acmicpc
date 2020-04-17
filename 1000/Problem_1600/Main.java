package Problem_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] h_dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] h_dy = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int K, W, H;
	static int[][] arr;
	static boolean[][][] isvisited;
	static int min = Integer.MAX_VALUE;

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0, 0 }); // x,y,k,cnt
		isvisited[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] data = q.poll();

			if (data[0] == (H - 1) && data[1] == (W - 1)) {
				if (min > data[3])
					min = data[3];
			} else {
				if (data[2] < K) {
					for (int i = 0; i < 8; i++) {
						int d_x = data[0] + h_dx[i];
						int d_y = data[1] + h_dy[i];

						if (d_x < 0 || d_y < 0 || d_x >= H || d_y >= W)
							continue;
						if (arr[d_x][d_y] == 1 || isvisited[d_x][d_y][data[2]+1])
							continue;

						q.add(new int[] { d_x, d_y, data[2] + 1, data[3] + 1 });
						isvisited[d_x][d_y][data[2]+1] = true;
					}
				}
				for (int i = 0; i < 4; i++) {
					int d_x = data[0] + dx[i];
					int d_y = data[1] + dy[i];

					if (d_x < 0 || d_y < 0 || d_x >= H || d_y >= W)
						continue;
					if (arr[d_x][d_y] == 1 || isvisited[d_x][d_y][data[2]])
						continue;

					q.add(new int[] { d_x, d_y, data[2], data[3] + 1 });
					isvisited[d_x][d_y][data[2]] = true;
				}
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		String str = br.readLine();
		W = Integer.parseInt(str.split(" ")[0]);
		H = Integer.parseInt(str.split(" ")[1]);
		arr = new int[H][W];
		isvisited = new boolean[H][W][K+1];
		for (int i = 0; i < H; i++) {
			str = br.readLine();
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}

		bfs();
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}
}

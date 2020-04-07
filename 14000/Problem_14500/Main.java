package Problem_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] ax = { { 0, 0, 0, 0 }, { 0, 1, 2, 3 } };
	static int[][] ay = { { 0, 1, 2, 3 }, { 0, 0, 0, 0 } };
	static int[] bx = { 0, 0, 1, 1 };
	static int[] by = { 0, 1, 0, 1 };
	static int[][] cx = { { 0, 1, 2, 2 }, { 1, 1, 1, 0 }, { 0, 0, 1, 2 }, { 1, 0, 0, 0 },{ 0, 0, 0, 1 }, { 0, 1, 2, 2 }, { 0, 1, 1, 1 }, { 0, 0, 1, 2 } };
	static int[][] cy = { { 0, 0, 0, 1 }, { 0, 1, 2, 2 }, { 0, 1, 1, 1 }, { 0, 0, 1, 2 },{ 0, 1, 2, 2 }, { 1, 1, 1, 0 }, { 0, 0, 1, 2 }, { 1, 0, 0, 0 } };
	static int[][] dx = { { 0, 1, 1, 2 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 }};
	static int[][] dy = { { 0, 0, 1, 1 }, { 0, 1, 1, 2 },{ 0, 1, 1, 2 }, { 1, 1, 0, 0 } };
	static int[][] ex = { { 0, 0, 0, 1 }, { 0, 1, 1, 2 }, { 1, 1, 1, 0 }, { 0, 1, 1, 2 } };
	static int[][] ey = { { 0, 1, 2, 1 }, { 0, 0, 1, 0 }, { 0, 1, 2, 1 }, { 1, 0, 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		int[][] arr = new int[N][M];
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		int x_, y_;
		int max = Integer.MIN_VALUE;

		// ---- 1x4
		for (int t = 0; t < 2; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						x_ = i + ax[t][k];
						y_ = j + ay[t][k];

						if (x_ < 0 || y_ < 0 || x_ >= N || y_ >= M) {
							flag = false;
							break;
						}
						cnt += arr[x_][y_];
					}
					if (flag) {
						if (max < cnt)
							max = cnt;
					} else {
						flag = true;
					}
				}
			}
		}

		// --
		// -- 2x2
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					x_ = i + bx[k];
					y_ = j + by[k];

					if (x_ < 0 || y_ < 0 || x_ >= N || y_ >= M) {
						flag = false;
						break;
					}
					cnt += arr[x_][y_];
				}
				if (flag) {
					if (max < cnt)
						max = cnt;
				} else {
					flag = true;
				}
			}
		}

		// -
		// ---
		for (int t = 0; t < 8; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						x_ = i + cx[t][k];
						y_ = j + cy[t][k];

						if (x_ < 0 || y_ < 0 || x_ >= N || y_ >= M) {
							flag = false;
							break;
						}
						cnt += arr[x_][y_];
					}
					if (flag) {
						if (max < cnt)
							max = cnt;
					} else {
						flag = true;
					}
				}
			}
		}

		// -
		// --
		//  -
		for (int t = 0; t < 4; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						x_ = i + dx[t][k];
						y_ = j + dy[t][k];

						if (x_ < 0 || y_ < 0 || x_ >= N || y_ >= M) {
							flag = false;
							break;
						}
						cnt += arr[x_][y_];
					}
					if (flag) {
						if (max < cnt)
							max = cnt;
					} else {
						flag = true;
					}
				}
			}
		}

		// -
		// --
		// -
		for (int t = 0; t < 4; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						x_ = i + ex[t][k];
						y_ = j + ey[t][k];

						if (x_ < 0 || y_ < 0 || x_ >= N || y_ >= M) {
							flag = false;
							break;
						}
						cnt += arr[x_][y_];
					}
					if (flag) {
						if (max < cnt)
							max = cnt;
					} else {
						flag = true;
					}
				}
			}
		}
		System.out.println(max);

	}
}

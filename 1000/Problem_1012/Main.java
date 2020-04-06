package Problem_1012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[][] arr;
	public static int[] dx = { 0, 1, -1, 0 };
	public static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M, N, K;
		for (int t = 1; t <= T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[M][N];
			for (int i = 0; i < K; i++) {
				arr[sc.nextInt()][sc.nextInt()] = 1;
			}

			Queue<int[]> q = new LinkedList<>();
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						q.offer(new int[] { i, j });
						arr[i][j] = 0;
						cnt++;
					}

					while (!q.isEmpty()) {
						int x_ = q.peek()[0];
						int y_ = q.poll()[1];
						
						for(int k = 0; k < 4; k++) {
							if(0>x_+dx[k] || x_+dx[k] >= M || y_ + dy[k] < 0 || y_ + dy[k] >= N) continue;
							if(arr[x_+dx[k]][y_+dy[k]] == 1) {
								q.offer(new int[] { x_+dx[k], y_+dy[k]});
								arr[x_+dx[k]][y_+dy[k]] = 0;
							}

						}
						
					}
				}
			}
			System.out.printf("%d\n",cnt);
		}
	}
}

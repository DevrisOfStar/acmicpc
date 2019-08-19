package Problem_2573;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] isvisited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void bfs() {
		int cnt;
		int year = 0;
		boolean flag = true;
		Queue<int[]> q = new LinkedList<>();
		while (true) {

			cnt = 0;
			flag = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					isvisited[i][j] = false;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!isvisited[i][j] && arr[i][j] > 0) {
						cnt++;
						isvisited[i][j] = true;
						q.offer(new int[] { i, j });
						flag = false;
					}

					while (!q.isEmpty()) {
						int a = q.peek()[0];
						int b = q.poll()[1];

						for (int di = 0; di < 4; di++) {
							if (0 > a + dx[di] || 0 > b + dy[di] || a + dx[di] >= N || b + dy[di] >= M)
								continue;
							if (!isvisited[a + dx[di]][b + dy[di]] && arr[a+dx[di]][b+dy[di]] > 0) {
								isvisited[a + dx[di]][b + dy[di]] = true;
								q.offer(new int[] { a + dx[di], b + dy[di] });
							}
						}
					}
				}
			}
			if (flag && cnt < 2) {
				System.out.println(0);
				return;
			}

			if (cnt >= 2) {
				System.out.println(year);
				return;
			}

			year++;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] > 0) {
						int t = 0;
						for (int di = 0; di < 4; di++) {
							if (0 > i + dx[di] || 0 > j + dy[di] || i + dx[di] >= N || j + dy[di] >= M)
								continue;
							if (arr[i + dx[di]][j + dy[di]] == 0)
								t++;
						}
						arr[i][j] = arr[i][j] <= t ? -1 : arr[i][j]-t;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] == -1) arr[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][M];
		isvisited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		bfs();

	}
}

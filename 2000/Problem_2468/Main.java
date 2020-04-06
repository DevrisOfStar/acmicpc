package Problem_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static String[] temp;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int cnt; // 안전구역 개수
	static int rainy = 0;

	public static void solution() {
		Queue<int[]> q = new LinkedList<>(); // x,y 좌표
		int max_cnt = Integer.MIN_VALUE;
		do {
			init();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					if (arr[i][j] <= rainy) visited[i][j] = true;
					else {
						visited[i][j] = true;
						q.add(new int[] { i, j });
						cnt++;
					}
					while (!q.isEmpty()) {
						int[] data = q.poll();
						for (int k = 0; k < 4; k++) {
							int x_ = data[0] + dx[k];
							int y_ = data[1] + dy[k];

							if (x_ < 0 || x_ >= N || y_ < 0 || y_ >= N) continue;
							if (!visited[x_][y_] && arr[x_][y_] > rainy) {
								visited[x_][y_] = true;
								q.add(new int[] { x_, y_ });
							}
						}
					} // end of while
				} 
			} // end for
			
			max_cnt = max_cnt > cnt ? max_cnt : cnt;
			//System.out.printf("%d %d\n", rainy, cnt);
			// print();
			// System.out.println();
		} while (cnt != 0 && rainy++ <= 100);
		System.out.println(max_cnt);
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if(rainy < arr[i][j])System.out.printf("%d\t", arr[i][j]);
				else System.out.printf("%d\t", 0);
			System.out.println();
		}
	}

	public static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				visited[i][j] = false;
		}

		cnt = 0;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		solution();
	}
}

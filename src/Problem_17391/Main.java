package Problem_17391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);

		int[][] arr = new int[N][M];
		boolean[][] isvisited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0 });
		isvisited[0][0] = true;

		while (!q.isEmpty()) {
			int[] data = q.poll();
			int T = arr[data[0]][data[1]];
			if (data[0] == N - 1 && data[1] == M - 1) {
				System.out.println(data[2]);
				return;
			}
			
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= T; j++) {
					int dx_ = data[0] + j * dx[i];
					int dy_ = data[1] + j * dy[i];

					if (dx_ < 0 || dy_ < 0 || dx_ >= N || dy_ >= M)
						continue;
					if (isvisited[dx_][dy_])
						continue;

					q.add(new int[] { dx_, dy_, data[2] + 1 });
					isvisited[dx_][dy_] = true;
				}
			}

		}

	}
}

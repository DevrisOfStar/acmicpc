package Problem_14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer;
		StringTokenizer st;
		int N, M, K, answer;
		buffer = br.readLine();
		st = new StringTokenizer(buffer, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][M + 1];
		boolean[][][] visited = new boolean[N + 1][M + 1][11];
		for (int i = 1; i <= N; i++) {
			buffer = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j + 1] = buffer.charAt(j) - '0';
			}
		}

		answer = Integer.MAX_VALUE;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 1, 1, 0, 1 }); // x,y,k,s.
		visited[1][1][0] = true;

		while (!q.isEmpty()) {
			int[] data = q.poll();

			if (data[0] == N && data[1] == M) {
				if (answer > data[3])
					answer = data[3];
			} else {
				for (int i = 0; i < 4; i++) {
					int dx_ = data[0] + dx[i];
					int dy_ = data[1] + dy[i];
					int dk_ = data[2];
					if (0 >= dx_ || N < dx_ || dy_ <= 0 || M < dy_) continue;
					if (visited[dx_][dy_][dk_]) continue;
					if (arr[dx_][dy_] == 1) {
						if (dk_ < K && !visited[dx_][dy_][dk_+1]) {
							q.add(new int[] { dx_, dy_, data[2] + 1, data[3] + 1 });
							visited[dx_][dy_][dk_ + 1] = true;
						}
						continue;
					}
					q.add(new int[] { dx_, dy_, dk_, data[3] + 1 });
					
					visited[dx_][dy_][dk_] = true;
				}

			}
		}
		answer = (answer == Integer.MAX_VALUE ? -1 : answer);
		System.out.println(answer);
	}
}

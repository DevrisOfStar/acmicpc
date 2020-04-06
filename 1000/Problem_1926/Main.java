package Problem_1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int count, max_size = 0;
	static int[][] arr;
	static boolean[][] is_;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		n = Integer.parseInt(str.split(" ")[0]);
		m = Integer.parseInt(str.split(" ")[1]);
		arr = new int[n][m];
		is_ = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int size_ = 0;
				if (arr[i][j] == 1 && !is_[i][j]) {
					q.add(new int[] { i, j });
					is_[i][j] = true;
					count++;
					size_++;
				}

				while (!q.isEmpty()) {
					int[] data = q.poll();
					for (int k = 0; k < 4; k++) {
						int dx_ = data[0] + dx[k];
						int dy_ = data[1] + dy[k];

						if (dx_ < 0 || dy_ < 0 || dx_ >= n || dy_ >= m) continue;

						if (arr[dx_][dy_] == 1 && !is_[dx_][dy_]) {
							q.add(new int[] { dx_, dy_ });
							is_[dx_][dy_] = true;
							size_++;
						}
					}
				}

				if (max_size < size_)
					max_size = size_;
				size_ = 0;
			}
		}
		System.out.println(count);
		System.out.println(max_size);
	}
}

package Problem_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[][] isvisited;
	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n;

	public static int bfs(boolean hasdisabled) {
		int cnt = 0;
		char temp = 'a';
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isvisited[i][j]) {
					temp = map[i][j];
					isvisited[i][j] = true;
					q.offer(new int[] { i, j });
					cnt++;
				}

				while (!q.isEmpty()) {
					int[] data = q.poll();

					for (int k = 0; k < 4; k++) {
						int x = data[0] + dx[k];
						int y = data[1] + dy[k];

						if (x < 0 || y < 0 || x >= n || y >= n)
							continue;
						
						// 적록색약 유무와 방문여부에 따라 bfs 진행.
						if (!isvisited[x][y] && !hasdisabled && (temp == map[x][y])) {
							q.offer(new int[] { x, y });
							isvisited[x][y] = true;
						} else if (!isvisited[x][y] && hasdisabled && (temp == 'B' && temp == map[x][y])) {
							q.offer(new int[] { x, y });
							isvisited[x][y] = true;
						} else if (!isvisited[x][y] && hasdisabled && (temp != 'B' && 'B' != map[x][y])) {
							q.offer(new int[] { x, y });
							isvisited[x][y] = true;
						}

					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		isvisited = new boolean[n][n];
		String str;
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int cnt1 = bfs(false); // 적록색약이 없는 경우
		for(int i = 0 ; i<n;i++)
			Arrays.fill(isvisited[i], false);
		int cnt2 = bfs(true); // 적록색약이 있는 경우

		System.out.printf("%d %d\n", cnt1, cnt2);

	}
}

package Problem_3184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class data {
	int x;
	int y;

	public data(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main_bfs {
	public static char[][] arr;
	static int r;
	static int c;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void bfs() {
		boolean[][] isvisited = new boolean[r][c];
		int numO = 0; // 양
		int numV = 0; // 울프
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int a = 0; // 양
				int b = 0; // 울프
				Queue<data> q = new LinkedList<>();
				if (arr[i][j] != '#' && !isvisited[i][j]) {
					isvisited[i][j] = true;
					q.add(new data(i, j));
					if (arr[i][j] == 'o') {
						a++;
					} else if (arr[i][j] == 'v') {
						b++;
					}
				}
				// 각 방향에 대한
				while (!q.isEmpty()) {
					data d_ = q.poll();

					for (int k = 0; k < 4; k++) {
						if (d_.x + dx[k] >= 0 && d_.x + dx[k] < r && d_.y + dy[k] >= 0 && d_.y + dy[k] < c
								&& arr[d_.x + dx[k]][d_.y + dy[k]] != '#' && !isvisited[d_.x + dx[k]][d_.y + dy[k]]) {
							isvisited[d_.x + dx[k]][d_.y + dy[k]] = true;
							q.add(new data(d_.x + dx[k], d_.y + dy[k]));
							if (arr[d_.x + dx[k]][d_.y + dy[k]] == 'o') {
								a++;
							} else if (arr[d_.x + dx[k]][d_.y + dy[k]] == 'v') {
								b++;
							}
						}

					}

				}

				// 결과 저장
				if (a > b) {
					numO += a;
				} else {
					numV += b;
				}

			}
		}

		System.out.printf("%d %d", numO, numV);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		r = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);

		arr = new char[r][c];

		for (int i = 0; i < r; i++) {
			String t = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = t.charAt(j);
			}
		}

		bfs();

	}
}

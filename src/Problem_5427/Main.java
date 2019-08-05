package Problem_5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
 * 일단 돌아감, 추가 테스트케이스에 대한 메모리 초과
 *
 */
class data {
	int x; // 0~h
	int y; // 0~w
	int time;

	public data(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}

}
class data2 {
	int x;
	int y;
	public data2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[][] arr = new char[1001][1001];

	public static void bfs(data start, int w, int h) {
		boolean[][] visited = new boolean[h][w];
		boolean[][] visited2 = new boolean[h][w];
		Queue<data> q = new LinkedList<>();
		List<data2> f = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i][j] == '*') {
					f.add(new data2(i, j));
					visited2[i][j] = true;
				}
			}
		} // 초기 불의 위치
		while (!q.isEmpty()) {
			// 불 증식
			int t = f.size();
			for (int i = 0; i < t; i++) {
				int x_ = f.get(i).x;
				int y_ = f.get(i).y;
				for (int k = 0; k < 4; k++) {
					if (0 <= x_ + dx[k] && x_ + dx[k] < h && 0 <= y_ + dy[k] && y_ + dy[k] < w
							&& arr[x_ + dx[k]][y_ + dy[k]] != '#') {
						arr[x_ + dx[k]][y_ + dy[k]] = '*';
						f.add(new data2(x_ + dx[k], y_ + dy[k]));
						visited2[x_+dx[k]][y_+dy[k]] = true;
					}

				}
			}
			for (int i = 0; i < t; i++)
				f.remove(t);

			// 상근이 이동
			data data = q.poll();
			for (int k = 0; k < 4; k++) {
				// 탈출여부 확인
				if (!(0 <= data.x + dx[k] && data.x + dx[k] < h && 0 <= data.y + dy[k] && data.y + dy[k] < w)) { // out
					System.out.println(data.time + 1);
					return;
				}
				if (arr[data.x + dx[k]][data.y + dy[k]] == '.') {
					visited[data.x + dx[k]][data.y + dy[k]] = true;
					q.add(new data(data.x + dx[k], data.y + dy[k], data.time + 1));
				}
			} // end for

		} // end while

		System.out.println("IMPOSSIBLE");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		data start = new data(1, 1, 0);

		for (int t = 1; t <= T; t++) {
			String[] temp = br.readLine().split(" ");
			int w = Integer.parseInt(temp[0]);
			int h = Integer.parseInt(temp[1]);
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '@') {
						start.x = i;
						start.y = j;
					}

				}
			} // end input

			bfs(start, w, h);
		}
	}
}

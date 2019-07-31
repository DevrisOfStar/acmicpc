package Problem_6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class data {
	int x;
	int y;
	int z;
	int time;

	public data(int x, int y, int z, int time) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.time = time;
	}

}

public class Main_bfs {//하,북,상,남,동,서
	 static int[] dx = { 1, 0, -1, 0, 0, 0 };
	 static int[] dy = { 0, -1, 0, 1, 0, 0 };
	 static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void bfs(char[][][] arr, data start, data end) {
		boolean[][][] visited = new boolean[arr.length][arr[0].length][arr[0][0].length];
		Queue<data> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y][start.z] = true;
		while (!q.isEmpty()) {
			data d_ = q.poll();
			if (d_.x == end.x && d_.y == end.y && d_.z == end.z) {
				System.out.println("Escaped in " + d_.time + " minute(s).");
				return;
			}
			for (int i = 0; i < 6; i++) {
				if (d_.x + dx[i] >= 0 && d_.x + dx[i] < arr.length
						&&d_.y + dy[i] >= 0 && d_.y + dy[i] < arr[0].length
						&& d_.z + dz[i] >= 0 && d_.z + dz[i] < arr[0][0].length
						&& !visited[d_.x + dx[i]][d_.y + dy[i]][d_.z + dz[i]]
						&& arr[d_.x + dx[i]][d_.y + dy[i]][d_.z + dz[i]] != '#') {
					visited[d_.x + dx[i]][d_.y + dy[i]][d_.z + dz[i]] = true;
					q.add(new data(d_.x + dx[i], d_.y + dy[i], d_.z + dz[i], d_.time + 1));
				}

			}

		} // end while
		System.out.println("Trapped!");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] str = br.readLine().split(" ");
			int L = Integer.parseInt(str[0]);
			int R = Integer.parseInt(str[1]);
			int C = Integer.parseInt(str[2]);
			if (L == 0 && R == 0 && C == 0)
				break;
			char[][][] arr = new char[L][R][C];
			data start = null;
			data end = null;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str2 = br.readLine();
					for (int k = 0; k < C; k++) {
						arr[i][j][k] = str2.charAt(k);
						if (arr[i][j][k] == 'S') {
							start = new data(i, j, k, 0);
							
						} else if (arr[i][j][k] == 'E') {
							end = new data(i, j, k, 0);
						}
					}
				}
				String temp = br.readLine(); // newline 제거
			}
			bfs(arr, start, end);
		}

	}
}

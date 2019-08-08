package Problem_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class data {
	int r;
	int c;
	int dir;

	public data(int r, int c, int dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}

}

public class Main {

	static int[][] map;// 북 동 남 서
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void simulate(data robot) {

		int x = robot.r;
		int y = robot.c;
		int d = robot.dir;
		int cnt = 0;
		int state = 1;

		a: while (true) {
			// 현재 위치를 청소
			if (state == 1) {
				if (map[x][y] == 0 || map[x][y] == 9) {
					map[x][y] = -1;

				}
			}

			state = 2;

			// 탐색
			d: if (state == 2) {
				// 방향에 청소하지않은 구간이 존재하면, state 1로 수정하고,
				for (int dir_ = 1; dir_ <= 4; dir_++) {
					d = (d + 3) % 4;
					if (map[x + dx[d]][y + dy[d]] == 0 || map[x + dx[d]][y + dy[d]] == 9) {
						x += dx[d];
						y += dy[d];
						state = 1;
						map[x][y] = 9;
						break d;
					}
				}
				// 후진
				int dir = (d + 2) % 4;
				if (map[x + dx[dir]][y + dy[dir]] == 1) {
					break a;
				} else {
					x += dx[dir];
					y += dy[dir];

				}

			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					System.out.printf("%2d ", map[i][j]);
				}
				System.out.println();
			}
			System.out.println();

		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.printf("%2d ", map[i][j]);
				if (map[i][j] == -1) {
					cnt++;
				}
			}
			System.out.println();
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = br.readLine();
		int N = Integer.parseInt(st.split(" ")[0]);
		int M = Integer.parseInt(st.split(" ")[1]);

		st = br.readLine();
		int r = Integer.parseInt(st.split(" ")[0]);
		int c = Integer.parseInt(st.split(" ")[1]);
		int d = Integer.parseInt(st.split(" ")[2]);

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = st.charAt(j * 2) - '0';
			}
		}

		simulate(new data(r, c, d));
	}
}

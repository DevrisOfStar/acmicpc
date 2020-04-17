package Problem_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dir_x = { 0, 0, 1, -1 };
	static int[] dir_y = { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][][][] visited;
	static int r_x, r_y, o_x, o_y, b_x, b_y;

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r_x, r_y, b_x, b_y, 0 });
		visited[r_x][r_y][b_x][b_y] = true;
		int r_dx, r_dy, b_dx, b_dy;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[4] > 10) // 10번 초과로 진행했을경우 종료
				break;

			if (cur[0] == o_x && cur[1] == o_y) { // 빨간 구슬이 구멍인 경우, 횟수 return
				return cur[4];
			}
			for (int i = 0; i < 4; i++) {
				r_dx = cur[0];
				r_dy = cur[1];
				b_dx = cur[2];
				b_dy = cur[3];

				while (true) { // 빨간구슬 이동
					r_dx += dir_x[i];
					r_dy += dir_y[i];

					if (map[r_dx][r_dy] == '#') { // 벽이면 바로 전 좌표로 이동
						r_dx -= dir_x[i];
						r_dy -= dir_y[i];
						break;
					} else if (map[r_dx][r_dy] == 'O') { // 구멍이면 탈출
						break;
					}
				}

				while (true) { // 파란구슬 이동
					b_dx += dir_x[i];
					b_dy += dir_y[i];

					if (map[b_dx][b_dy] == '#') { // 벽이면 바로 전 좌표로 이동
						b_dx -= dir_x[i];
						b_dy -= dir_y[i];
						break;
					} else if (map[b_dx][b_dy] == 'O') { // 구멍이면 탈출
						break;
					}
				} // 이동완료
			
				if (b_dx == o_x && b_dy == o_y) // 파란 구슬 탈출이면 상황 종료
					continue;

				// 충돌 : 빨간구슬과 파란구슬이 겹친 경우
				if (r_dx == b_dx && r_dy == b_dy) {
					switch (i) { // 진행 방향에 따라 처리
					case (0): // 남쪽으로 구슬이 굴러감
						if (cur[1] < cur[3]) // 빨간구슬이 나중에 간 경우
							r_dy--;
						else // 파란 구슬이 나중에 간 경우
							b_dy--;
						break;
					case (1): // 북쪽으로 구슬이 굴러감
						if (cur[1] < cur[3]) // 파란구슬이 나중에 간 경우
							b_dy++;
						else // 빨간구슬이 나중에 간 경우
							r_dy++;
						break;
					case (2): // 동쪽으로 구슬이 굴러감
						if(cur[0] < cur[2]) // 빨간구슬이 나중에 간 경우
							r_dx--;
						else // 파란구슬이 나중에 간 경우
							b_dx--;
						break;
					case (3): // 서쪽으로 구슬이 굴러감
						if(cur[0] < cur[2]) // 파란구슬이 나중에 간 경우
							b_dx++;
						else // 빨간구슬이 나중에 간 경우
							r_dx++;
						break;
					}
				}
				
				if(!visited[r_dx][r_dy][b_dx][b_dy]) { // 수행해본 이력이 없으면, 큐에 삽입
					q.add(new int[] {r_dx,r_dy,b_dx,b_dy,cur[4]+1});
					visited[r_dx][r_dy][b_dx][b_dy] = true;
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf;
		int n, m;

		bf = br.readLine();
		n = Integer.parseInt(bf.split(" ")[0]);
		m = Integer.parseInt(bf.split(" ")[1]);

		map = new char[n][m];
		visited = new boolean[n][m][n][m];

		for (int i = 0; i < n; i++) {
			bf = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = bf.charAt(j);
				if (map[i][j] == 'R') { // 빨간구슬 좌표 저장
					r_x = i;
					r_y = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'O') { // 구멍위치 저장
					o_x = i;
					o_y = j;
				} else if (map[i][j] == 'B') { // 파란구슬 위치 저장
					b_x = i;
					b_y = j;
					map[i][j] = '.';
				}

			}
		}

		int result = bfs();
		System.out.println(result);
	}
}

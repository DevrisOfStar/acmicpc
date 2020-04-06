package Problem_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R, C, T;
	static int[][] map;
	static int answer = 0;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ax,ay;
	static int bx,by;
	public static void simulate() {
		int[][] arr = new int[R][C];
		for (int t = 0; t < T; t++) {
			// 미세먼지 확산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					int a = 0; // 인접한 칸의 개수
					for (int k = 0; k < 4; k++) {
						int x_ = i + dx[k];
						int y_ = j + dy[k];

						if (x_ < 0 || y_ < 0 || x_ >= R || y_ >= C)
							continue;
						if (map[x_][y_] == -1)
							continue;
						a++;
					}
					int b = a > 0 ? map[i][j] / 5 : 0;
					map[i][j] -= a * b;

					for (int k = 0; k < 4; k++) {
						int x_ = i + dx[k];
						int y_ = j + dy[k];

						if (x_ < 0 || y_ < 0 || x_ >= R || y_ >= C)
							continue;
						if (map[x_][y_] == -1)
							continue;
						arr[x_][y_] += b;
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] += arr[i][j];
					arr[i][j] = 0;
				}
			}
			// 미세먼지 확산 완료
			// 공기청정기가 작동
			
			for(int i = ax; i > 0 ; i--) {
				map[i][ay] = map[i-1][ay];
			}
			map[ax][ay] = 0; // 들어온 먼지 초기화
			
			for(int j = 1;j<C; j++) {
				map[0][j-1] = map[0][j];
			}
			
			for(int i = 0; i<ax; i++) {
				map[i][C-1] = map[i+1][C-1];
			}
			
			for(int j = C-1; j>0; j--) {
				map[ax][j] = map[ax][j-1];
			}
			map[ax][ay] = -1;
			
			for(int i = bx; i<R-1; i++) {
				map[i][by] = map[i+1][by];
			}
			map[bx][by] = 0;
			for(int j = 0; j<C-1; j++) {
				map[R-1][j] = map[R-1][j+1];
			}
			
			for(int i = R-1; i > bx; i--) {
				map[i][C-1] = map[i-1][C-1];
			}
			
			for(int j = C-1; j > 0; j--) {
				map[bx][j] = map[bx][j-1];
			}

			map[bx][by] = -1;
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j] != -1) answer+=map[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		String[] bf;
		R = Integer.parseInt(buffer.split(" ")[0]);
		C = Integer.parseInt(buffer.split(" ")[1]);
		T = Integer.parseInt(buffer.split(" ")[2]);
		map = new int[R][C];
		boolean flag = false;
		for (int i = 0; i < R; i++) {
			buffer = br.readLine();
			bf = buffer.split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(bf[j]);
				if(!flag && map[i][j] == -1) {
					flag = true;
					ax = i;
					ay = j;
					bx = i+1;
					by = j;
				}
			}
			
		}

		simulate();

		
		
		System.out.println(answer);
	}
}

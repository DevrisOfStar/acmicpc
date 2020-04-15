package Problem_16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int r, c, n;
	static int[][] arr;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void simulate() {
		int[][] arr_temp = new int[r][c];

		for (int t = 1; t <= n; t++) {
			if (t == 1)
				continue;

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] < 0)
						continue;

					arr[i][j]--;
				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] >= 0)
						continue;
					arr[i][j] = 3;

				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] == 0) {
						arr_temp[i][j] = -1;
						for (int k = 0; k < 4; k++) {
							int dx_ = i + dx[k];
							int dy_ = j + dy[k];
							if (dx_ < 0 || dy_ < 0 || dx_ >= r || dy_ >= c)
								continue;
							arr_temp[dx_][dy_] = -1;
						}
					} else if (arr[i][j] > 0 && arr_temp[i][j] != -1) {
						arr_temp[i][j] = arr[i][j];
					}
				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					arr[i][j] = arr_temp[i][j];
				}
			}
			
			for(int i = 0; i <r;i++) Arrays.fill(arr_temp[i], 0);
		}
		
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c;j++) {
				if(arr[i][j] == 0) {
					map[i][j] = '.';
					for (int k = 0; k < 4; k++) {
						int dx_ = i + dx[k];
						int dy_ = j + dy[k];
						if (dx_ < 0 || dy_ < 0 || dx_ >= r || dy_ >= c)
							continue;
						map[dx_][dy_] = '.';
					}
				}
				else if(arr[i][j] == -1) {
					map[i][j] = '.';
				}
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		r = Integer.parseInt(str.split(" ")[0]);
		c = Integer.parseInt(str.split(" ")[1]);
		n = Integer.parseInt(str.split(" ")[2]);
		arr = new int[r][c];
		map = new char[r][c];
		for(int i = 0; i<r;i++)Arrays.fill(map[i], 'O');
		char ch = 'a';
		for (int i = 0; i < r; i++) {
			str = br.readLine();
			for (int j = 0; j < c; j++) {
				ch = str.charAt(j);
				if (ch == '.')
					arr[i][j] = -1;
				else
					arr[i][j] = 2;
			}
		}
		simulate();
	}
}

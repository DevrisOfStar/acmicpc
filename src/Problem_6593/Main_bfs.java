package Problem_6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class Main_bfs {

	public static void bfs(char[][][] arr, data start, data end) {
		// 여기만 구현하면됨
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

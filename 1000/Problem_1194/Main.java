package Problem_1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Data {
	int x, y, key;

	public Data(int x, int y, int key) {
		this.x = x;
		this.y = y;
		this.key = key;
	}

}

public class Main {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		char[][] arr = new char[N][M];
		boolean[][][] is_ = new boolean[N][M][64];
		Queue<Data> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '0') {
					q.add(new Data(i, j, 0));
					is_[i][j][0] = true;
				}
			}
		}
		int cnt = 0;
		boolean flag = false;
		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				Data d = q.poll();
				if (arr[d.x][d.y] == '1') { flag = true; break; }
				for (int i = 0; i < 4; i++) {
					int dx_ = d.x + dx[i];
					int dy_ = d.y + dy[i];
					int nkey = d.key;
					if (dx_ < 0 || dy_ < 0 || dx_ >= N || dy_ >= M) continue;
					if (arr[dx_][dy_] == '#') continue;
					if ('a' <= arr[dx_][dy_] && arr[dx_][dy_] <= 'f') {
						nkey |= (1 << (arr[dx_][dy_] - 'a'));
					}
					if ('A' <= arr[dx_][dy_] && arr[dx_][dy_] <= 'F') {
						if((nkey & (1 << (arr[dx_][dy_] - 'A'))) == 0) continue;
					}
					if(is_[dx_][dy_][nkey]) continue;
					q.add(new Data(dx_, dy_, nkey));
					is_[dx_][dy_][nkey] = true;
				}
			}
			if(flag) break;
			else cnt++;
		}
		if(flag) System.out.println(cnt);
		else System.out.println("-1");
	}
}

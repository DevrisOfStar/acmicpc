package Problem_16948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int[] cor = new int[4];
	static boolean[][] isvisited;
	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };

	public static int solve() {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { cor[0], cor[1], 0 });
		isvisited[cor[0]][cor[1]] = true;

		while (!q.isEmpty()) {
			int[] data = q.poll();
			if (data[0] == cor[2] && data[1] == cor[3]) return data[2];

			for (int i = 0; i < 6; i++) {
				int r_ = data[0] + dr[i];
				int c_ = data[1] + dc[i];
				
				if(r_ < 0 || r_ >=N || c_ <0 || c_ >= N) continue;
				if(isvisited[r_][c_]) continue;
				isvisited[r_][c_] = true;
				q.add(new int[] {r_,c_, data[2]+1});
			}
		}

		return -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isvisited = new boolean[N][N];
		String buffer = br.readLine();
		int a = 0;
		for (String s : buffer.split(" "))
			cor[a++] = Integer.parseInt(s);

		System.out.println(solve());

	}
}

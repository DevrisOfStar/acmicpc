package Problem_2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static int answer = Integer.MIN_VALUE;
	static char[][] arr;
	static boolean[][] isvisited;

	static void answer() {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 'L') {
					q.add(new int[] { i, j, 0});
				}
			}
		}
	
		while (!q.isEmpty()) {
			int[] data = q.poll();
			Queue<int[]> q2 = new LinkedList<>();
			q2.add(data);
			isvisited[data[0]][data[1]] = true;

			while (!q2.isEmpty()) {
				int[] data2 = q2.poll();
				for (int i = 0; i < 4; i++) {
					int dx_ = data2[0] + dx[i];
					int dy_ = data2[1] + dy[i];
					
					if (dx_ < 0 || dy_ < 0 || dx_ >= N || dy_ >= M) continue;
					if(arr[dx_][dy_] == 'W') continue;
					
					
					if(arr[dx_][dy_] == 'L' && !isvisited[dx_][dy_]) {
						q2.add(new int[] { dx_, dy_, data2[2]+1});
						isvisited[dx_][dy_] = true;
						if(answer < data2[2]+1) {							
							answer = data2[2]+1;}
						
					}
				}
			}
			
			for(int i = 0 ; i<N;i++) {
				Arrays.fill(isvisited[i], false);
			}

		}

	}

	public static void main(String[] args) throws IOException {
		// 각 끝점에서 bfs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		arr = new char[N][M];
		isvisited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		answer();
		System.out.println(answer);

	}
}

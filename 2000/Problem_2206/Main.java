package Problem_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][][] isvisited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int min = Integer.MAX_VALUE;
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1,0});
		isvisited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			if(data[0] == N-1 && data[1] == M-1) {
				if(min > data[2]) min = data[2];
			}
			else {
				for(int i = 0; i<4;i++) {
					int dx_ = data[0] + dx[i];
					int dy_ = data[1] + dy[i];
					
					if(dx_ < 0 || dx_ >= N || dy_ < 0 || dy_ >= M) continue;
					
					if(arr[dx_][dy_] == 0 && !isvisited[dx_][dy_][data[3]]) {
						q.add(new int[] {dx_,dy_, data[2]+1, data[3]});
						isvisited[dx_][dy_][data[3]] = true;
					}
					else if(arr[dx_][dy_] == 1 && data[3] == 0) {
						
						for(int j = 0; j <4; j++) {
							int dx__ = dx_ + dx[j];
							int dy__ = dy_ + dy[j];
							if(dx__ < 0 || dx__ >= N || dy__ < 0 || dy__ >= M) continue;
							if(arr[dx__][dy__] == 1) continue;
							if(arr[dx__][dy__] == 0 && !isvisited[dx_][dy_][1]) {
								q.add(new int[] {dx_,dy_, data[2]+1, 1});
								isvisited[dx_][dy_][1] = true;
							}
						}
					}
					
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		arr = new int[N][M];
		isvisited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		if(min == Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(min);			
		}
	}
}

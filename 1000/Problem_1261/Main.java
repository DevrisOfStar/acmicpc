package Problem_1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int M,N;
	static int[][] map;
	static int[][] isvisited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		N = Integer.parseInt(buf.split(" ")[0]);
		M = Integer.parseInt(buf.split(" ")[1]);
		map = new int[M][N];
		isvisited = new int[M][N];
		
		for(int i = 0; i<M; i++) {
			buf = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = buf.charAt(j) - '0';
			}
		}
		for(int i = 0 ; i < M ; i++) 
			Arrays.fill(isvisited[i], Integer.MAX_VALUE);
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		isvisited[0][0] = 0;
		while(!q.isEmpty()) {
			int[] data = q.poll();
			for(int i = 0; i < 4; i++) {
				int x_ = dx[i] + data[0];
				int y_ = dy[i] + data[1];
				if(x_ < 0 || y_ < 0 || x_ >= M || y_ >= N) continue;
				int cnt = isvisited[data[0]][data[1]];
				if(map[x_][y_] == 1) cnt++;
				if(isvisited[x_][y_] > cnt) {
					q.add(new int[] {x_, y_});
					isvisited[x_][y_] = cnt;
				}
			}
		}
		System.out.println(isvisited[M-1][N-1]);
		
	}
}

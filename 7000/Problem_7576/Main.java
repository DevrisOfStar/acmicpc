package Problem_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<int[]> q = new LinkedList<>();
	static int M,N;
	static int[][] map;
	static int[] dx = {0,-1,1,0};
	static int[] dy = {1,0,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new int[] {i,j});
					
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] d = q.poll();
			int day = map[d[0]][d[1]];
			
			for(int k = 0; k<4; k++) {
				int x_ = dx[k] + d[0];
				int y_ = dy[k] + d[1];
				if(0 > x_ || 0 > y_ || x_ >= M || y_ >= N) continue;
				
				if(map[x_][y_] == -1) continue;
				if(map[x_][y_] > 0) continue;
				map[x_][y_] = day+1;
				q.add(new int[] {x_,y_});
			}
		}
		int days = 0;
		for(int i = 0; i<M;i++) {
			for(int j = 0; j<N;j++) {
				if(map[i][j] == 0) {
					days = Integer.MAX_VALUE;
				}
				else {
					days = days > map[i][j] ? days : map[i][j];
				}
			}
		}
		
		if(days == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(days-1);	
	}
}

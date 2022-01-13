package Problem_1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);		
		int M = Integer.parseInt(str.split(" ")[1]);
		int K = Integer.parseInt(str.split(" ")[2]);
		int[] dx = {0,-1,1,0};
		int[] dy = {1,0,0,-1};
		boolean[][] map = new boolean[N+1][M+1];
		boolean[][] isvisited = new boolean[N+1][M+1];
		for(int i = 0; i<K; i++) {
			str = br.readLine();
			int a = Integer.parseInt(str.split(" ")[0]);		
			int b = Integer.parseInt(str.split(" ")[1]);
			map[a][b] = true;
		}
		Queue<int[]> q = new LinkedList<>();
		int max_cnt = 0;
		for(int i =1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(map[i][j] && !isvisited[i][j]) {
					q.add(new int[] {i,j});
					isvisited[i][j] = true;
					int cnt = 1;
					
					while(!q.isEmpty()) {
						int[] data = q.poll();
						for(int k = 0; k<4; k++) {
							int x_ = dx[k] + data[0];
							int y_ = dy[k] + data[1];
							if(x_<=0 || y_<=0 || x_ >N || y_> M) continue;
							if(isvisited[x_][y_]) continue;
							if(!map[x_][y_]) continue;
							isvisited[x_][y_] = true;
							cnt++;
							q.add(new int[] {x_,y_});
						}
					}
					
					if(cnt > max_cnt) max_cnt = cnt;
				}
			}
		}
		System.out.println(max_cnt);
	}
}

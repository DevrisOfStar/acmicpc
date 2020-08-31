package Problem_16933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, K;
	static boolean[][][][] isvisited;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);
		K = Integer.parseInt(buffer.split(" ")[2]);
		
		isvisited = new boolean[N][M][K+1][2];
		map = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			buffer = br.readLine();
			for(int j = 0; j<M;j++) {
				map[i][j] = buffer.charAt(j) - '0';
			}
		}
		
		
		solve();
		
		
	}
	
	public static void solve() {
		Queue<int[]> q = new LinkedList<>();
		// x,y,isNoon,k,cnt
		
		q.add(new int[] {0,0,0,K,1});
		isvisited[0][0][K][0] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			
			if(data[0] == N-1 && data[1] == M-1) {
				System.out.println(data[4]);
				return;
			}
			
			for(int k = 0 ; k<4; k++) {
				int x_ = data[0] + dx[k];
				int y_ = data[1] + dy[k];
				
				if(x_ < 0 || x_ >= N || y_ < 0 || y_>=M) continue;
				
				// 낮에서만 부술수있다.
				if(map[x_][y_] == 1 && data[2] == 0 && data[3] > 0
						&& !isvisited[x_][y_][data[3]-1][(data[2]+1)%2]) {
					isvisited[x_][y_][data[3]-1][(data[2]+1)%2] = true;
					q.add(new int[] {x_,y_, (data[2]+1)%2, data[3]-1, data[4]+1});
				}
				
				if(map[x_][y_] == 0 && !isvisited[x_][y_][data[3]][(data[2]+1)%2]) {
					isvisited[x_][y_][data[3]][(data[2]+1)%2] = true;
					q.add(new int[] {x_,y_, (data[2]+1)%2, data[3], data[4]+1});
				}
			}
			
			if(!isvisited[data[0]][data[1]][data[3]][(data[2]+1)%2]) {
				isvisited[data[0]][data[1]][data[3]][(data[2]+1)%2] = true;
				q.add(new int[] {data[0],data[1],(data[2]+1)%2, data[3], data[4]+1});
			}
		}
		
		
		System.out.println("-1");
	}
}

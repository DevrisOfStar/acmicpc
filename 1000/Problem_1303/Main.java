package Problem_1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] arr;
	static boolean[][] is_;
	static int N,M;
	static int[] dx = {0,0,-1,1}; 
	static int[] dy = {1,-1,0,0};
	
	public static int bfs(char c) {
		int num = 0;
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == c && !is_[i][j]) {
					q.add(new int[] {i,j});
					is_[i][j] = true;
					cnt++;
				}
				
				while(!q.isEmpty()) {
					int[] data = q.poll();
					for(int k = 0; k < 4; k++) {
						int dx_ = data[0]+dx[k];
						int dy_ = data[1]+dy[k];
						
						if(dx_ < 0 || dy_ < 0 || dx_ >=M || dy_ >= N) continue;
						if(!is_[dx_][dy_] && arr[dx_][dy_] == c) {
							q.add(new int[] {dx_, dy_});
							is_[dx_][dy_] = true;
							cnt++;
						}
						
					}
				}
				num += (cnt*cnt);
				cnt = 0;
			}
		}		
		
		return num;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);

		arr = new char[M][N];
		is_ = new boolean[M][N];

		int W_count = 0;
		int B_count = 0;

		for (int i = 0; i < M; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		W_count = bfs('W');
		B_count = bfs('B');
		
		System.out.println(W_count + " " + B_count);


	}
}

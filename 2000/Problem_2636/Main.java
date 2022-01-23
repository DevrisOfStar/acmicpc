package Problem_2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[][] isvisited;
	static int N, M;
	static int cnt;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		
		arr = new int[N][M];
		isvisited = new boolean[N][M];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				if(st.nextToken().equals("1")) {
					arr[i][j] = 1;
					cnt++;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		int lastOfCheeze = cnt;
		int time = 0;
		while(true) {
			if(cnt == 0) {
				System.out.println(time);
				System.out.println(lastOfCheeze);
				return;
			}
			
			lastOfCheeze = cnt;
			
			q.add(new int[] {0,0});
			while(!q.isEmpty()) {
				int[] data = q.poll();
				for(int k = 0; k<4; k++) {
					int x_ = dx[k] + data[0];
					int y_ = dy[k] + data[1];
					
					if(x_ < 0 || y_ < 0 || x_>=N|| y_>=M) continue;
					if(arr[x_][y_] == 0 && !isvisited[x_][y_]) {
						q.add(new int[] {x_,y_});
						isvisited[x_][y_] = true;
					}
					else if(arr[x_][y_] == 1) {
						arr[x_][y_] = 2;
						cnt--;
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(arr[i][j] == 2) arr[i][j] = 0;
				}
			}
			
			for(int i = 0; i<N;i++) { Arrays.fill(isvisited[i], false); }
			time++;
		}
	}
}

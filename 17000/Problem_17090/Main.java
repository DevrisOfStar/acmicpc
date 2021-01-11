package Problem_17090;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static String buf;
	static int[][] dir;
	static int[][] cnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		buf = br.readLine();
		N = Integer.parseInt(buf.split(" ")[0]);
		M = Integer.parseInt(buf.split(" ")[1]);
		dir = new int[N][M];
		cnt = new int[N][M];
		int temp = 0;
		int answer = 0;
		for(int i = 0; i<N; i++) {
			buf = br.readLine();
			for(int j = 0; j<M; j++) {
				switch(buf.charAt(j)) {
				case 'U':
					temp = 0;
					break;
				case 'R':
					temp = 1;
					break;
				case 'D':
					temp = 2;
					break;
				case 'L':
					temp = 3;
					break;
				}
				dir[i][j] = temp;
			}
			Arrays.fill(cnt[i], -1);
		}
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<M;j++) {
				answer += dfs(i,j);
			}
		}
		System.out.println(answer);
	}
	
	static int dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return 1;
		if(cnt[x][y] != -1) return cnt[x][y];
		cnt[x][y] = 0;
		cnt[x][y] = dfs(x + dx[dir[x][y]], y + dy[dir[x][y]]);
		return cnt[x][y];
	}
}

package Problem_1580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static String buf;
	static int N, M;
	static boolean[][] map;  // false : wall, true : path
	static boolean[][][][] visited;
	static int ax,ay,bx,by;
	
	static int[] dx = {-1,-1,-1,0,0,1,1,1,0};
	static int[] dy = {-1,0,1,-1,1,-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		buf = br.readLine();
		N = Integer.parseInt(buf.split(" ")[0]);
		M = Integer.parseInt(buf.split(" ")[1]);
		map = new boolean[N][M];
		visited = new boolean[N][M][N][M];
		for(int i = 0; i<N; i++) {
			buf = br.readLine();
			for(int j = 0; j<M;j++) {
				char temp = buf.charAt(j);
				map[i][j] = temp != 'X';
				if(temp == 'A') {
					ax = i;
					ay = j;
				}
				else if(temp =='B') {
					bx = i;
					by = j;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {ax,ay,bx,by});
		visited[ax][ay][bx][by] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int i = 0; i<qsize;i++) {
				int[] data = q.poll();
				if(data[0] == bx && data[1] == by && data[2] == ax && data[3] == ay) {
					System.out.println(cnt);
					return;
				}
				
				for(int j = 0; j<9;j++) {
					for(int k = 0; k<9;k++) {
						int x_a = data[0] + dx[j];
						int y_a = data[1] + dy[j];
						int x_b = data[2] + dx[k];
						int y_b = data[3] + dy[k];
						
						if(x_a < 0 || x_a>= N || x_b < 0 || x_b >= N) continue;
						if(y_a < 0 || y_a>= M || y_b < 0 || y_b >= M) continue;
						if(x_a == data[2] && y_a == data[3] &&
						   x_b == data[0] && y_b == data[1]) continue;
						if(!map[x_a][y_a]) continue; 
						if(!map[x_b][y_b]) continue;
						if(x_a == x_b && y_a == y_b) continue;
						if(visited[x_a][y_a][x_b][y_b]) continue;
						q.add(new int[] {x_a,y_a,x_b,y_b});
						visited[x_a][y_a][x_b][y_b] = true;
					}
				}
			}
			cnt++;
		} // end while
		System.out.println(-1);		
	}
}

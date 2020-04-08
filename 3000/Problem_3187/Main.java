package Problem_3187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int R, C;
	static char[][] arr;
	static boolean[][] isvisited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int sheep = 0, wolf = 0;
	public static void answer() {
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				int s_ = 0, w_ = 0;
				if(arr[i][j] != '#' && !isvisited[i][j]) {
					q.add(new int[] {i,j});
					isvisited[i][j] = true;
					if(arr[i][j] == 'v') w_++;
					else if(arr[i][j] == 'k') s_++;
				}
				while(!q.isEmpty()) {
					int[] data = q.poll();
					for(int k = 0; k < 4;k++) {
						int dx_ = dx[k] + data[0];
						int dy_ = dy[k] + data[1];
						if(dx_ < 0 || dy_ < 0 || dx_ >= R || dy_ >= C) continue;
						if(arr[dx_][dy_] != '#' && !isvisited[dx_][dy_]) {
							q.add(new int[] {dx_,dy_});
							isvisited[dx_][dy_] = true;
							if(arr[dx_][dy_] == 'v') w_++;
							else if(arr[dx_][dy_] == 'k') s_++;
						}
					}
				}
				
				if(w_ < s_) {
					sheep += s_;
				}
				else {
					wolf += w_;
				}
				
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		R = Integer.parseInt(str.split(" ")[0]);
		C = Integer.parseInt(str.split(" ")[1]);
		arr = new char[R][C];
		isvisited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		answer();
		System.out.println(sheep + " " + wolf);
	}
}

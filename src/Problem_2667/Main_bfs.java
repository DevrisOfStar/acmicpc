package Problem_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/* Array 복사를 왠만하면 쓰지말자 */

class data {
	int x;
	int y;
 
	public data(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_bfs {
	static int dx_[] = { -1, 0, 1, 0 };
	static int dy_[] = { 0, 1, 0, -1 };

	public static void bfs(int[][] arr) {
		boolean[][] visited = new boolean[arr.length][arr.length];
		int[] danzi = new int[arr.length * arr.length];
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				boolean flag = false;
				Queue<data> q = new LinkedList<>();
				if (arr[i][j]==1 && !visited[i][j]) {
					flag = true;
					q.add(new data(i, j));
					visited[i][j] = true;
					cnt++;
					while (!q.isEmpty()) {
						data d = q.poll();
						for(int k = 0; k < dx_.length; k++) {
							if(0<=d.x+dx_[k] && d.x+dx_[k] < arr.length 
									&& 0<=d.y+dy_[k] && d.y+dy_[k] <arr.length 
									&& !visited[d.x+dx_[k]][d.y+dy_[k]] && arr[d.x+dx_[k]][d.y+dy_[k]] > 0) {
								q.add(new data(d.x+dx_[k],d.y+dy_[k]));
								visited[d.x+dx_[k]][d.y+dy_[k]]= true;
								cnt++;
							}
						}
					}
				}
				if(flag)
					danzi[idx++] = cnt;
				cnt=0;
				
			}
		}
		
		System.out.println(idx);
		if(idx>0) {
		Arrays.sort(danzi);
		for(int i = 0 ; i < danzi.length; i++) {
			if(danzi[i] == 0) {
				continue;
			}
			else {
				System.out.println(danzi[i]);				
			}
		}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String t = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(t.charAt(j)));
			}
		}

		bfs(arr);
	}
}

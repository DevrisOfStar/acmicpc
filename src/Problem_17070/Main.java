package Problem_17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/* 메모리 및 실행시간 줄이는 방법 찾아보기 */
class data {
	int x;
	int y;
	int dir;
	public data(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

public class Main {// 0 : 가로, 1 : 대각선, 2 : 세로
	static int[][] dx = { { 0, 1 }, { 0, 1, 1 }, { 300, 1, 1 } };
	static int[][] dy = { { 1, 1 }, { 1, 1, 0 }, { 300, 1, 0 } };
	static int[][] arr;
	
	public static void bfs(data start) {
		int cnt = 0;
		Queue<data> q = new LinkedList<>();
		q.offer(start);

		while(!q.isEmpty()) {
			data d = q.poll();
			if(d.x == (arr.length-1) && d.y == (arr.length-1)) {
				cnt++;
				continue;
			}
			
			for(int i = 0; i < dx[d.dir].length; i++) {
				int x_ = d.x+dx[d.dir][i];
				int y_ = d.y+dy[d.dir][i];
				if(!(0<x_ && x_<=arr.length-1 &&
						0<y_ && y_<=arr.length-1)) continue;
				else if(i == 0 && arr[x_][y_] == 1) continue;
				else if(i == 1 && (arr[d.x+0][d.y+1] == 1 || arr[d.x+1][d.y+0] == 1 || arr[d.x+1][d.y+1] == 1))
					continue;
				else if(i == 2 && arr[x_][y_] == 1) continue;
				else {
					q.offer(new data(x_, y_, i));
				}
			}
			
		}
		
		System.out.println(cnt);
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= N; j++) {
				arr[i][j] = s.charAt(2 * (j - 1)) - '0';
			}
		}

		bfs(new data(1,2,0));

	}
}

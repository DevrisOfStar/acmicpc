package Problem_2933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
8 8
........
........
..xx.xx.
..x.xx..
..x.x...
..x.xxx.
..x...x.
.xxx..x.
5
2 6 4 3 1
*/
public class Main {
	static int R, C, N;
	static char[][] arr;
	static boolean[][] isvisited;
	static int[] thro;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void solution() {
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> arr_ = new ArrayList<>();
		for (int k = 0; k < N; k++) {
			// 막대 충돌
			if (k % 2 == 0) { // 왼쪽 -> 오른쪽
				for (int i = 0; i < C; i++) {
					if (arr[R - thro[k]][i] == 'x') {
						arr[R - thro[k]][i] = '.';
						break;
					}
				}
			} else { // 오른쪽 -> 왼쪽
				for (int i = C - 1; i >= 0; i--) {

					if (arr[R - thro[k]][i] == 'x') {
						arr[R - thro[k]][i] = '.';
						break;
					}
				}
			}

			// 부서진 부분 떨어짐
			// 맨밑에 붙어있는부분 true 처리
			for(int j = 0; j<C;j++) {
				if(arr[R-1][j] == 'x' && !isvisited[R-1][j]) {
					q.add(new int[] {R-1, j});
					isvisited[R-1][j] = true;
				}
				
				while(!q.isEmpty()) {
					int[] data = q.poll();
					for(int t = 0; t<4;t++) {
						int dx_ = data[0] + dx[t];
						int dy_ = data[1] + dy[t];
						if(dx_ < 0|| dy_ < 0 || dx_ >=R || dy_ >= C) continue;
						if(arr[dx_][dy_] == '.') continue;
						if(isvisited[dx_][dy_]) continue;
						
						q.add(new int[] {dx_, dy_});
						isvisited[dx_][dy_] = true;
					}
				}
			}
			
			// 떨어진 부분 붙이기
		
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C;j++) {
					if(arr[i][j] =='x' && !isvisited[i][j]) arr_.add(new int[] {i,j});
				}
			}
			int min_height = Integer.MAX_VALUE;
			for(int i = 0; i<arr_.size(); i++) {
				int[] data = arr_.get(i);
				int j = data[0];
				for(; j < R; j++) {
					if(arr[j][data[1]] =='x' && isvisited[j][data[1]]) break;
				}
				j = j-data[0];
				if(min_height > j) min_height = j;
			}
			
			// 아래로 하강
			if(min_height != Integer.MAX_VALUE) {
				min_height--;
				for(int i = 0; i<arr_.size(); i++) {
					int[] data = arr_.get(i);
						arr[data[0]][data[1]] = '.';
						
					
				}
				for(int i = 0; i<arr_.size(); i++) {
					int[] data = arr_.get(i);
					arr[data[0]+min_height][data[1]] = 'x';
				}
				
				
			}
			
			for(int i = 0; i <R; i++) Arrays.fill(isvisited[i],false);
			arr_.clear();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		R = Integer.parseInt(str.split(" ")[0]);
		C = Integer.parseInt(str.split(" ")[1]);
		char[] a;
		arr = new char[R][C];
		isvisited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			a = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				arr[i][j] = a[j];
			}
		}

		N = Integer.parseInt(br.readLine());
		thro = new int[N];
		str = br.readLine();
		for (int i = 0; i < N; i++)
			thro[i] = Integer.parseInt(str.split(" ")[i]);

		solution();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] == 'x') {
					System.out.print(arr[i][j]);
				}
				else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		System.out.println();

	}
}

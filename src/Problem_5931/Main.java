package Problem_5931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N,M;
	static char[][] arr;
	static boolean[][] is_;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static void answer() {
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(arr[i][j] =='X') {
					q.add(new int[] {i,j});
					cnt++;
					arr[i][j] = Character.forDigit(cnt, 10);
					
					while(!q.isEmpty()) {
						int[] data = q.poll();
						for(int k = 0; k<4;k++) {
							int dx_ = data[0] + dx[k];
							int dy_ = data[1] + dy[k];
							
							if(dx_ < 0 || dy_ < 0 || dx_ >=N || dy_ >=M) continue;
							if(arr[dx_][dy_] == 'X') {
								q.add(new int[] {dx_, dy_});
								arr[dx_][dy_] = Character.forDigit(cnt, 10);
							}
						}
					}
				}
			}
		}
		int _dx = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(arr[i][j] =='1' && !is_[i][j]) {
					_dx = 0;
					q.add(new int[] {i,j, _dx});
					is_[i][j] = true;
					
					
					while(!q.isEmpty()) {
						int[] data = q.poll();
						for(int k = 0; k<4;k++) {
							int dx_ = data[0] + dx[k];
							int dy_ = data[1] + dy[k];
							
							if(dx_ < 0 || dy_ < 0 || dx_ >=N || dy_ >=M) continue;
							if(arr[dx_][dy_] == '.' && !is_[dx_][dy_]) {
								q.add(new int[] {dx_, dy_, data[2]+1});
								is_[dx_][dy_] = true;
							}
							else if(arr[dx_][dy_] == '2') {
								_dx = data[2];
								if(min > _dx) min = _dx;
								break;
							}
						}
					}
				}
				//init
				for(int k = 0; k<N; k++) Arrays.fill(is_[k], false);
			}
		}
		
		System.out.println(min);
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		
		arr = new char[N][M];
		is_ = new boolean[N][M];
		for(int i = 0; i < N ; i++) {
			str = br.readLine();
			for(int j = 0; j<M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		
		answer();
		
		
	}
}

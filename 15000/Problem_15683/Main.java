package Problem_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static String buf;
	static int[][] map;
	static int[][] map_cpy;
	static ArrayList<int[]> arr = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	// 남,동,북,서
	static int[] dx = {1,0,-1,0}; 
	static int[] dy = {0,1,0,-1};
	
	static void print_map() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static int a = 1;
	static void dfs(int idx) {
		if(idx >= arr.size()) {
			int cnt = cnt_area();
			if(cnt < min) min = cnt;
			return;
		}
		int[][] temp_map = new int[N][M];
		
		for(int k = 0; k<4; k++) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M;j++) {
					temp_map[i][j] = map[i][j];
				}
			}
			cctv(arr.get(idx), k);
			dfs(idx+1);
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M;j++) {
					map[i][j] = temp_map[i][j];
				}
			}
		}
	}
	static void cctv(int[] movement, int arrow) {
		// 0,1,2,3
		// (0,2),(1,3)
		// (0,1),(1,2),(2,3),(3,0)
		// (1,2,3),(2,3,0),(3,0,1),(0,1,2)
		// (0,1,2,3)
		switch(movement[2]) {
		case 1:
			move(movement[0],movement[1], arrow);
			break;
		case 2:
			if(arrow == 0 || arrow == 2) {
				move(movement[0], movement[1], 0);
				move(movement[0], movement[1], 2);
			}
			else {
				move(movement[0], movement[1], 1);
				move(movement[0], movement[1], 3);
			}
			break;
		case 3:
			if(arrow == 0) {
				move(movement[0], movement[1], 0);
				move(movement[0], movement[1], 1);
			}
			else if(arrow == 1){
				move(movement[0], movement[1], 1);
				move(movement[0], movement[1], 2);
			}
			else if(arrow == 2) {
				move(movement[0], movement[1], 2);
				move(movement[0], movement[1], 3);
			}
			else {
				move(movement[0], movement[1], 0);
				move(movement[0], movement[1], 3);
			}
			break;
		case 4:
			if(arrow == 0) {
				move(movement[0], movement[1], 0);
				move(movement[0], movement[1], 1);
				move(movement[0], movement[1], 2);
			}
			else if(arrow == 1){
				move(movement[0], movement[1], 1);
				move(movement[0], movement[1], 2);
				move(movement[0], movement[1], 3);
			}
			else if(arrow == 2) {
				move(movement[0], movement[1], 2);
				move(movement[0], movement[1], 3);
				move(movement[0], movement[1], 0);
			}
			else {
				move(movement[0], movement[1], 0);
				move(movement[0], movement[1], 3);
				move(movement[0], movement[1], 1);
			}
			break;
		case 5: 
				move(movement[0], movement[1], 0);
				move(movement[0], movement[1], 1);
				move(movement[0], movement[1], 2);
				move(movement[0], movement[1], 3);
			break;
		}
	}
	
	static void move(int x, int y, int dir) {
		int x_ = x, y_ = y;
		while(true) {
			x_ += dx[dir];
			y_ += dy[dir];
			if(x_< 0 || y_ < 0 || x_ >= N || y_ >= M) return;
			if(map[x_][y_] == 0) map[x_][y_] = 7;
			if(map[x_][y_] == 6) return;
		}
	}
	
	static int cnt_area() {
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M;j++) {
				cnt += map[i][j] == 0 ? 1 : 0;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		buf = br.readLine();
		N = Integer.parseInt(buf.split(" ")[0]);
		M = Integer.parseInt(buf.split(" ")[1]);
		map = new int[N][M];
		map_cpy = new int[N][M];
		StringTokenizer st;
		for(int i = 0; i<N;i++) {
			buf = br.readLine();
			st = new StringTokenizer(buf);
	
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] != 6) {
					arr.add(new int[] {i,j, map[i][j]});
				}
			}
		}
		dfs(0);
		System.out.println(min);
				
	}
}

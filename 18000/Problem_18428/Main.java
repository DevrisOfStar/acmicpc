package Problem_18428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,n;
	static int[][] arr;
	static boolean[][] isvisited;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static boolean flag; // true : "YES" , false : "NO"
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		isvisited = new boolean[N][N];
		StringTokenizer st;
		String str;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				str = st.nextToken();
				switch(str) {
				case "X":
					n = 0;
					break;
				case "S":
					n = 1;
					break;
				case "T":
					n = 2;
					break;
				default:
					n = 0;
					break;
				}
				arr[i][j] = n;
			}
		}
		makeMap(0);
		System.out.println(flag ? "YES" : "NO");
	}

	static public void getAnswer() {
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j] == 2) {
					for(int k = 0; k<4;k++) {
						int x_ = dx[k] + i;
						int y_ = dy[k] + j;
						if(x_ < 0 || y_ <0 || x_ >=N || y_>=N) continue;
						if(arr[x_][y_] == 1) return;
						if(arr[x_][y_] == 3) continue;
						q.add(new int[] {x_,y_, k});
					}
				}
			}
		}
		while(!q.isEmpty()) {
			int[] data = q.poll();
			int x_ = dx[data[2]] + data[0];
			int y_ = dy[data[2]] + data[1];
			if(x_ < 0 || y_ < 0 || x_ >=N || y_>=N) continue;
			if(arr[x_][y_] == 1) return;
			if(arr[x_][y_] == 3) continue;
			q.add(new int[] {x_,y_,data[2]});
			isvisited[x_][y_] = true;
		}
		flag = true;
	}
	static public void makeMap(int num) {
		if(num == 3) {
			if(flag) return;
			getAnswer();
		} else {
			for(int i = 0; i<N; i++) {
				for(int j =0; j<N;j++) {
					if(arr[i][j] == 0) {
						arr[i][j] = 3; // O
						makeMap(num+1);
						arr[i][j] = 0;
					}
				}
			}
		}
	}
}

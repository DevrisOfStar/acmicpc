package Problem_1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] arr;
	static boolean[][] isvisited;
	static int k = 0;
	static int R,C,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		R = Integer.parseInt(str.split(" ")[0]);
		C = Integer.parseInt(str.split(" ")[1]);
		K = Integer.parseInt(str.split(" ")[2]);
		arr = new char[R][C];
		isvisited = new boolean[R][C];
		
		for(int i = 0; i<R;i++) {
			str = br.readLine();
			for(int j = 0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		if(arr[R-1][0] != 'T') visit(R-1, 0, 1);
		System.out.println(k);
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0}; 
	
	static void visit(int x, int y, int cnt) {
		if(x == 0 && y == C-1) if(K == cnt) k++;
		isvisited[x][y] = true;
		
		for(int i = 0; i<4; i++) {
			int x_ = dx[i] + x;
			int y_ = dy[i] + y;
			if(x_ < 0 || y_ < 0 || x_ >=R || y_ >= C) continue;
			if(arr[x_][y_] =='T') continue;
			if(isvisited[x_][y_]) continue;
			isvisited[x_][y_] = true;
			visit(x_, y_, cnt+1);
			isvisited[x_][y_] = false;
		}
	}
}

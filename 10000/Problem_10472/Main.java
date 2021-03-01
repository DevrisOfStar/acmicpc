package Problem_10472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[][] map = new boolean[3][3];
	static boolean[][] ans = new boolean[3][3];
	static int min; 
	static int[] dx = {-1,1,0,0,0};
	static int[] dy = {0,0,-1,1,0};
	public static void answer(int idx, int cnt) {
		if(idx == 3) {
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++) {
					if(map[i][j] != ans[i][j]) return;
				}
			}
			if(cnt < min) min = cnt;
		}
		else {
			for(int i = 0; i<(1<<3); i++) {
				int num = 0;
				for(int j = 0; j<3; j++) {
					
					if((i & (1<<j)) == (1<<j)) {
						for(int k = 0; k<5; k++) {
							int x_ = dx[k] + idx;
							int y_ = dy[k] + j;
							if(x_ < 0 || y_ < 0 || x_>= 3 || y_ >=3) continue;
							map[x_][y_] = map[x_][y_] == true ? false : true;
						}
						num++;
					}
				}
				answer(idx+1, num + cnt);
				for(int j = 0; j<3; j++) {
					if((i & (1<<j)) == (1<<j)) {
						for(int k = 0; k<5; k++) {
							int x_ = dx[k] + idx;
							int y_ = dy[k] + j;
							if(x_ < 0 || y_ < 0 || x_>= 3 || y_ >=3) continue;
							map[x_][y_] = map[x_][y_] == true ? false : true;
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String buf;
		for(int t = 1; t<=T; t++) {
			for(int i = 0; i<3; i++) {
				buf = br.readLine();
				for(int j = 0; j<3; j++) {
					ans[i][j] = buf.charAt(j) == '*' ? true : false;
				}
			}
			min = Integer.MAX_VALUE;
			answer(0, 0);
			sb.append(min).append("\n");
			for(int i = 0; i<3;i++) Arrays.fill(map[i], false);
		}
		System.out.println(sb.toString());
	}
}

package Problem_4108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] map = new boolean[101][101];
	static int[][] map2 = new int[101][101];
	static int r, c;
	static String buf;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		buf = br.readLine();
		StringBuilder sb = new StringBuilder();
		while(!buf.equals("0 0")) {
			r = Integer.parseInt(buf.split(" ")[0]);
			c = Integer.parseInt(buf.split(" ")[1]);
			for(int i = 0; i<r; i++) {
				for(int j = 0;j<c;j++) {
					map[i][j] = false;
					map2[i][j] = 0;
				}
			}
		
			for(int i = 0; i<r; i++) {
				buf = br.readLine();
				for(int j = 0; j<c;j++) {
					map[i][j] = buf.charAt(j) == '.' ?
							true : false; 
				}
			}
			
			for(int i = 0; i<r; i++) {
				for(int j = 0; j<c;j++) {
					if(map[i][j]) {
						for(int k = 0; k<8;k++) {
							int x_ = dx[k] + i;
							int y_ = dy[k] + j;
							if(x_ < 0 || y_ < 0 || x_ >= r || y_ >= c)
								continue;
							if(!map[x_][y_]) map2[i][j]++;
						}
					} else {
						map2[i][j] = -1;
					}
				}
			}
			for(int i = 0;i<r; i++) {
				for(int j = 0; j<c; j++) {
					sb.append(map2[i][j] >= 0 ? map2[i][j] : "*");
				}
				sb.append("\n");
			}
			buf = br.readLine();
		}
		
		System.out.println(sb.toString());
	}
}

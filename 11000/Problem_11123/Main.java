package Problem_11123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[][] arr = new boolean[100][100];
	static boolean[][] isvisited = new boolean[100][100];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		int H, W;
		StringBuilder sb = new StringBuilder();
		Queue<int[]> q = new LinkedList<>();
		 
		for(int t = 1; t<=T; t++) {
			str = br.readLine();
			H = Integer.parseInt(str.split(" ")[0]);
			W = Integer.parseInt(str.split(" ")[1]);
			// init_
			for(int i = 0; i<H; i++) {
				str = br.readLine();
				for(int j = 0; j<W; j++) {
					arr[i][j] = str.charAt(j) == '#' ? true : false;
					isvisited[i][j] = false;
				}
			}
			int cnt = 0;
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					if(arr[i][j] && !isvisited[i][j]) {
						cnt++;
						q.add(new int[] {i,j});
						 
						while(!q.isEmpty()) {
							int[] data = q.poll();
							 
							for(int k = 0; k<4; k++) {
								int x_ = dx[k] + data[0]; 
								int y_ = dy[k] + data[1];
								if(x_ < 0 || y_ < 0 || x_>=H || y_>=W) continue;
								if(!arr[x_][y_]) continue;
								if(isvisited[x_][y_]) continue;
								q.add(new int[] {x_,y_});
								isvisited[x_][y_] = true;
							}
						}
					}
				}
			 }
			 sb.append(cnt).append("\n");
		 }
		 System.out.println(sb.toString());
	}
}

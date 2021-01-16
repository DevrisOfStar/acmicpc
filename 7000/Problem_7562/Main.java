package Problem_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int T, I;
	static int[] dx = {-1,-2,-2,-1,1,2,2,1};
	static int[] dy = {-2,-1,1,2,-2,-1,1,2};
	static int sx, sy, ex, ey;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		String buf;
		
		for(int t = 1; t<=T; t++) {			
			I = Integer.parseInt(br.readLine());
			
			buf = br.readLine();
			sx = Integer.parseInt(buf.split(" ")[0]);
			sy = Integer.parseInt(buf.split(" ")[1]);
			
			buf = br.readLine();
			ex = Integer.parseInt(buf.split(" ")[0]);
			ey = Integer.parseInt(buf.split(" ")[1]);
			min = Integer.MAX_VALUE;
			
			answer();
			
			System.out.println(min);
		}	
	}
	
	public static void answer() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sx, sy, 0});
		boolean[][] isvisited = new boolean[I][I];
		isvisited[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			
			if(min < data[2]) continue;
			
			if(data[0] == ex && data[1] == ey) 
				if(min > data[2]) min = data[2];
			
			for(int k = 0; k<dx.length;k++) {
				int dx_ = dx[k] + data[0];
				int dy_ = dy[k] + data[1];
				if(dx_ < 0 || dy_ < 0 || dx_ >= I || dy_ >= I) continue;
				if(isvisited[dx_][dy_]) continue;
				q.add(new int[] {dx_, dy_, data[2]+1});
				isvisited[dx_][dy_] = true;
			}
		}
	}
}

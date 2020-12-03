package Problem_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int M, N, K;
		M = Integer.parseInt(str.split(" ")[0]);
		N = Integer.parseInt(str.split(" ")[1]);
		K = Integer.parseInt(str.split(" ")[2]);
		
		boolean[][] map = new boolean[N][M];
		
		for(int i = 0; i<K;i++) {
			str = br.readLine();
			
			int x1, y1, x2, y2;
			x1 = Integer.parseInt(str.split(" ")[0]);
			y1 = Integer.parseInt(str.split(" ")[1]);
			x2 = Integer.parseInt(str.split(" ")[2]);
			y2 = Integer.parseInt(str.split(" ")[3]);
			
			for(int a = x1; a < x2; a++) {
				for(int b = y1; b < y2; b++) {
					map[a][b] = true;
				}
			}
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M;j++) {
				if(!map[i][j]) {
					int cnt = 1;
					map[i][j] = true;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] data = q.poll();
						for(int k = 0; k<4;k++) {
							int x_ = dx[k] + data[0];
							int y_ = dy[k] + data[1];
							if(x_ <0 || y_ < 0 || x_ >= N || y_ >= M) continue;
							if(map[x_][y_]) continue;
							cnt++;
							map[x_][y_] = true;
							q.add(new int[] {x_,y_});
						}
					}
					answer.add(cnt);
				}
			}
		}
		answer.sort(null);
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()+"\n");
		for(int i = 0; i<answer.size();i++)
			sb.append(answer.get(i)).append(" ");
		System.out.println(sb.toString().trim());
	}
	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
}

package Problem_5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 25%에서 실패 - 원인 찾아보기
public class Main {

	public static int s_x;
	public static int s_y;
	public static int w, h;
	public static char[][] map;
	public static boolean[][] visited_f;
	public static boolean[][] visited_u;
	public static int[] dir_x = {0,0,-1,1};
	public static int[] dir_y = {1,-1,0,0};
	public static ArrayList<int[]> f_arr = new ArrayList<>();
	public static void bfs() {
		Queue<int[]> f = new LinkedList<>();
		Queue<int[]> f_t = new LinkedList<>();
		Queue<int[]> u = new LinkedList<>();
		Queue<int[]> u_t = new LinkedList<>();
		int x_, y_;
		
		// init data
		for(int i = 0 ; i<f_arr.size();i++) f.add(f_arr.get(i));
		u.add(new int[] {s_x,s_y});
		int time = 0;
		while(!u.isEmpty()) { // end condition
			// 불 전이
			while(!f.isEmpty()) f_t.add(f.poll()); // 복사
			while(!f_t.isEmpty()) {
				int[] f_dir = f_t.poll();
				
				for(int i = 0; i<4;i++) {
					x_ = f_dir[0] + dir_x[i];
					y_ = f_dir[1] + dir_y[i];
					
					if(0>x_ || y_<0 || x_ >=h || y_>=w) continue;
					if((map[x_][y_] != '*' || map[x_][y_]!='#') && !visited_f[x_][y_]) {
						f.add(new int[] {x_,y_});
						visited_f[x_][y_] = true;
						map[x_][y_] = '*';
					}
				}
			}
			// 불 전이 완료
			
			while(!u.isEmpty()) u_t.add(u.poll()); // 복사
			while(!u_t.isEmpty()) {
				int[] u_dir = u_t.poll();
				
				for(int i = 0; i<4; i++) {
					x_ = u_dir[0] + dir_x[i];
					y_ = u_dir[1] + dir_y[i];
					
					if(0>x_ || y_<0 || x_ >=h || y_>=w) {
						System.out.println(time+1);
						return;
					}
					if(map[x_][y_]=='.' && !visited_u[x_][y_]) {
						u.add(new int[] {x_,y_});
						visited_u[x_][y_] = true;
					}
				}
			}			
			time++;		
		}
		System.out.println("IMPOSSIBLE");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			bf = br.readLine();

			w = Integer.parseInt(bf.split(" ")[0]);
			h = Integer.parseInt(bf.split(" ")[1]);
			map = new char[h][w];
			visited_f = new boolean[h][w];
			visited_u = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				bf = br.readLine();

				for (int j = 0; j < w; j++) {
					map[i][j] = bf.charAt(j);
					if (map[i][j] == '@') {
						s_x = i;
						s_y = j;
					}
					else if(map[i][j] == '*') {
						f_arr.add(new int[] {i,j});
						visited_f[i][j] = true;
					}
					else if(map[i][j] == '#') {
						visited_f[i][j] = true;
					}
				}
			} // end input
			bfs();
			
		
		} // end for.
	}
}

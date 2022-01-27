package Problem_1331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dx = {-2,-1, 1, 2,-2,-1,1,2};
	static int[] dy = {-1,-2,-2,-1, 1, 2,2,1};
	static int[] start = new int[2];
	static int[] state = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] isvisited = new boolean[6][6];
		String str = br.readLine();
		int x = str.charAt(0) - 'A';
		int y = str.charAt(1) - '1';
		
		isvisited[x][y] = true;
		state[0] = x; state[1] = y;
		start[0] = x; start[1] = y;
		
		for(int i = 0; i<35; i++) {
			str = br.readLine();
			x = str.charAt(0) - 'A';
			y = str.charAt(1) - '1';
		
			if(!isvalid(x, y) || isvisited[x][y]) {
				System.out.println("Invalid");
				return;
			}
			
			isvisited[x][y] = true;
			state[0] = x; state[1] = y;
		}
		
		for(int i = 0; i<8; i++) {
			int x_ = state[0] + dx[i];
			int y_ = state[1] + dy[i];
			if(x_ < 0 || y_ < 0 || x_ >= 6 || y_ >= 6) continue;
			if(start[0] == x_ && start[1] == y_) {
				System.out.println("Valid");
				return;
			}
		}
		
		System.out.println("Invalid");
	}
	
	public static boolean isvalid(int x, int y) {
		int x_, y_;
		for(int i = 0; i<8; i++) {
			x_ = x + dx[i];
			y_ = y + dy[i];
			
			if(x_ < 0 || y_ < 0 || x_ >= 6 || y_ >= 6) continue;
			if(state[0] == x_ && state[1] == y_) return true;
		}
		return false;
	}
}

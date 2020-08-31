package Problem_16954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map = new int[8][8];
	static int[] dx = {0,0,1,-1,1,1,-1,-1,0};
	static int[] dy = {1,-1,0,0,-1,1,-1,1,0};
	static boolean[][][] isvisited = new boolean[30][8][8];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf;
		for(int i = 0; i <8; i++) {
			bf = br.readLine();
			for(int j = 0; j <8; j++) {
				map[i][j] = (bf.charAt(j) == '.' ? 0 : 1);
			}
		}
	
		solve();
	}
	
	public static void solve() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {7,0});
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i<size; i++) {
				int[] data = q.poll();
				
				if(map[data[0]][data[1]] == 1) continue;
				if(data[0] == 0 && data[1] == 7) {
					System.out.println("1");
					return;
				}
				for(int k = 0; k < 9; k++) {
					int x_ = data[0] + dx[k];
					int y_ = data[1] + dy[k];
					if(x_ < 0 || x_ >= 8 || y_ < 0 || y_>= 8) continue;
					if(!isvisited[cnt][x_][y_] && map[x_][y_] != 1) {
						isvisited[cnt][x_][y_] = true;
						q.add(new int[] {x_,y_});
					}
				}
			}
			
			down();
			cnt++;
		}
		
		System.out.println("0");
	}
	
	public static void printMap() {
		// 데이터 확인용 메소드
		for(int i = 0; i <8; i++) {
			for(int j = 0; j <8 ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void down() {
		// 행 아래로 하나 내리기
		int[][] copyMap = new int[8][8];
		
		for(int i = 1; i <8;i++)
			for(int j = 0; j <8;j++)
				copyMap[i][j] = map[i-1][j];

		for(int i = 0; i <8;i++)
			for(int j = 0; j <8;j++)
				map[i][j] = copyMap[i][j];
	}
}



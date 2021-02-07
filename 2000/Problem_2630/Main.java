package Problem_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt_blue;
	static int cnt_white;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer(N, 0, 0);
		System.out.println(cnt_white);
		System.out.println(cnt_blue);
	}
	static void answer(int size, int i_, int j_) {
		if(size == 1) {
			if(map[i_][j_] == 1) cnt_blue++;
			if(map[i_][j_] == 0) cnt_white++;
			return;
		}
		
		int cnt = 0;
		for(int i = i_; i<i_+size;i++) {
			for(int j = j_; j<j_+size;j++) {
				cnt += map[i][j];
			}
		}
		
		if(cnt == size*size) cnt_blue++;
		else if(cnt == 0) cnt_white++;
		else {
			for(int i = 0; i<2; i++) {
				for(int j = 0; j<2; j++) {
					answer(size/2, i_ + size/2 * i, j_ + size/2 * j);
				}
			}
		}
	}
}

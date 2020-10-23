package Problem_2448;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] map = new char[3500][6500];
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		
		for(int i = 0 ; i<3500; i++) Arrays.fill(map[i],' ');
		
		draw(N/3, 0, 0);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<2*N - 1;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static char[][] draws = {{' ',' ','*', ' ', ' '},
			{' ','*',' ', '*', ' '},
			{'*','*','*', '*', '*'}};
	
	public static void draw(int N, int x, int y) {
		if(N == 1) {
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<5; j++) {
					map[i+x][j+y] = draws[i][j]; 					
				}
			}
		}
		else {
			// 점화식으로 유도
			draw(N/2, x, y + 3 * N / 2);
			draw(N/2, x + 3*N/2, y);
			draw(N/2, x + 3*N/2, y + 3*N);
		}
	}
}

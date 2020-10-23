package Problem_2447;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] map = new char[3000][3000];
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		
		for(int i = 0 ; i<3000; i++) Arrays.fill(map[i],' ');
		
		draw(N, 0, 0);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<N;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static int a;
	public static void draw(int N, int x, int y) {
		if(N == 1) {
			map[x][y] = '*';
		}
		else {
			int div = N/3;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j<3;j++) {
					if(i==1 && j==1) continue;
					draw(div, x + div * i, y + div * j);
				}
			}
		}
	}
}

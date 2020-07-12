package Problem_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] arr;
	static int R,C;
	static int max_can = Integer.MIN_VALUE;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static void answer(int x, int y, String alpha) {
		for(int i = 0; i <4; i++) {
			int dx_ = x + dx[i];
			int dy_ = y + dy[i];
			if(dx_ < 0 || dx_ >= R || dy_ < 0 || dy_ >= C) continue;
			if(alpha.contains(String.valueOf(arr[dx_][dy_]))) continue;
			answer(dx_,dy_, alpha+arr[dx_][dy_]);
		}
			
		if(max_can < alpha.length()) max_can = alpha.length();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String buffer = br.readLine();
		
		R = Integer.parseInt(buffer.split(" ")[0]);
		C = Integer.parseInt(buffer.split(" ")[1]);
		arr = new char[R][C];
		
		for(int i = 0; i<R; i++) {
			buffer = br.readLine();
			for(int j = 0; j <C ; j++) {
				arr[i][j] = buffer.charAt(j);
			}
		}
		answer(0, 0, String.valueOf(arr[0][0]));
		System.out.println(max_can);
	}
}

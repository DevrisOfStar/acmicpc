package Problem_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[] answers = new int[3]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer(0, 0, N);
		
		for(int i = 0; i <3; i++) System.out.println(answers[i]);
	}
	static void answer(int x, int y, int N) {
		if(N == 1) {
			answers[arr[x][y] + 1]++;
		}
		else {
			int num = arr[x][y];
			boolean flag = true;
			for(int i = x; i<x+N; i++) {
				for(int j = y; j<y+N;j++) {
					if(arr[i][j] != num) {
						flag = false;
						break;
					}
				}
			}
			
			if(flag) {
				answers[num+1]++;
				return;
			} else {
				int M = N/3;
				for(int i = 0; i <3 ; i++) {
					for(int j = 0 ; j<3; j++) {
						answer(x+i*M, y+j*M, M);
					}
				}
			}
		}
	}
}

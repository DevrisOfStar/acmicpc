package Problem_1010;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		long[][] arr = new long[31][31];
		
		for(int i = 0; i<=30; i++) {
			arr[1][i] = i;
			arr[i][i] = 1;
		}
		
		for(int i = 2; i <= 30; i++) {
			for(int j = i+1; j<= 30;j++) {
				for(int k = j; k >= 1; k--) {
					arr[i][j] += arr[i-1][j-k];					
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sb.append(arr[N][M]).append("\n");
		}
		
		System.out.println(sb.toString());
		
		
	}
}

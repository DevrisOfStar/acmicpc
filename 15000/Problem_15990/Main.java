package Problem_15990;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[100001][4];
		
		// 마지막 덧셈의 수가 j로 끝나는 합 i
		
		arr[1][1] = 1; 
		arr[2][2] = 1; 
		arr[3][1] = 1; arr[3][2] = 1; arr[3][3] = 1; // 2+1, 1+2, 3
		
		for(int i = 4; i<= 100000; i++) {
			for(int j = 1; j<=3; j++) {
				for(int k = 1; k<=3; k++) {
					if(j == k) continue;
					arr[i][j] += arr[i-j][k];
					arr[i][j] %= 1000000009;
				}
			}
		}
		
		int a;
		int answer = 0;
		for(int i = 1; i<=T; i++) {
			a = sc.nextInt();
			answer = 0;
			for(int j = 1; j<=3;j++) {
				answer += arr[a][j];
				answer %= 1000000009; 
			}
			System.out.println(answer);
		}
	}
}

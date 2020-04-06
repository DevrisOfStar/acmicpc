package Problem_11057;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[1001][10];
		int N = sc.nextInt();
		for(int i = 0; i<10; i++) {
			arr[1][i] = 1;
		}
		
		for(int i = 2; i<= N; i++) {
			for(int j = 0; j< 10; j++) {
				for(int k = 0; k< 10; k++) {
					if(j <= k) {
						arr[i][j] += arr[i-1][k];
						arr[i][j] %= 10007;
					}
				}
			}
		}
		int sum = 0;
		for(int i = 0 ; i<10; i++) {
			sum += arr[N][i];
			sum %= 10007;
		}
		
		System.out.println(sum);
	}
}

package Problem_10844;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[101][10];
		int N = sc.nextInt();

		for (int i = 1; i < 10; i++)
			arr[1][i] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if(j == 0) {
					arr[i][j] = arr[i-1][1];
				}
				else if(j == 9) {
					arr[i][j] = arr[i-1][8];
				}
				else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1];
				}
				arr[i][j] %= 1000000000;
			}
		}
		int sum = 0;
		for(int i = 0; i<10; i++) {
			sum += arr[N][i];
			sum %= 1000000000;
		}
		
		System.out.println(sum);
		

	}
}

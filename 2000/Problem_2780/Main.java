package Problem_2780;

import java.util.Scanner;

public class Main {

	static int modnum = 1234567;
	static int N;
	static int[][] arr = new int[1001][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 0; i<10; i++) arr[1][i]=1;
		for(int i = 2; i<=1000; i++) {
			arr[i][0] = arr[i-1][7] % modnum;
			arr[i][1] = (arr[i-1][2] + arr[i-1][4]) % modnum;
			arr[i][2] = (arr[i-1][1] + arr[i-1][3] + arr[i-1][5]) % modnum;
			arr[i][3] = (arr[i-1][2] + arr[i-1][6]) % modnum;
			arr[i][4] = (arr[i-1][1] + arr[i-1][5] + arr[i-1][7]) % modnum;
			arr[i][5] = (arr[i-1][2] + arr[i-1][4] + arr[i-1][6] + arr[i-1][8]) % modnum;
			arr[i][6] = (arr[i-1][3] + arr[i-1][5] + arr[i-1][9]) % modnum;
			arr[i][7] = (arr[i-1][4] + arr[i-1][8] + arr[i-1][0]) % modnum;
			arr[i][8] = (arr[i-1][5] + arr[i-1][7] + arr[i-1][9]) % modnum;
			arr[i][9] = (arr[i-1][6] + arr[i-1][8]) % modnum;
		}
		StringBuilder sb = new StringBuilder();
		for(int n = 1; n<=N; n++) {
			int num = sc.nextInt();
			int answer = 0;
			for(int i = 0; i<10;i++)
				answer = (answer + arr[num][i]) % modnum;
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString().trim());
	}
	
	
}

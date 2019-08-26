package Problem_9095;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = new int[21];
		int N;
		arr[1] = 1; arr[2] = 2; arr[3] = 4;
		for(int i = 4; i < arr.length;i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		for(int t = 1; t <=T;t++) {
			N = sc.nextInt();
			System.out.println(arr[N]);
		}
	}
}

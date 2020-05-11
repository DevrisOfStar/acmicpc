package Problem_9095;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[21];
		int N;
		arr[1] = 1; arr[2] = 2; arr[3] = 4; // 1,2,3 의 합으로 만들 수 있는 1,2,3의 경우의 수를 미리 입력. 
		for(int i = 4; i < arr.length;i++) { // 4이상의 수에 대해서, 1의 경우의수 + (3), 2의 경우의수 + (2), 3의 경우의수 +(1)의 경우의수를 합산하여 결과를 구함
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		for(int t = 1; t <=T;t++) { // 해당하는 결과값을 출력
			N = sc.nextInt();
			System.out.println(arr[N]);
		}
	}
}

package Problem_9461;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] arr = new long[101];
		
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i = 3; i<=100;i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		
		for(int i = 0 ; i < T ; i++) {
			System.out.println(arr[sc.nextInt()]);
		}
		
	}
}

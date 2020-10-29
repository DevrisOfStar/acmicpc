package Problem_15624;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		int n = new Scanner(System.in).nextInt();
		int a = n;
		
		if(n <= 3) n = 3;
		
		long[] arr = new long[n+1];
		
		arr[1] = 1;
		for(int i = 2; i<=n; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
		}
		
		System.out.println(arr[a]);
	}
}

package Problem_1788;

import java.util.Scanner;

public class Main {
	
	static long[] data = new long[1000001];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int absN = Math.abs(N);
		data[1] = 1;
		if(N > 0) {
			System.out.println("1");

		}
		else if(N == 0) {
			System.out.println("0");
			System.out.println("0");
			return;
		}
		else {
			int n = N%2 == 0 ? -1 : 1;
			System.out.println(n);
		}
		for(int i = 2; i<=absN;i++) {
			data[i] = data[i-1] + data[i-2];
			data[i] %= 1000000000;
		}
		System.out.println(data[absN]);
	}
}

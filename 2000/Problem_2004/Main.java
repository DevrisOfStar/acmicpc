package Problem_2004;

import java.util.Scanner;

public class Main {
	static long n,r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		r = sc.nextLong();
		long answer5 = cnt5(n);
		long answer2 = cnt2(n);
		answer5 -= cnt5(n-r);
		answer5 -= cnt5(r);
		answer2 -= cnt2(n-r);
		answer2 -= cnt2(r);
		System.out.println(Math.min(answer5, answer2));
	}
	
	public static long cnt5(long number) {
		long cnt = 0;
		for(long i = 5; i <= number; i*=5) 
			cnt += (number/i);
		return cnt;
	}
	public static long cnt2(long number) {
		long cnt = 0;
		for(long i = 2; i <= number; i*=2) 
			cnt += (number/i);
		return cnt;
	}
}

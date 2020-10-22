package Problem_1074;

import java.util.Scanner;

public class Main {
	static int N, r, c;

	public static int pow2(int x) {
		return 1<<x;
	}
	public static int answer(int n, int x, int y) {
		if(n == 1) return 2*x+y;
		else {
			if(x  < pow2(n-1)) {
				if( y < pow2(n-1)) {
					return answer(n-1, x, y);
				} else {
					return answer(n-1, x, y - pow2(n-1)) + pow2(2*n-2);
				}
			}
			else {
				if( y < pow2(n-1)) {
					return answer(n-1, x - pow2(n-1), y) + 2*pow2(2*n-2);
				} else {
					return answer(n-1, x - pow2(n-1), y - pow2(n-1)) + 3*pow2(2*n-2);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		System.out.println(answer(N,r,c));
	}
}

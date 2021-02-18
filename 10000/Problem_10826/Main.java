package Problem_10826;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 0) System.out.println(0);
		else if(N==1) System.out.println(1);
		else {
			BigInteger a = BigInteger.ZERO;
			BigInteger b = BigInteger.ONE;
			BigInteger c;
			for(int i = 2; i<=N; i++) {
				c = a.add(b);
				a = b;
				b = c;
			}
			
			System.out.println(b);
		}
	}
}

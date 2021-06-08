package Problem_4150;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		BigInteger answer = BigInteger.ONE;
		if(N==1 || N==2) {
			System.out.println(answer);
			return;
		}
		BigInteger a = BigInteger.ONE, b = BigInteger.ONE;
		for(int i = 3; i<=N;i++) {
			answer = a.add(b);
			b = a;
			a = answer;			
		}
		System.out.println(answer);
	}
}

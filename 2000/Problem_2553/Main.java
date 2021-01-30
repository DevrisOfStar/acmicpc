package Problem_2553;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long number = 1;
		for(int i = 1; i<=N;i++) {
			number *= i;
			while(number % 10 == 0 && number!=0) number /= 10;
			number %= 1000000;
		}
		
		number %= 10;
		System.out.println(number);
	}
}

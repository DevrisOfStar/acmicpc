package Problem_1564;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long answer = 1;
		
		for(int i = 1; i<=N; i++) {
			answer *= i;
			while(answer % 10 == 0) answer /= 10;
			answer %= 1000000000000l;
		}
		String answer_s = String.valueOf(answer);
		answer_s = answer_s.substring(answer_s.length()-5, answer_s.length());
		
		System.out.println(answer_s);
	}
}

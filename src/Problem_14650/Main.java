package Problem_14650;

import java.util.Scanner;

public class Main {
	static int N, cnt;
	
	static void answer(int n, int number) {
		if(N == n) {
			if(number%3 == 0 && number!=0 && String.valueOf(number).length() == N) {
				cnt++;
			}
		}
		else {
			for(int i = 0; i <3;i++) {
				answer(n+1, number*10+i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		answer(0, 0);
		System.out.println(cnt);
	}
}

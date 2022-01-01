package Problem_1612;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		for(int i = 1; i<=1000000; i++) {
			answer*=10;
			answer = answer % N;
			answer++;
			answer = answer % N;
			if(answer == 0) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
package Problem_1436;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		int answer = 666;
		String str;
		for(int i = 666; count < N; i++) {
			str = String.valueOf(i);
			if(str.contains("666")) {
				answer = i;
				count++;
			}
		}
		System.out.println(answer);
	}
}

package Problem_2439;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 1; i<=N;i++) {
			for(int j = N-i; j>0;j--) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

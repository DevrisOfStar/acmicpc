package Problem_1094;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int cnt = 0;
		while(t > 0) {
			if(t%2==1) {
				cnt++;
			}
			t/=2;
		}
		System.out.println(cnt);
	}
}

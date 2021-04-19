package Problem_2168;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), y = sc.nextInt();
		int m = gcd(x,y);
		int answer = x + y - m;
		System.out.println(answer);
	}
	
	public static int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, x%y);
	}
}

package Problem_2078;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long left = 0;
		long right = 0;
		while(a != 1 || b!=1) {
			if(a > b) {
				left++;
				a -= b;
			}
			else {
				right++;
				b -= a;
			}
		}
		System.out.println(left + " " + right);
	}
}


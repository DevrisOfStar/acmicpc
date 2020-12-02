package Problem_8394;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n==1) System.out.println(1);
		else if(n==2) System.out.println(2);
		else {
			long a = 1, b = 2;
			long c = 0;
			for(int i = 3; i<=n;i++) {
				c = ((a % 10) + (b % 10)) % 10;
				if(i!=n) {
					a = b; b = c;
				}
			}
			System.out.println(c);
		}
	}
}

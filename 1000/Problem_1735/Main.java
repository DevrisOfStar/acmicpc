package Problem_1735;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int e = a*d + b*c;
		int f = b*d;
		int g = e;
		int h = f;
		
		while(h!=0) {
			int r = g%h;
			g = h;
			h = r;
		}
		
		e /= g;
		f /= g;
		System.out.println(e + " " + f);
	}
}

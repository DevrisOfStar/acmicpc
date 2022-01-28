package Problem_9659;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 창영 win : true, 상근 win : false
		long N = sc.nextLong();
		// 0,1,0,1.. 반복
		System.out.println(N%2 == 0 ? "CY" : "SK");
	}
}

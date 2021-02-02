package Problem_14916;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int charge = sc.nextInt();
		
		int coin_2 = 0;
		int coin_5 = charge/5;
		int t = coin_5;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i<=t; i++) {
			coin_5 = i;
			if((charge - coin_5*5) % 2 == 0) {
				coin_2 = (charge - coin_5*5)/2;
				if(min > coin_2 + coin_5) {
					min = coin_2 + coin_5;
				}
			}			
		}
		if(min!= Integer.MAX_VALUE) System.out.println(min);
		else System.out.println(-1);
	}
}

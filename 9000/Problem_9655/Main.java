package Problem_9655;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[] isWin = new boolean[N+3];
		
		isWin[1] = true; isWin[3] = true;
					
		for(int i = 4; i<=N; i++) // false, false일때 이김 
			isWin[i] = !isWin[i-3] && !isWin[i-1];
		
			
		if(isWin[N]) System.out.println("SK");
		else System.out.println("CY");	
	}
}

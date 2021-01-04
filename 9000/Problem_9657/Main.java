package Problem_9657;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[] arr = new boolean[1001];
		// true : 상근이가 이김, false : 창영이가 이김
		arr[1] = true;
		arr[2] = false;
		arr[3] = true;
		arr[4] = true;
		
		for(int i = 5; i<=1000;i++) 
			arr[i] = !(arr[i-3]&&arr[i-4]&&arr[i-1]);
		
		if(arr[N]) System.out.println("SK");
		else System.out.println("CY");
	}
}

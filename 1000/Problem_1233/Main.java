package Problem_1233;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S1 = sc.nextInt();
		int S2 = sc.nextInt();
		int S3 = sc.nextInt();
		int[] arr = new int[S1+S2+S3+1];

		for(int i = 1; i<=S1;i++) 
		for(int j = 1; j<=S2;j++) 
		for(int k = 1; k<=S3;k++) 
			arr[i+j+k]++;

		int index = 0;
		for(int i = 1; i<= S1+S2+S3;i++) 
			if(arr[i] > arr[index]) index = i;
		
		System.out.println(index);
	}
}

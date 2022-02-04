package Problem_2851;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		arr[0] = sc.nextInt();
		for(int i =1; i<10;i++) { arr[i] = arr[i-1] + sc.nextInt(); }
		int min = 0;
		for(int i = 0; i<10; i++) {
			if(Math.abs(min - 100) > Math.abs(arr[i] - 100)) {
				min = arr[i];
			}
			else if(Math.abs(min - 100) == Math.abs(arr[i] - 100)) {
				if(min < arr[i]) min = arr[i];
			}
		}
		System.out.println(min);
	}
}

package Problem_2033;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 10; ;i*=10) {
			if(i<N) {
				double N_ = Math.round(N/((double)i));
				N = (int)(N_*i);
			}
			else {
				break;
			}
		}
		
		System.out.println(N);
	}
}

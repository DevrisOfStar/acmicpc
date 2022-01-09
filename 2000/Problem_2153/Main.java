package Problem_2153;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int number = 0;
		for(int i = 0; i<str.length();i++) {
			char s = str.charAt(i);
			
			if('A' <= s && s <='Z') {
				number += (s-'A'+27);
			}
			if('a' <= s && s <='z') {
				number += (s-'a'+1);
			}
		}
		
		boolean[] isPrime = new boolean[3000];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = true;
		for(int i = 2; i<= 2000; i++) {
			for(int j = i+i; j<=2000; j += i) {
				isPrime[j] = false;
			}
		}
		
		if(isPrime[number]) System.out.println("It is a prime word.");
		else System.out.println("It is not a prime word.");
	}
}

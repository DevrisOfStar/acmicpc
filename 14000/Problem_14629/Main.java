package Problem_14629;

import java.util.Scanner;

public class Main {
	static boolean[] isvisited = new boolean[10];
	static long number;
	static int size;
	static long min;
	static void answer(int idx, long num) {
		if(idx <= 10) {
			long cha = Math.abs(number - min);
			long cha2 = Math.abs(number - num);
			if(cha > cha2) {
				min = num;
			}
			else if(cha == cha2) {
				if(min > num) min = num;
			}
		} 
		
		for(int i = 0; i<10;i++) {
			if(!isvisited[i]) {
				isvisited[i] = true;
				answer(idx+1, num*10 + i);
				isvisited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		number = sc.nextLong();
		size = String.valueOf(number).length();
		min = number*2;
		answer(0, 0);
		System.out.println(min);
	}
}

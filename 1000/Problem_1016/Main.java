package Problem_1016;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long answer = b - a + 1;
		long i = 2;
		boolean[] ischeck = new boolean[(int)answer];
		while(i * i <= b) {
			
			long m = a / (i * i);
			
			if(a % (i*i) != 0) m++;
			
			while(m * (i*i) <= b) {
				if(!ischeck[(int)(m*(i*i) - a)]) {
					ischeck[(int)(m*(i*i) - a)] = true;
					answer -= 1;
				}
				m+=1;
			}
			
			i++;
		}
		
		System.out.println(answer);
	}
}

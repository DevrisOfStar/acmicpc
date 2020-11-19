package Problem_1052;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); int K = sc.nextInt();
		
		int result;
		// 정답이 안나오는 경우는 없다.
		for(result = 0;;result++) {
			int cnt = 0;
			int tmp = N;
			
			while(tmp != 0) {
				if(tmp % 2 != 0) cnt++;
				tmp/=2;
			}
			if(cnt <= K) break; N++;
		}
		
		System.out.println(result);
	}
}

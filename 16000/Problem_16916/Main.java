package Problem_16916;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String src = sc.nextLine();
		int[] src_f = new int[src.length()];
		
		
		// failure 함수
		for(int i=1, j=0; i<src.length();i++) {
			while(j>0 && src.charAt(i) != src.charAt(j)) j = src_f[j-1];
			if(src.charAt(i) == src.charAt(j)) src_f[i] = ++j;
		}
		
		// KMP 함수
		int answer = 0;
		for(int i = 0, j = 0; i < str.length();i++) {
			
			// 역으로 failure 함수를 맞춤.
			while(j > 0 && str.charAt(i) != src.charAt(j)) j = src_f[j-1];
			
			// 일치 했을때, j가 src의 길이 - 1만큼 온 경우, 부분문자열을 찾음.
			if(str.charAt(i) == src.charAt(j)) {
				if(j == src.length()-1) {
					answer = 1; break;
				}
				else j++;
			}
		}
		
		System.out.println(answer);
	}
}

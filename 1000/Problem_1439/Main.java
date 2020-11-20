package Problem_1439;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] cnt = new int[2];
		char cur = str.charAt(0);
		for(int i = 0; i<str.length();i++) {
			if(cur == str.charAt(i)) continue;
			cnt[cur-'0']++;
			cur = str.charAt(i);	
		}
		if(cnt[0] != 0 || cnt[1] != 0) cnt[cur-'0']++;
		
		System.out.println(Math.min(cnt[0],cnt[1]));
	} 
}

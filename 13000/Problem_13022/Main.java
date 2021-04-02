package Problem_13022;

import java.util.Scanner;

public class Main {
	public static int getOrder(char c) {
		return "wolf".indexOf(c);
	}
	public static int getch(int index) {
		return "wolf".charAt(index);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean flag = true;
		int pre_order = getOrder(str.charAt(0));
		int order = 0;
		if(pre_order != 0) flag = false;
		int a;
		int[] cnt = new int[4];
		cnt[pre_order]++;
		if(flag) {
			for(int i = 1; i<str.length();i++) {
				order = getOrder(str.charAt(i));
				if(pre_order == order || (pre_order+1)%4 == order) {
					cnt[order]++;
				}
				else flag = false;
				
				if(pre_order == 3 && order == 0) {
					a = cnt[0] - 1;
					for(int j = 0; j<4; j++) {
						if(cnt[j] - a < 0) flag = false;
						cnt[j] = 0;
					}
					cnt[0] = 1;
				}
				pre_order = order;
			}	
		}
		a = cnt[0];
		for(int i = 0; i<4; i++) {
			if(cnt[i] != a) flag = false;
		}
		
		// result
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
}

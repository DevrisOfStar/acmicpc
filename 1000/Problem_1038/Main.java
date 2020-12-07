package Problem_1038;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<Long> list = new ArrayList<>();
	
	static void dfs(long num) {
		long var = num % 10; long num2 = num*10;
		for(int i = 0; i<var; i++) {
			list.add(num2 + i);
			dfs(num2+i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i<10;i++) {
			list.add((long)(i));
			dfs(i);
		}
		Collections.sort(list);
		if(n < list.size()) System.out.println(list.get(n));
		else System.out.println(-1);
	}
}

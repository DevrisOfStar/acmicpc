package Problem_9294;

import java.util.Scanner;

public class Main {
	static int n,m,s;
	static StringBuilder sb;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int c = 1; c<=C;c++) {
			n = sc.nextInt();
			m = sc.nextInt();
			s = sc.nextInt();
			arr = new int[n];
			sb = new StringBuilder("Case ");
			sb.append(c + ":").append("\n");
			answer(0,0);
			System.out.print(sb.toString());
		}
	}
	
	public static void answer(int num, int sum) {
		if(num == n) {
			if(sum == s) {
				sb.append("(");
				for(int i = 0; i<arr.length; i++) {
					sb.append(arr[i]);
					if(i != arr.length-1) sb.append(","); 
				}
				sb.append(")\n");
			}
		} else if(num == 0){
			for(int i = 1; i<=m; i++) {
				arr[num] = i;
				answer(num+1, sum+i);
				arr[num] = 0;
			}
		} else {
			for(int i = arr[num-1]; i<=m; i++) {
				arr[num] = i;				
				answer(num+1, sum+i);
				arr[num] = 0;
			}
		}
	}
}

package Problem_16943;

import java.util.Scanner;

public class Main {
	static int A,B;
	static char[] arr = new char[1];
	static boolean[] isvisited = new boolean[1];
	static int[] idx_ = new int[1];
	static int answer = -1;
	
	public static void answer(int idx) {
		if(idx == arr.length) {
			String str = "";
			if(arr[idx_[0]] == '0') return;
			for(int i = 0; i<arr.length; i++) str += arr[idx_[i]];
			int num = Integer.valueOf(str);
			if(answer < num && B >= num) answer = num;
		} else {
			for(int i = 0; i <isvisited.length; i++) {
				if(!isvisited[i]) {
					idx_[idx] = i;
					isvisited[i] = true;
					answer(idx+1);
					isvisited[i] = false;
					idx_[idx] = 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		arr = String.valueOf(A).toCharArray();
		isvisited = new boolean[arr.length];
		idx_ = new int[arr.length];
		answer(0);
		System.out.println(answer);
	}
}

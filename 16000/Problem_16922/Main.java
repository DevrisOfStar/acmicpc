package Problem_16922;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N;
	static int[] nums = {1,5,10,50};
	static int cnt =0;
	static Set<Integer> set = new HashSet<>();
	
	public static void ans(int len, int num, int idx) {
		if(len == N) {
			set.add(num);
			return;
		}
		else {
			for(int i = idx; i<nums.length;i++) {
				ans(len+1, nums[i]+num, i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans(0, 0, 0);
		System.out.println(set.size());
	
		
	}
}

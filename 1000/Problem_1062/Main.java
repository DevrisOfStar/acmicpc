package Problem_1062;

import java.util.Scanner;

public class Main {
	static int n, m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[] words = new int[n];
		for(int i = 0;  i <n; i++) {
			String word = sc.next();
			for(char x : word.toCharArray()) {
				words[i] |= (1 << (x-'a'));
			}
		}
		
		System.out.println(answer(0, m, 0, words));
		
	}
	
	
	static int count(int mask, int[] words) {
		int cnt = 0;
		for( int word: words) {
			if((word & ((1<<26)-1-mask))==0) cnt+=1;
		}
		return cnt;
	}
	
	static int answer(int idx, int k, int mask, int[] words) {
		if(k < 0) return 0;
		if(idx == 26) return count(mask, words); 
		
		int ans = 0;
		int t1 = answer(idx+1, k-1, mask|(1<<idx), words);
		
		if(ans < t1) ans = t1;
		if(idx != 'a'-'a' && idx !='n'-'a' && idx !='t'-'a' && idx !='i'-'a' && idx !='c' - 'a') {
			t1 = answer(idx+1, k, mask, words);
			if(ans < t1) ans = t1;
		}
		return ans;
		
	}
}

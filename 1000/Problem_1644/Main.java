package Problem_1644;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sq = (int)Math.sqrt(4000000);
		boolean[] arr = new boolean[4000001];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 2; i<= sq; i++) {
			if(arr[i]) continue;
			for(int j = i+i; j <= 4000000;j+=i) arr[j] = true;
		}
		
		for(int i = 2; i<= 4000000;i++) if(!arr[i]) list.add(i);
		int ans = 0;
		int sum = 0;
		int s = 0, e = 0;
		while(true) {			
			if(sum >= N) sum-=list.get(s++);
			else if(e == list.size()) break;
			else sum += list.get(e++);
			if(sum == N) ++ans;
		}
		
		System.out.println(ans);
	}
}

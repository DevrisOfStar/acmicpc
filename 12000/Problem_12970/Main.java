package Problem_12970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int a = 0; a <= N; a++) {
			int b = N-a;
			if(a*b < K) continue;
			int[] cnt = new int[b+1];
			for(int i =0; i<a; i++) {
				int x = Math.min(b, K);
				cnt[x]++;
				K -= x;
			}
			for(int i = b; i>= 0; i--) {
				for(int j = 0; j<cnt[i];j++) {
					System.out.print("A");
				}
				if(i > 0) System.out.print("B");
			}
			System.out.println();
			return;
		}
		
		System.out.println("-1");
		
		 
	}
}

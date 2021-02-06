package Problem_9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp = new int[21][21][21];
	
	static int answer(int a, int b, int c) {
		if( a<=0 || b<=0 || c<=0) return 1;
		if( a>20 || b>20 || c>20) return answer(20,20,20);
		if(dp[a][b][c] > 0) return dp[a][b][c];
		if(a<b && b<c) 
			return dp[a][b][c] = answer(a,b,c-1) + answer(a,b-1,c-1) - answer(a, b-1, c);
		return dp[a][b][c] = answer(a-1, b, c) + answer(a-1, b-1, c) + answer(a-1, b, c-1) - answer(a-1, b-1, c-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		while(!(a==-1 && b==-1 && c==-1)) {	
			System.out.printf("w(%d, %d, %d) = ", a, b, c);
			System.out.println(answer(a,b,c));
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}		
	}
}

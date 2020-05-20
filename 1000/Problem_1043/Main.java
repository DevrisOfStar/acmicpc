package Problem_1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		
		boolean[] isKnown = new boolean[N+1];
		boolean[][] partyPerson = new boolean[M+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		
		for(;st.hasMoreTokens();) {
			isKnown[Integer.parseInt(st.nextToken())] = true;
		}
		
		for(int i = 1; i<=M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			for(;st.hasMoreTokens();) {
				partyPerson[i][Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		for(int i = 1; i<=M;i++) {
			for(int j = 1; j<=M;j++) {
				
				boolean t = false;
				for(int k = 1; k<=N;k++) {
					if(isKnown[k] && partyPerson[j][k]) t = true;
				}
				
				if(t) {
					for(int k = 1; k<=N; k++)
						if(partyPerson[j][k]) isKnown[k] = true;
				}
				
			}
			
		}
		
		int cnt = 0;
		for(int i = 1; i<=M; i++) {
			boolean t = true;
			for(int j = 1; j<=N;j++) {
				if(partyPerson[i][j] && isKnown[j]) {
					t = false;
				}
			}
			if(t) cnt++; 
		}
		
		
		System.out.println(cnt);
	}
}

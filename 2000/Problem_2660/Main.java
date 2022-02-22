package Problem_2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		int[][] c = new int[N+1][N+1];
		int[] minscore = new int[N+1];
		String s;
		StringBuilder sb = new StringBuilder();
		int a,b, cnt = 0, mm = 9999999;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				arr[i][j] = 9999999;
			}
		}
		for(int i = 1; i<=N; i++) arr[i][i] = 0;
		
		while(true) {
			s = br.readLine();
			a = Integer.parseInt(s.split(" ")[0]);
			b = Integer.parseInt(s.split(" ")[1]);
			if(a == -1 && b == -1) break;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				c[i][j] = arr[i][j];
			}
		}
		for(int j = 1; j<=N;j++) {
			for(int i = 1; i<=N; i++) {
				for(int k = 1; k<=N; k++) {
					if(c[i][k] > c[i][j] + c[j][k]) {
						c[i][k] = c[i][j] + c[j][k];
					}
				}
			}
		}
		 
		for(int i = 1; i<=N; i++) {
			int m = 0;
			for(int j = 1; j<=N; j++) {
				m = Math.max(m, c[i][j]);
			}
			minscore[i] = m;
			mm = Math.min(mm,  minscore[i]);
		}
		
		for(int i = 1; i<=N; i++) if(minscore[i] == mm) cnt++;
		
		sb.append(mm).append(" ").append(cnt).append("\n");
		
		for(int i = 1; i<=N ; i++) {
			if(minscore[i] == mm) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}

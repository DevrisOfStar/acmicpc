package Problem_1248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] res;
	static int[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		selected = new int[N];
		res = new char[N][N];
		
		int index = 0;
		for(int i = 0; i <N; i++) {
			for(int j = i; j<N; j++) {
				res[i][j] = str.charAt(index++);
			}
		}
		dfs(0);
	}
	
	public static void dfs(int cnt) {
		if(cnt == N) {
			for(int i = 0 ; i < cnt ; i++)
				System.out.print(selected[i] + " ");
			System.out.println();
			System.exit(0);
		}
		else {
			for(int i = -10; i<=10; i++) {
				selected[cnt] = i;
				if(isvalid(cnt)) dfs(cnt+1);
			}
		}
	}
	
	public static boolean isvalid(int idx) {
		int sum = 0;
		for(int i = idx ; i >=0; i--) {
			sum = sum += selected[i];
			if(res[i][idx] == '+' && sum <= 0) return false;
			if(res[i][idx] == '-' && sum >= 0) return false;
			if(res[i][idx] == '0' && sum != 0) return false;
		}
		return true;
	}
}

package Problem_11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int n;
	static int[][] arr;
	static boolean[] visited;
	public static void dfs(int i) {
		for(int k = 0; k < n; k++) {
			if(arr[i][k] == 1 && !visited[k]) {
				visited[k] = true;
				dfs(k);
			}
				
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String str;
		arr = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			str = br.readLine();
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(visited,false);
			dfs(i);
			for(int j = 0; j< n; j++) {
				if(visited[j]) arr[i][j] = 1;
			}
		}
		
		for(int i = 0 ; i <n; i++) {
			for(int j = 0; j <n; j++) {
				
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

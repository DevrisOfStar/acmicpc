package Problem_17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map = new int[10][10];
	static int min = 100;
	static boolean[][] visited = new boolean[10][10];
	static int[] jongi = new int[]{0,5,5,5,5,5};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int cnt = 0;
		for(int i = 0; i < 10; i++) {
			str = br.readLine();
			for(int j = 0; j < 10; j++) {
				map[i][j] = str.charAt(j*2) - '0';
				if(map[i][j] == 1) cnt++;
				else if(map[i][j] == 0) visited[i][j] = true;
			}
		}
		
		dfs(0, 0, cnt);
		if(min >= 100)  {
			System.out.println(-1);
		}
		else {			
			System.out.println(min);
		}
	}
	
	
	public static void dfs(int row, int cnt, int remain) {
		if(remain == 0) {
			if(cnt < min) min = cnt;
			return;
		}
		else {
			int i = 0; int j = 0;
			for(i = row ; i < 10; i++) {
				for(j = 0 ; j < 10; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						break;
					}
				}
				if(j!=10 && !visited[i][j] && map[i][j] == 1) {
					break;
				}
			}
			
			for(int k = 1; k<=5; k++) {
				if(!isValid(i,j,k)) break;
				else if(jongi[k] > 0) {
					cover(i,j,k);
					jongi[k]--;
					dfs(i, cnt+1,remain-k*k);
					decover(i,j,k);
					jongi[k]++;
				}
				
			}
		}
	}
	
	public static boolean isValid(int i, int j, int size) {
		if(i+size > 10 || j+size > 10) return false;
		for(int k = i; k < i+size;k++) {
			for(int l = j; l < j+size; l++) {
				if(visited[k][l]) return false;
			}
		}
		return true;
	}
	public static void cover(int i, int j, int size) {
		for(int k = i; k < i+size;k++) {
			for(int l = j; l < j+size; l++) {
				map[k][l] = 0;
				visited[k][l] = true;
			}
		}
	}
	
	public static void decover(int i, int j, int size) {
		for(int k = i; k < i+size;k++) {
			for(int l = j; l < j+size; l++) {
				map[k][l] = 1;
				visited[k][l] = false;
			}
		}
	}
	public static void print() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.printf("%d\t",map[i][j]);
			}
			System.out.println();
		}
	}
}

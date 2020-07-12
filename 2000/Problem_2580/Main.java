package Problem_2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[][] arr;
	static ArrayList<int[]> blinks = new ArrayList<>();
	static boolean isvalid(int cnt, int num) {
		
		int a = blinks.get(cnt)[0];
		int b = blinks.get(cnt)[1];
		
		for(int j = 0; j<9;j++) { // 가로 체크
			if(arr[a][j] == num) return false;
		}
		for(int i = 0; i<9;i++) { // 세로 체크
			if(arr[i][b] == num) return false;
		}
		for(int i = (a/3)*3; i<(a/3)*3+3;i++) { // ㅁ 체크
			for(int j = (b/3)*3; j<(b/3)*3+3;j++) {
				if(arr[i][j] == num) return false;
			}
		}
				
		return true;
	}
	static void dfs(int cnt) {
		if(cnt == blinks.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<9;i++) {
				for(int j = 0; j<9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			
			System.exit(0);
		}
		
		for(int i = 1; i<=9; i++) {
			
			if(isvalid(cnt, i)) { // 유효하면, 체킹하고 다음단계로 넘어감
				int a = blinks.get(cnt)[0];
				int b = blinks.get(cnt)[1];
				arr[a][b] = i;
				dfs(cnt+1);
				arr[a][b] = 0;
				
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		for(int i = 0; i<9;i++) {
			String str = br.readLine();
			for(int j = 0; j<9; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
				if(arr[i][j] == 0) {
					blinks.add(new int[] {i,j});
				}
			}
			
		}
		
		dfs(0);
		
	}
}

package Problem_14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] wheels = new int[4][8];
	static int score = 0;
	static boolean[] visited = new boolean[4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		for(int i = 0; i < 4 ; i++)  {
			str = br.readLine();
			
			for(int j = 0; j < str.length(); j++) {
				wheels[i][j] = str.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < k ; i ++) {
			str = br.readLine();
			solution(Integer.parseInt(str.split(" ")[0])-1, Integer.parseInt(str.split(" ")[1]));
			Arrays.fill(visited, false);
		}
		
		for(int i = 0 ; i < 4; i++) {
			score += wheels[i][0] * Math.pow(2, i);
		}
		
		System.out.println(score);
	}
	
	public static void solution(int number, int dir) {
		int num = number;
		visited[num] = true;
		int prev_num = num-1; int next_num = num+1;
		if(prev_num >= 0 && !visited[prev_num]) {
			if(wheels[num][6] != wheels[prev_num][2]) {
				solution(prev_num, dir * -1);
			}
		}
		
		if(next_num < 4 && !visited[next_num]) {
			if(wheels[next_num][6] != wheels[num][2]) {
				solution(next_num, dir * -1);
			}
		}
		
		
		rotate(num, dir);
	}
	
	public static void rotate(int num, int dir) {
		int temp;
		if(dir == -1) {
			temp = wheels[num][0];
			for(int i = 0 ; i < 7; i++) {
				wheels[num][i] = wheels[num][i+1];
			}
			wheels[num][7] = temp;
		}
		else if(dir == 1) {
			temp = wheels[num][7];
			for(int i = 7; i > 0; i--) {
				wheels[num][i] = wheels[num][i-1];
			}
			wheels[num][0] = temp;
		}
	}
}

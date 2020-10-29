package Problem_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[41][2];
		arr[0][0] = 1;
		arr[1][1] = 1;
		
		for(int i = 2; i<=40;i++) {
			arr[i][0] = arr[i-1][0] + arr[i-2][0];
			arr[i][1] = arr[i-1][1] + arr[i-2][1];
		}
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=T; t++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(arr[a][0] + " " + arr[a][1]).append("\n");
		}
		
		System.out.println(sb.toString());
	} 
}

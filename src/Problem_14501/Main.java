package Problem_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][2];
		int[] answer = new int[n+2];
		String str;
		for(int i = 1; i<=n;i++) {
			str = br.readLine();
			arr[i][0] = Integer.parseInt(str.split(" ")[0]);
			arr[i][1] = Integer.parseInt(str.split(" ")[1]);
		}
		int result = Integer.MIN_VALUE;
		// brute force.
		
		int complete;
		for(int i = n; i>0; i-- ) {
			complete = i + arr[i][0];
			
			if(complete > n+1) {
				answer[i] = answer[i+1];
			}  else {
				answer[i] = answer[i+1] > answer[complete] + arr[i][1] ? answer[i+1] : answer[complete]+arr[i][1];
			}
			
		}
		//brute force end.
		
		// dp.
//		for(int i = 1; i<=n; i++) {
//			if(i+arr[i][0] <=n+1) {
//				answer[i+arr[i][0]] = Math.max(answer[i+arr[i][0]], answer[i]+arr[i][1]);
//			}
//			
//			answer[i+1] = Math.max(answer[i+1], answer[i]);
//			
//			result = Math.max(result, answer[i+1]);
//		}
		
		System.out.println(answer[1]); //brute force answer
		// System.out.println(result); // dp answer
		
		
	}
}

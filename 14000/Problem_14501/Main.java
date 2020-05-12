package Problem_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][2];
		int[] answer = new int[n + 2];
		String str;
		for (int i = 1; i <= n; i++) {
			str = br.readLine();
			arr[i][0] = Integer.parseInt(str.split(" ")[0]);
			arr[i][1] = Integer.parseInt(str.split(" ")[1]);
		}
		int result = Integer.MIN_VALUE;

		// brute force.
		int complete;
		for (int i = n; i > 0; i--) {
			complete = i + arr[i][0]; // 완수시간 계산

			if (complete > n + 1) { // 완수시간이 n일을 넘어서면,
				answer[i] = answer[i + 1]; // answer[i+1]의 값을 그대로 갖음
			} else {
				answer[i] = answer[i + 1] > answer[complete] + arr[i][1] ? // 이전일까지 상담한 금액과 이전일 + 완수했을 때의 금액의 합의 최대값을 갖음
						answer[i + 1] : answer[complete] + arr[i][1];
			}

		} // brute force end.
		System.out.println(answer[1]); // brute force answer
		
		Arrays.fill(answer, 0); // init.
		
		// dp.
		for(int i = 1; i<=n; i++) {
			complete = i+arr[i][0];
			if(complete <=n+1) { // 완수기간이 n일을 넘어서지 않으면
				answer[i+arr[i][0]] = Math.max(answer[i+arr[i][0]], answer[i]+arr[i][1]); // answer[완수기간 후의 날]의 값을 두 금액의 최대값으로 변경
			}
			answer[i+1] = Math.max(answer[i+1], answer[i]); // 이전일과 오늘 중 최대값을 오늘의 금액으로 설정
			result = Math.max(result, answer[i+1]); // 결과는 계속 업데이트 or answer[n+1]에 존재
		}
		System.out.println(result); // dp answer

	}
}

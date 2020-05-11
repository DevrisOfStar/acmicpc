package Problem_15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N,M;
	public static int[] arr;
	public static StringBuilder sb;
	public static void ans(int cnt) {
		if(cnt == M) { // M개가 채워지면, 출력
			for(int i = 0 ; i < M ; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		else {
			for(int i = 1; i <= N;i++) {
				arr[cnt] = i; // 중복가능하므로 arr에 존재여부 판단 필요X
				ans(cnt+1); // 순서가 상관없으므로, 개수만 파라미터로 전달
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);
		arr = new int[M];
		sb = new StringBuilder();
		ans(0);
		System.out.print(sb.toString());
	}
}

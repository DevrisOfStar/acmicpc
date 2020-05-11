package Problem_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N,M;
	public static int[] arr;
	public static StringBuilder sb;
	public static void ans(int cnt) {
		if(cnt == M) { // M개가 채워지면 
			for(int i = 0 ; i < M ; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		else if(cnt >= 1){ // 첫번째 숫자가 정해진 시점에서 비내림차순으로 선택해야 하기때문에, 이전 숫자부터 반복문 실행
			for(int i = arr[cnt-1]; i <= N;i++) {
				arr[cnt] = i;
				ans(cnt+1);
			}
		}
		else { // 첫번째 숫자가 정해지지 않은 시점에서, 첫번째 숫자를 지정
			for(int i = 1; i <= N;i++) {
				arr[cnt] = i;
				ans(cnt+1);
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

package Problem_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int N;
	static int[] answer = new int[6];
	static StringBuffer sb = new StringBuffer();
	public static void print() {
		for(int i = 0; i<6;i++)
			sb.append(answer[i]).append(" ");
		System.out.println(sb.toString().trim());
		sb.setLength(0);
	}
	public static void ans(int idx, int cnt) {
		if(cnt == 6) {
			print();
			return;
		}
		if(idx >= N) return;
		answer[cnt] = arr[idx];
		ans(idx+1, cnt+1);
		answer[cnt] = 0;
		ans(idx+1, cnt);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer;
		
		while(!(buffer=br.readLine()).equals("0")) {
			String[] temp = buffer.split(" ");
			N = Integer.parseInt(temp[0]);
			arr = new int[N];
			
			for(int i = 1; i<=N; i++) {
				arr[i-1] = Integer.parseInt(temp[i]);
			}
			ans(0,0);
			
			System.out.println();
		}
		
	}
}

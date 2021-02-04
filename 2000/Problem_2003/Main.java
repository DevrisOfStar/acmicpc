package Problem_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int i = 0;
		int j = 0;
		int sum = 0;
		int cnt = 0;
		for(;;) {
			if(sum >= M) sum -= arr[i++];
			else if(j == N) break;
			else sum += arr[j++];
			if(sum == M) cnt++;
		}
		System.out.println(cnt);
		
		
	}
}

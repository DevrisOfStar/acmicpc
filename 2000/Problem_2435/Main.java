package Problem_2435;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		int N = Integer.parseInt(buf.split(" ")[0]);
		int K = Integer.parseInt(buf.split(" ")[1]);
		int[] arr = new int[N];
		buf = br.readLine();
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(buf.split(" ")[i]);
		for(int i = 0; i<=N-K; i++) {
			int sum = 0;
			for(int j = i; j<i+K;j++) { sum += arr[j]; }
			if(sum > max) max = sum;
		}
		System.out.println(max);
	}
}

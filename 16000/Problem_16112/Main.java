package Problem_16112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		int n = Integer.parseInt(buffer.split(" ")[0]);
		int k = Integer.parseInt(buffer.split(" ")[1]);
		
		long[] arr = new long[n];
		buffer = br.readLine();
		StringTokenizer st = new StringTokenizer(buffer);
		for(int i = 0; i <n;i++) arr[i] = Long.parseLong(st.nextToken());
		Arrays.sort(arr);
		int a = 0;
		long answer = 0;
		for(int i = 0; i<n; i++) {
			answer += (a*arr[i]);
			a = a < k ? a+1 : a;
		}
		
		System.out.println(answer);
	}
}

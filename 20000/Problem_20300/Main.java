package Problem_20300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer buf =  new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) arr[i] = Long.parseLong(buf.nextToken());
		
		Arrays.sort(arr);
		
		long max = arr[N-1];
		long num = 0;
		
		if(N%2 == 0) {
			for(int i = 0; i<N; i++) {
				num = arr[i] + arr[N-1-i];
				if(max < num) max = num;
			}
		}
		else {
			for(int i = 0; i<(N-1); i++) {
				num = arr[i] + arr[N-2-i];
				if(max < num) max = num;
			}
		}
		
		System.out.println(max);
	}
}

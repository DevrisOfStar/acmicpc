package Problem_16435;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		int N = Integer.parseInt(buf.split(" ")[0]);
		int L = Integer.parseInt(buf.split(" ")[1]);
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		for(int i = 0; i<N; i++) {
			if(arr[i] >L) break;
				L++;
		}
		
		System.out.println(L);
		
		
		
	}
}

package Problem_1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] arr;
	static long[] brr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		brr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i <N; i++) {
			arr[i]= Long.parseLong(st.nextToken());
		}
		
		long answer = answer(0, N-1);
		System.out.println(answer);
	}
	
	public static long answer(int start, int end) {
		if(start == end) return 0l;
		int mid = (start + end) / 2;
		long ans = answer(start, mid) + answer(mid+1, end);
		int i = start;
		int j = mid+1;
		int k = 0;
		
		while(i<= mid || j <= end) {
			if(i <= mid && (j > end || arr[i] <= arr[j])) {
				brr[k++] = arr[i++];
			} else {
				ans += (long)(mid-i+1);
				brr[k++] = arr[j++];
			}
		}
		
		for(i = start; i<=end; i++) arr[i] = brr[i-start];
		
		return ans;
	}
}

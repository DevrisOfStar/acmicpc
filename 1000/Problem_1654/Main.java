package Problem_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		long K = Long.parseLong(str.split(" ")[1]);
		long[] arr = new long[N];
		long low = 1;
		long high = Integer.MIN_VALUE;
		long result = 0;
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			arr[i] = Long.parseLong(str);
			high = arr[i] < high ? high : arr[i];
		}
		
		while (low <= high) {
			long mid = (low + high) / 2;
			long cnt = 0;
			for(int i = 0; i<N;i++) cnt+=(arr[i]/mid);
			
			if(cnt >= K) {
				if(mid > result)
					result = mid;
				low = mid +1;
			}
			else{
				high = mid-1;
			}
			
		}
		System.out.println(result);
	}
}

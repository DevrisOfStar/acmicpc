package Problem_3541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		long[][] arr = new long[M][2];
		for(int i = 0; i<M;i++) {
			str = br.readLine();
			arr[i][0] = Integer.parseInt(str.split(" ")[0]);
			arr[i][1] = Integer.parseInt(str.split(" ")[1]);	
		}
		long min = Long.MAX_VALUE;
		for(int j = 0; j<M; j++) {
			int l = -1, r = N+1;
			while (l+1 < r) {
				int mid = (l + r)/2;
				long cnt = mid*arr[j][0] - (N-mid)*arr[j][1];
				if(cnt > 0)  {
					r = mid;
					if(min > cnt) min = cnt;
				}
				else {
					l = mid;
				}
			}
		}
		
		System.out.println(min);
	}
}

package Problem_15487;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] ldp = new int[N];
		int idx = 0;		
		ldp[0] = (int) -1e9;
		int rdp = ldp[0];
		int ans = ldp[0];
		int var_t = Integer.MAX_VALUE;
		
		String Buffer = br.readLine();
		for(String s : Buffer.split(" ")) {
			arr[idx] = Integer.parseInt(s);
			if(idx > 0) {
				ldp[idx] = Math.max(ldp[idx-1], arr[idx]-var_t);
			}
			if(var_t > arr[idx]) var_t = arr[idx];
			idx++;
		}
		
		var_t = arr[N-1];
		
		for(int i = N-2; i>1; i--) {
			rdp = Math.max(rdp, var_t-arr[i]);
			ans = Math.max(ans, rdp + ldp[i-1]);
			var_t = Math.max(var_t, arr[i]);
		}
		
		System.out.println(ans);
	}
}

package Problem_17296;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		boolean[] dp = new boolean[N];
		int ans = 0;
		
		for(int i = 0; st.hasMoreTokens();i++) {
			String str = st.nextToken();
			if(str.contains(".")) {
				dp[i] = true;
				str = str.substring(0,str.indexOf("."));
			}
			arr[i] = Integer.parseInt(str);
		}
		
		ans = arr[0];
		if(dp[0]) ans++;

		for(int i = 1; i<N; i++) {
			if(dp[i] && ans == 0) ans++;
			ans += arr[i];
		}

		System.out.println(ans);	
	}
}

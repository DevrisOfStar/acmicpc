package Problem_20310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		boolean[] isused = new boolean[str.length()];
		int[] cnt = new int[2];
		for(int i = 0; i<str.length(); i++) {
			cnt[str.charAt(i) - '0']++;
		}
		cnt[0]/=2; cnt[1]/=2;
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == '1') continue;
			if(cnt[0] == 0) break;
			isused[i] = true;
			cnt[0]--;
		}
		
		for(int i = str.length()-1; i>=0; i--) {
			if(str.charAt(i) == '0') continue;
			if(cnt[1] == 0) break;
			isused[i] = true;
			cnt[1]--;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<isused.length; i++) {
			if(isused[i]) sb.append(str.charAt(i));
		}
		System.out.println(sb.toString());
	}
}

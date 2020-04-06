package Problem_2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=T;t++) {
			String str = br.readLine();
			int N = Integer.parseInt(str.split(" ")[0]);
			str = str.split(" ")[1];
			for(int i = 0; i < str.length(); i++) {
				for(int j = 0; j<N;j++) {
					sb.append(str.charAt(i));
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}

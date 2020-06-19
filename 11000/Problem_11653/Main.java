package Problem_11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i<= N; i++) {
			if(N % i == 0) {
				sb.append(i).append("\n");
				N/=i;
				i--;
			}
		}
		System.out.println(sb.toString());
	}
}

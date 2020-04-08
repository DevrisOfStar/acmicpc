package Problem_2455;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a, b;
		int in_train = 0;
		int max = 0;
		for(int i = 0 ; i < 4; i++) { // 역은 4개
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			in_train += b;
			in_train -= a;
			// 정원은 10000명이나 초과하여 타는 경우는 없으므로, max 계산을 간단하게 할 수 있다.
			if(max < in_train) max = in_train;
		}
		
		System.out.println(max);
	}
}

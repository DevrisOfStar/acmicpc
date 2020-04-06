package Problem_1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		double aver = 0;
		double max = Integer.MIN_VALUE;
		for(int i = 0 ; i<N;i++) {
			int a = Integer.parseInt(str.split(" ")[i]);
			if(a > max) max = a;
			aver += a;
		}
		
		aver = aver / max * 100.0 / ((double)N);
		System.out.println(aver);
		
	}
}

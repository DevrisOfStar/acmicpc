package Problem_17828;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean flag = true;
		if(X / N > 26) flag = false;		
		if(X / N == 26 && X % 26 != 0) flag = false;
		if(N > X)  flag = false;
		if(!flag) {
			bw.write("!");
		}
		else {
			X-= N;
			for(int i = 0; i<N; i++) {
				if(X >= 25) {
					X -= 25;
					sb.append("Z");
				}
				else if(X >= 0 && X< 25) {
					char c = (char)('A' + X);
					sb.append(c);
					X = 0;
				}
			}			
			bw.write(sb.reverse().toString());
		}	
		bw.flush();
		bw.close();
	}
}

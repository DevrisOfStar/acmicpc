package Problem_1783;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		int N = Integer.parseInt(bf.split(" ")[0]);
		int M = Integer.parseInt(bf.split(" ")[1]);
		int num = 1;
		if(N == 1) System.out.println(num);
		else if(N == 2) System.out.println(Math.min((int)((M+1)/2), 4));
		else if(N >= 3) {
			if(M <= 6) System.out.println(Math.min(M, 4));
			else System.out.println(M-2);
		}
		
	}
}

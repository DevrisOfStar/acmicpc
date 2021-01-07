package Problem_1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long a,b,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		a = Long.parseLong(buf.split(" ")[0]);
		b = Long.parseLong(buf.split(" ")[1]);
		c = Long.parseLong(buf.split(" ")[2]);
		System.out.println(solve(b));
	}
	
	static long solve(long n) {
		if(n == 1) return a%c;
		long temp = solve(n/2) % c;
		if(n%2 == 0) {
			temp = (temp*temp)%c;
			return temp;
		} else {
			temp = (((temp*temp)%c)*a)%c;
			return temp;
		}
	}
}

package Problem_2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(sb.append(str.split(" ")[0]).reverse().toString());
		sb.setLength(0);
		int b = Integer.parseInt(sb.append(str.split(" ")[1]).reverse().toString());
		
		if(a >b) {
			System.out.println(a);
		}
		else {
			System.out.println(b);
		}
	}
}

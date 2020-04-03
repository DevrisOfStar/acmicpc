package Problem_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int a = Integer.parseInt(str.split(" ")[0]);
		int b = Integer.parseInt(str.split(" ")[1]);
		int v = Integer.parseInt(str.split(" ")[2]);
		int cnt = (v-b-1) / (a-b)+1;
		
		System.out.println(cnt);
		
	}
}

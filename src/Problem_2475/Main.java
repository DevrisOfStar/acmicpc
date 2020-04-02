package Problem_2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int a = 0;
		for(int i = 0; i<str.length;i++)
		{
			int b = Integer.parseInt(str[i]);
			a += (b*b);
		}
		
		System.out.println(a%10);
	}
}

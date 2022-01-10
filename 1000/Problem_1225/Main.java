package Problem_1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String a = str.split(" ")[0];
		String b = str.split(" ")[1];
		int[] arr_a = new int[10];
		int[] arr_b = new int[10];
		for(int i = 0; i<a.length(); i++) arr_a[a.charAt(i)-'0']++;
		for(int i = 0; i<b.length(); i++) arr_b[b.charAt(i)-'0']++;
		long answer = 0;
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				answer += (i*j)*(arr_a[i]*arr_b[j]);
			}
		}
		System.out.println(answer);
	}
}

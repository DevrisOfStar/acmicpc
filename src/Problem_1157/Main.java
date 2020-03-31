package Problem_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		for(int i = 0; i<str.length();i++) {
			arr[str.charAt(i)-'A']++;
		}
		int max = -1;
		int m_idx = 0;
		boolean flag = false;
		for(int i = 0; i<arr.length;i++) {
			if(arr[m_idx] < arr[i]) {
				m_idx = i;
				max = arr[i];
			}
		}
		
		for(int i = 0; i<arr.length;i++) {
			if(arr[m_idx] == arr[i] && m_idx!=i) flag = true;
		}
		if(flag) System.out.println("?");
		else System.out.println( (char)('A'+ m_idx));
		
	}
}

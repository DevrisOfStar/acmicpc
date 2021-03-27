package Problem_1235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[Integer.parseInt(br.readLine())];
		for(int i = 0; i<arr.length; i++) arr[i] = br.readLine();
		int a = arr[0].length();
		for(int i = 1; i<=a;i++) {
			Set<String> s = new HashSet<>();
			for(int j = 0; j<arr.length;j++) 
				s.add(arr[j].substring(a-i,a));
			if(s.size() == arr.length) {
				System.out.println(i);
				return;
			}
		}
	}
}

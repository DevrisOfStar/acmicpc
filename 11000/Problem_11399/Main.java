package Problem_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String str = br.readLine();
		int sum = 0;
		int idx = 0;
		for(String s : str.split(" ")) {
			arr[idx++] = Integer.parseInt(s);
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			sum += (arr[i] * (N-i));
		}
		System.out.println(sum);
	}
}

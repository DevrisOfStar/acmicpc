package Problem_3003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] answer = { 1, 1, 2, 2, 2, 8 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[6];
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++)
			arr[i] = Integer.parseInt(str.split(" ")[i]);
		

		for (int i = 0; i < 6; i++) {
			sb.append(answer[i] - arr[i]).append(" ");
		}

		System.out.println(sb.toString().trim());

	}
}

package Problem_2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m_idx = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			if (max < n) {
				max = n;
				m_idx = i;
			}
		}

		System.out.println(max);
		System.out.println(m_idx);
	}
}

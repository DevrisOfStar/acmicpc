package Problem_1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] answer = new int[N];

		StringTokenizer bf = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(bf.nextToken());

		for (int i = 0; i < N; i++) {
			int num = i + 1;
			int j, cnt = 0;
			for (j = 0; j < N; j++) {
				if (cnt == arr[i])
					if (answer[j] == 0)
						break;

				if (answer[j] == 0 || num < answer[j]) {
					cnt++;
				}
			}

			answer[j] = num;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(answer[i]).append(" ");
		System.out.println(sb.toString().trim());

	}
}

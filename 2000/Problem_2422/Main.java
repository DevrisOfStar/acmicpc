package Problem_2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] z = new boolean[201][201];
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		int a = 0;
		int b = 0;
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			a = Integer.parseInt(str.split(" ")[0]);
			b = Integer.parseInt(str.split(" ")[1]);
			z[a][b] = true;
			z[b][a] = true;
		}

		for (int i = 1; i <= N - 2; i++) {
			for (int j = i + 1; j <= N - 1; j++) {
				for (int k = j + 1; k <= N; k++) {
					if (z[i][j] || z[j][k] || z[i][k])
						continue;
					else
						cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}

package Problem_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] arr = new int[101][101];
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		int a, b;
		int min = Integer.MAX_VALUE;
		int idx = 1;
		n = Integer.parseInt(bf.split(" ")[0]);
		m = Integer.parseInt(bf.split(" ")[1]);

		for (int i = 0; i < m; i++) {
			bf = br.readLine();
			a = Integer.parseInt(bf.split(" ")[0]);
			b = Integer.parseInt(bf.split(" ")[1]);
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					else if (arr[i][k] != 0 && arr[k][j] != 0) {

						if (arr[i][j] == 0)
							arr[i][j] = arr[i][k] + arr[k][j];
						else
							arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}

				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int result = 0;
			for (int j = 1; j <= n; j++) {
				result += arr[i][j];
			}
			if (result < min) {
				min = result;
				idx = i;
			}
		}

		System.out.println(idx);

	}
}

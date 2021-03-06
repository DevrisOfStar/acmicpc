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
					else if (arr[i][k] != 0 && arr[k][j] != 0) { // k와 아는사이인 경우

						if (arr[i][j] == 0) // i와 j의 관계수가 정의되지 않은 경우
							arr[i][j] = arr[i][k] + arr[k][j];  // i와 k의 관계수 + k와 j의 관계수의 합
						else // 관계수가 정의된 경우
							arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]); // 최소값을 i와 j의 관계수로 결정
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

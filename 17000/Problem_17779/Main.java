package Problem_17779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] data;
	static int[][] pos = new int[4][2];
	static int min_value = Integer.MAX_VALUE;

	public static void answer() {
		// 가장많은 선거구 - 가장 적은 선거구 최솟값

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (CanMakeLine(x, y, d1, d2)) {
							int a = x - 1;
							int b = y - 1;
							pos[0][0] = a;
							pos[0][1] = b;
							pos[1][0] = a + d1;
							pos[1][1] = b - d1;
							pos[2][0] = a + d2;
							pos[2][1] = b + d2;
							pos[3][0] = a + d1 + d2;
							pos[3][1] = b - d1 + d2;
							calc(x, y, d1, d2);
						}

					}
				}
			}
		}
	}

	public static boolean CanMakeLine(int x, int y, int d1, int d2) {
		int a = x - 1;
		int b = y - 1;
		if (a + d1 >= N || b - d1 < 0)
			return false;
		if (a + d2 >= N || b + d2 >= N)
			return false;
		if (a + d1 + d2 >= N || b - d1 + d2 >= N)
			return false;
		if (a + d1 + d2 >= N || b + d2 - d1 < 0)
			return false;
		return true;
	}

	public static void calc(int x, int y, int d1, int d2) {

		int[] group = new int[6];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				data[i][j] = 5;
			}
		}
		int SubArea = 0;
		for (int i = 0; i < pos[1][0]; i++) {
			if (i >= pos[0][0])
				SubArea++;
			for (int j = 0; j <= pos[0][1] - SubArea; j++) {
				data[i][j] = 1;
			}
		}
		int PlusArea = 0;
		for (int i = 0; i <= pos[2][0]; i++) {
			if (i > pos[0][0])
				PlusArea++;
			for (int j = pos[0][1] + 1 + PlusArea; j < N; j++) {
				data[i][j] = 2;
			}
		}

		SubArea = 0;
		for (int i = N - 1; i >= pos[1][0]; i--) {
			if (i < pos[3][0])
				SubArea++;
			for (int j = 0; j < pos[3][1] - SubArea; j++) {
				data[i][j] = 3;
			}
		}

		PlusArea = 0;
		for (int i = N - 1; i > pos[2][0]; i--) {
			if (i <= pos[3][0])
				PlusArea++;
			for (int j = pos[3][1] + PlusArea; j < N; j++) {
				data[i][j] = 4;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				group[data[i][j]] = group[data[i][j]] + arr[i][j];
			}
		}

		int maxIndex = 0;
		int minIndex = 1;
		for (int i = 1; i <= 5; i++) {
			if (group[maxIndex] < group[i]) {
				maxIndex = i;
			}
			if (group[minIndex] > group[i]) {
				minIndex = i;
			}
		}
		int value = group[maxIndex] - group[minIndex];
		min_value = min_value > value ? value : min_value;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		data = new int[N][N];
		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		answer();
		System.out.println(min_value);
	}
}

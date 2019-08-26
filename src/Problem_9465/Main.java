package Problem_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N;
		int[][] arr;
		int[][] score;
		int max;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			score = new int[N][3];

			String[] a = br.readLine().split(" ");
			String[] b = br.readLine().split(" ");

			for (int i = 0; i < N; i++) {
				arr[i][0] = Integer.parseInt(a[i]);
				arr[i][1] = Integer.parseInt(b[i]);
			}
			
			score[0][0] = arr[0][0];
			score[0][1] = arr[0][1];

			for (int i = 1; i < N; i++) {
				score[i][0] = Math.max(score[i-1][1] + arr[i][0], score[i-1][2] + arr[i][0]);
				score[i][1] = Math.max(score[i-1][0] + arr[i][1], score[i-1][2] + arr[i][1]);
				score[i][2] = Math.max(Math.max(score[i-1][2], score[i-1][1]), score[i-1][0]);
			}
			
			max = score[N-1][0] > score[N-1][1] ? score[N-1][0] : (score[N-1][1] > score[N-1][2] ? score[N-1][1] : score[N-1][2]);
			System.out.println(max);
		}
	}
}

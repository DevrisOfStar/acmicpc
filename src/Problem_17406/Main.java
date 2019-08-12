package Problem_17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] arr;
	static int[][] map;
	static int N;
	static int M;
	static int K;
	static int[][] rotate;
	static int answer = Integer.MAX_VALUE;
	static boolean[] isvisited;
	
	public static void getAnswer() {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += arr[i][j];
			}
			answer = answer > sum ? sum : answer;
		}
	}


	public static void solution(int num) {
		int[][] temp = arr;
		if(num == K) {
			getAnswer();
			return;
		}
		else {
			isvisited[num] = true;
			rotate(rotate[num][0], rotate[num][1], rotate[num][2]);
			solution(num+1);
			isvisited[num] = false;
			arr = temp;
		}
	}

	public static void init() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = map[i][j];
			}
		}
	}

	public static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		K = Integer.parseInt(temp[2]);

		arr = new int[N + 1][M + 1];
		map = new int[N + 1][M + 1];
		rotate = new int[K][3];
		isvisited = new boolean[K];

		for (int i = 1; i <= N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(temp[j - 1]);
				map[i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < K; i++) {
			temp = br.readLine().split(" ");
			rotate[i][0] = Integer.parseInt(temp[0]);
			rotate[i][1] = Integer.parseInt(temp[1]);
			rotate[i][2] = Integer.parseInt(temp[2]);
		}

		solution(0);
		System.out.println(answer);
	}

	public static void rotate(int r, int c, int s) {
		for (int k = 1; k <= s; k++) {
			int temp = arr[r - k][c - k];
			for (int i = r - k; i < r + k; i++)
				arr[i][c - k] = arr[i + 1][c - k];
			for (int j = c - k; j < c + k; j++)
				arr[r + k][j] = arr[r + k][j + 1];
			for (int i = r + k; i > r - k; i--)
				arr[i][c + k] = arr[i - 1][c + k];
			for (int j = c + k; j > c - k; j--)
				arr[r - k][j] = arr[r - k][j - 1];
			arr[r - k][c - k + 1] = temp;
		}
	}
}

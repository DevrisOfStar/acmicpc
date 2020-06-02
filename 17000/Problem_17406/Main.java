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
		int[][] temp = new int[N+1][M+1];
		for(int i = 1; i<=N;i++) {
			for(int j = 1; j<=M;j++) {
				temp[i][j] = arr[i][j];
			}
		}
		if(num == K) {
			getAnswer();
			return;
		}
		else {
			for(int i = 0; i <K ; i++) {
				if(!isvisited[i]) {					
					rotate(rotate[i][0], rotate[i][1], rotate[i][2]);
					
					isvisited[i] = true;
					solution(num+1);
					isvisited[i] = false;
					for(int k = 1; k<=N;k++) {
						for(int j = 1; j<=M;j++) {
							arr[k][j] = temp[k][j];
						}
					}			
					
				}
				
			}
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
			int temp = arr[r - k][c - k]; // 왼쪽 상단의 값 temp에 저장
			for (int i = r - k; i < r + k; i++) // 왼쪽 상단 --> 왼쪽 하단
				arr[i][c - k] = arr[i + 1][c - k];
			for (int j = c - k; j < c + k; j++) // 왼쪽 하단 --> 오른쪽 하단
				arr[r + k][j] = arr[r + k][j + 1];
			for (int i = r + k; i > r - k; i--) // 오른쪽 하단 --> 오른쪽 상단
				arr[i][c + k] = arr[i - 1][c + k];
			for (int j = c + k; j > c - k; j--) // 오른쪽 상단 --> 왼쪽 상단
				arr[r - k][j] = arr[r - k][j - 1];
			arr[r - k][c - k + 1] = temp;
		}
	}
}

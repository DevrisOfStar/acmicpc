package Problem_16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solution() {
		// 봄 : 나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가한다.
		// 만약 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 죽는다.
		// 여름 : 봄에 죽은 나무가 양분으로 변한다. 죽은 나무의 나이 / 2 == 양분으로 추가 (소수점아래는 버린다)
		// 가을 : 나무 번식 (번식하는 나무의 나이는 5의 배수, 인접한 8개의 칸에 나이가 1인 나무가 생김)
		// 겨울 : 양분 추가, 추가되는 양분의 양은 A[r][c]
		
		// 살아남은 나무의 수를 출력
	}
	
	static int N;
	static int M;
	static int K;
	
	public static void main(String[] args) throws IOException {
		// 첫째 줄 : N, M, K (N : 땅의 크기 N*N, M : 나무 구매 개수, K : 겪을 해수)
		// 둘째 줄 : N개의 줄에 A배열의 값이 주어짐 (r번째줄, c번째 값 : A[r][c])
		// M개의 줄 : 심은 나무의 정보 (x,y,z) : x,y - 위치, z - 나이
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		int N = Integer.parseInt(temp.split(" ")[0]);
		int M = Integer.parseInt(temp.split(" ")[1]);
		int K = Integer.parseInt(temp.split(" ")[2]);
		
	}
}

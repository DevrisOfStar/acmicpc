package Problem_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,M;
	static int[] arr;
	static boolean[] arr_;
	public static void ans(int a, int cnt) {
		if(cnt == M) { // M개를 채웠으면, 출력
			for(int i = 0; i < N; i++)
				if(arr_[i])System.out.print(arr[i] + " ");
			System.out.println();
		}
		else {
			for(int i = a; i<N; i++) {
				if(!arr_[i]) { // arr의 존재여부 확인
					arr_[i] = true;
					ans(i, cnt+1); // 개수를 늘리고 진행, 오름차순으로 구하기 위해서 i를 파라미터로 전달
					arr_[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);
		arr = new int[N];
		for(int i = 0 ; i < arr.length; i++) arr[i] = i+1;
		arr_ = new boolean[N];
		ans(0, 0);
		
	}
}

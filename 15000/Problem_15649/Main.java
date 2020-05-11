package Problem_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static boolean[] arr_;
	static int N,M;
	
	public static void ans(int m) { // m은 채워진 개수
		if(m == M) { // 원하는 길이만큼 구하면, 출력
			for(int i = 0; i<m;i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
		else { 
			for(int i = 1; i<=N; i++) {
				if(!arr_[i]) { // arr에 존재여부 확인
					arr_[i] = true;
					arr[m] = i;
					ans(m+1); // 채워진 개수를  1개 늘리고 진행 
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
		arr = new int[N+1];
		arr_ = new boolean[N+1];
		ans(0);
		
		
	}
}

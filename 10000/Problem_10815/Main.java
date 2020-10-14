package Problem_10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, arr_;
	static int[] answer;
	public static void ans(int idx) {
		int target = arr_[idx];
		int start = 0;
		int end = arr.length -1;
		int mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(arr[mid] == target) {
				answer[idx] = 1; // 찾은 경우, 1로 바꿈.
				
				return;
			}
			else if(arr[mid] > target) { // target보다 크면
				end = mid - 1; // 왼쪽 부분을 범위로 선택
			}
			else { // target보다 작으면
				start = mid + 1; // 오른쪽 부분을 범위로 선택
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		arr = new int[N];
		for(int i = 0; i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		arr_ = new int[M];
		answer = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<M;i++) arr_[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<M;i++) {
			ans(i);
		}
		
		for(int i = 0; i<M;i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb);
		
	}
}

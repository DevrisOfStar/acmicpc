package Problem_1201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// M+K-1 ≤ N ≤ MK 인 경우에만 답을 찾을 수 있다

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		if(M+K-1 <= N && M*K >= N) {
			int[] arr = new int[N];
			for(int i = 0; i< arr.length; i++) arr[i] = i+1;
			
			ArrayList<Integer> gr = new ArrayList<Integer>();
			gr.add(0);
			gr.add(K);
			N -= K;
			M -= 1;
			int gr_size = M == 0 ? 1 : N/M;
			int r = M == 0 ? 0 : N % M;
			
			for(int i = 0; i <M; i++) {
				gr.add(gr.get(gr.size()-1) + gr_size + (r > 0 ? 1 : 0));
				if(r>0) r--;
			}
			
			for(int i =0; i<gr.size()-1; i++) {
				int start = gr.get(i);
				int end = gr.get(i+1)-1;
				
				while(start < end) {
					int temp = arr[start];
					arr[start] = arr[end];
					arr[end]= temp;
					start++;
					end--;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i <arr.length;i++) sb.append(arr[i]).append(" ");
			System.out.println(sb.toString().trim());
		} else System.out.println("-1");
		
	}
}

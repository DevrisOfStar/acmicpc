package Problem_1276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> arr = new ArrayList<>();
		int answer = 0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()); 
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			arr.add(new int[] {h,x1,x2});
		}
		
		Collections.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		for(int i = 0; i<N;i++) {
			answer += (2*arr.get(i)[0]);
			int x1 = arr.get(i)[1];
			int x2 = arr.get(i)[2] - 1;
			for(int j = i+1; j<N;j++) {
				if(x1 >= arr.get(j)[1] && x1 < arr.get(j)[2]) {
					answer -= arr.get(j)[0];
					break;
				}
			}
			for(int j = i+1; j<N;j++) {
				if(x2 >= arr.get(j)[1] && x2 < arr.get(j)[2]) {
					answer -= arr.get(j)[0];
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
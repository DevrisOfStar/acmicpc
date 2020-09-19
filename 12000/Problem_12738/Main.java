package Problem_12738;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		List<Integer> store = new ArrayList<>();
		store.add(Integer.MIN_VALUE);
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		int num, left, right;
		for(int i = 1; i<=N; i++) {
			num = arr[i];
			
			if(num > store.get(store.size()-1)) store.add(num);
			else {
				left = 1;
				right = store.size()-1;
				while(left < right) {
					int mid = (left+right)/2;
					if(store.get(mid) >= num) right = mid;
					else left = mid + 1;
				}
				store.set(right, num);
			}
			//System.out.println(Arrays.toString(store.toArray()));
		}
		System.out.println(store.size()-1);
		
	}
}

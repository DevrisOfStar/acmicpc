package Problem_1965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int num = 1;
		int[] a = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;st.hasMoreTokens(); i++)
			arr[i] = Integer.parseInt(st.nextToken());
		a[num] = arr[0];
		for(int i = 0; i<N; i++) {
			if(a[num] < arr[i]) a[++num] = arr[i];
			else {
				int s = 0, e = num;
				while(s < e) {
					int mid = (s+e)/2;					
					if(a[mid]+1 > arr[i]) e = mid;
					else s = mid+1;
				}
				a[e] = arr[i];
			}
		}
		
		System.out.println(num);
	}
	
}

package Problem_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class data implements Comparable<data>{
		int a,b;

		public data(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(data o) {
			if(this.b == o.b) 
				return this.b-this.a < o.b-o.a ? 1 : -1;
			
			else 
				return this.b > o.b ? 1 : -1;
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		data[] arr = new data[N];
		
		String bf;
		for(int i = 0; i < N; i++) {
			bf = br.readLine();
			arr[i] = new data(Integer.parseInt(bf.split(" ")[0]),Integer.parseInt(bf.split(" ")[1]));
		}
		
		Arrays.sort(arr);
		int n = 0;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(n <= arr[i].a) {
				n = arr[i].b;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}

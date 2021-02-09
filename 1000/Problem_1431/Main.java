package Problem_1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
//	A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
//	만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
//	만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
	
	static class data implements Comparable<data>{
		String str;
		public data(String str) {this.str = str;}

		@Override
		public int compareTo(data o) {
			if(this.str.length() == o.str.length()) {
				int a = 0, b = 0;
				for(int i = 0; i<this.str.length();i++) {
					char a_ = this.str.charAt(i);
					char b_ = o.str.charAt(i);	
					if(a_ >= '0' && a_ <= '9') a += a_ -'0';
					if(b_ >= '0' && b_ <= '9') b += b_ -'0';
				}				
				if(a==b) return this.str.compareTo(o.str);
				return a-b;
			}
			else 
				return this.str.length() - o.str.length();
		}

		@Override
		public String toString() {return str;}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		data[] arr = new data[N];
		
		for(int i = 0; i<N;i++) arr[i] = new data(br.readLine());
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <N; i++) sb.append(arr[i]).append("\n");
		System.out.println(sb.toString());
	}
}

package Problem_1501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	static class Data{
		int length;
		char first, end;
		int[] alpha;
		
		Data(String str) {
			alpha = new int[52];
			this.length = str.length(); 
			this.first = str.charAt(0);
			this.end = str.charAt(this.length-1);
			for(int i = 0; i <this.length; i++) {
				char c = str.charAt(i);
				if(c >= 'a' && c <= 'z') {
					this.alpha[c-'a']++;					
				}
				else {
					this.alpha[c-'A' + 26]++;
				}
			}
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(alpha);
			result = prime * result + end;
			result = prime * result + first;
			result = prime * result + length;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Data other = (Data) obj;
			if (!Arrays.equals(alpha, other.alpha))
				return false;
			if (end != other.end)
				return false;
			if (first != other.first)
				return false;
			if (length != other.length)
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		HashMap<Data, Long> dict = new HashMap<>();
		for(int i = 0; i<M; i++) {
			Data d = new Data(br.readLine());
			if(dict.containsKey(d)) {
				dict.put(d, dict.get(d) + 1);
			}
			else {
				dict.put(d, 1l);				
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			boolean flag = true;
			long a = 1l;
			for(String s : str.split(" ")) {
				Data d = new Data(s);
				if(dict.containsKey(d)) {
					a *= dict.get(d);
					flag = false;
				}
			}
			
			if(!flag) sb.append(a).append("\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb.toString());
	}
}

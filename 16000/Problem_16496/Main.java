package Problem_16496;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
	static class data implements Comparable<data>{
		String str;
		data(String str) {
			this.str = str;
		}
		@Override
		public int compareTo(data d) {
			// TODO Auto-generated method stub
			String com1 = this.str + d.str;
			String com2 = d.str + this.str;
			return com1.compareTo(com2)*(-1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		ArrayList<data> str = new ArrayList<data>();
		for(int i = 0; i< arr.length;i++)str.add(new data(arr[i]));
		Collections.sort(str);
		for(data d : str) {
			sb.append(d.str);
		}
		if(sb.toString().charAt(0) == '0') System.out.println('0');
		else System.out.println(sb.toString());
	}
}

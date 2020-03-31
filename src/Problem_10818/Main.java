package Problem_10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int tem;
		for(String s : br.readLine().split(" ")) {
			tem = Integer.parseInt(s);
			
			if(min > tem) min = tem;
			if(max < tem) max = tem;
		}
		
		System.out.println(min + " " + max);
	}
}

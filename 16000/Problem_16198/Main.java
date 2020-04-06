package Problem_16198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	static ArrayList<Integer> arr = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	
	public static void func(int number) {
		if(arr.size() == 2) {
			if(max < number) max = number;
			return;
		}
		else {
			int size = arr.size();
			for(int i = 1 ; i < size-1; i++) {	
				int temp = arr.get(i);
				int temp2 = arr.get(i-1) * arr.get(i+1);
				arr.remove(i);
				func(temp2+number);
				arr.add(i,temp);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}

		func(0);
		System.out.println(max);
	}
}

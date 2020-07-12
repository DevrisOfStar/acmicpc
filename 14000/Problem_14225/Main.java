package Problem_14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	static int N, S;
	static int[] arr;
	static boolean[] isSelected;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void ans(int idx) {
		if(idx == N) {
			int sum = 0;
			for(int i = 0; i <N; i++) {
				if(isSelected[i])
					sum+=arr[i];
			}
			list.add(sum);
		}
		else {
			isSelected[idx] =true;
			ans(idx+1);
			isSelected[idx] =false;
			ans(idx+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		
		N = Integer.parseInt(buffer);
		
		arr = new int[N];
		isSelected = new boolean[N];
		
		buffer = br.readLine();
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(buffer.split(" ")[i]);
		}
		ans(0);
		int i = 0;
		Object[] o = list.stream().distinct().sorted().toArray();
		for(Object element : o) {
			if((int)element!=i) break;
			i++;
			
		}
		System.out.println(i);
	}
}

package Problem_1132;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] data = new int[10];
	static boolean[] isUsed = new boolean[10];
	static boolean[] isFront = new boolean[10];
	static boolean[] isExist = new boolean[10];
	static String[] arr;
	static int N;
	static int end_point = 10;
	static long Max_ = Long.MIN_VALUE;
	static void answer(int idx) {
		if(idx == 10) {
			long dat_ = 0l; 
			for(int i = 0; i <N; i++) {
				long temp = 0l;
				for(int j = 0; j<arr[i].length(); j++) {
					temp *= 10l;
					temp += data[arr[i].charAt(j)-'A'];
				}
				dat_+= temp;
			}
			if(Max_ < dat_) {
				Max_ = dat_;
			}
		} else if(!isExist[idx]) {
			answer(idx+1); 
		} else if(!isFront[idx]){
				for(int i = 0; i <=9; i++) {
					if(!isUsed[i]) {
						data[idx] = i;
						isUsed[i] = true;
						answer(idx+1);
						data[idx] = 0;
						isUsed[i] = false;
					}
				}							
		} else {
			for(int i = 1; i <=9; i++) {
				if(!isUsed[i]) {
					data[idx] = i;
					isUsed[i] = true;
					answer(idx+1);
					data[idx] = 0;
					isUsed[i] = false;
				}
			}	
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new String[N];
		Arrays.fill(isFront, false);
		for(int i = 0; i <arr.length; i++) {
			arr[i] = br.readLine();
			isFront[arr[i].charAt(0) - 'A'] = true;
			for(int j = 0; j < arr[i].length(); j++) 
				isExist[arr[i].charAt(j) - 'A'] = true;
		}		
		answer(0);
		System.out.println(Max_);
	}
}

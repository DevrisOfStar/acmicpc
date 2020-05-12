package Problem_2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] used_num = new boolean[10];
	static String max, min;
	static long max_ = Long.MIN_VALUE, min_ = Long.MAX_VALUE;
	static String[] arr;
	static int K = 2;
	static void func(String num,int k) {
		if(k == K) {
			long l_num = Long.parseLong(num);
			if(l_num > max_) {
				max_ = l_num;
				max = num;
			}
			if(l_num < min_) {
				min_ = l_num;
				min = num;
			}
		}
		else if(k==-1) {
			for(int i = 0; i < 10; i++) {
				if(!used_num[i]) {
					used_num[i] = true;
					func(num + String.valueOf(i), k+1);
					used_num[i] = false;					
				}
			}
		}
		else {
			for(int i = 0; i < 10; i++) {
				if(!used_num[i]) {
					used_num[i] = true;
					int nu = num.charAt(num.length()-1) -'0';
					if(arr[k].equals("<") && nu < i) {
						func(num + String.valueOf(i), k+1);
						
					}
					else if(arr[k].equals(">") && nu > i){
						func(num + String.valueOf(i), k+1);						
					}
					used_num[i] = false;
					
				}
				
			}
			
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		arr = br.readLine().split(" ");
		
		func("", -1);
		System.out.println(max + "\n" + min);
	}
}

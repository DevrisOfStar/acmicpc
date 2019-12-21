package Problem_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,k, cnt,i;
		String str = br.readLine();
		n = Integer.parseInt(str.split(" ")[0]);
		k = Integer.parseInt(str.split(" ")[1]);
		cnt = 0;
		int[] arr = new int[n];
		
		for(i = 0 ; i < arr.length; i++)
			arr[i] = Integer.parseInt(br.readLine());
		i = arr.length-1;
		while(k>0) {
			if(k==0) break;
			cnt += k/arr[i];
			k%=arr[i];
			i--;
		}
		
		System.out.println(cnt);
	}
}

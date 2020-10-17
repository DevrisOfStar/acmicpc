package Problem_11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		int[] a = new int[Integer.parseInt(bf.split(" ")[0])];
		int[] b = new int[Integer.parseInt(bf.split(" ")[1])];

		answer = new int[a.length + b.length];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i< a.length; i++) a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< b.length; i++) b[i] = Integer.parseInt(st.nextToken());
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) answer[k++] = a[i++];
			else if(b[j] <= a[i]) answer[k++] = b[j++];
		}
		
		while(i < a.length) answer[k++] = a[i++];
		while(j < b.length) answer[k++] = b[j++];
		
		StringBuilder sb = new StringBuilder();
		for(i = 0; i <answer.length; i++) sb.append(answer[i]+ " ");
		System.out.println(sb.toString().trim());
				
	}
}

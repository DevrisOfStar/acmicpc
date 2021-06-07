package Problem_1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int Aidx, Bidx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int A = Integer.parseInt(str.split(" ")[0]);
		int B = Integer.parseInt(str.split(" ")[1]);
		
		int[] Aset = new int[A]; 
		int[] Bset = new int[B];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<A; i++) Aset[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<B; i++) Bset[i] = Integer.parseInt(st.nextToken());	
		Arrays.sort(Aset);
		Arrays.sort(Bset);
		
		int cnt = 0;
		
		while(Aidx < A && Bidx < B) {
			if(Aset[Aidx]==Bset[Bidx]) { cnt++; Aidx++; Bidx++; }
			else if(Aset[Aidx] < Bset[Bidx]) Aidx++;
			else Bidx++;
		}
		
		System.out.println(A+B-(cnt*2));
		
	}
}

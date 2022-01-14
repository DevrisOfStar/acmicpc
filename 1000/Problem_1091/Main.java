package Problem_1091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] P;
	static int[] S;
	static int[] card;
	static int[] temp;	
	static int N, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = new int[N];
		S = new int[N];
		card = new int[N];
		temp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) P[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) S[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) card[i] = i;
		while(true) {
			if(isValid()) break;
			shuffle();
			cnt++;
			if(cnt > 1e7) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(cnt);
	}
	
	public static void shuffle() {
		for(int i = 0; i<N;i++) {
			temp[S[i]] = card[i];
		}
		for(int i = 0; i<N; i++) card[i] = temp[i];
	}
	public static boolean isValid() {
		for(int i = 0; i<N; i++) {
			if(P[card[i]] != i%3) return false;
		}
		return true;
	}
}

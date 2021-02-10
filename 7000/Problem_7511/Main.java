package Problem_7511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] relation;
	
	public static int find(int Num) {
		if(relation[Num] == Num) return Num;
		return relation[Num] = find(relation[Num]);
	}
	
	public static void union(int n1, int n2) {
		int rootA = find(n1);
		int rootB = find(n2);
		
		if(rootA != rootB) {
			relation[rootA] = rootB;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String str;
		relation = new int[1000001];
		int N, K, a, b;
		StringTokenizer st;
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			for(int i = 1; i<=N;i++) relation[i] = i;
			K = Integer.parseInt(br.readLine());
			
			for(int i = 0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			sb.append("Scenario ").append(t).append(":\n");
			K = Integer.parseInt(br.readLine());
			for(int i = 0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(find(a) == find(b)) sb.append("1\n");
				else sb.append("0\n");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

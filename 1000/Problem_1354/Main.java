package Problem_1354;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static long P,Q,X,Y;
	static HashMap<Long, Long> map = new HashMap<Long,Long>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		P = sc.nextLong();
		Q = sc.nextLong();
		X = sc.nextLong();
		Y = sc.nextLong();
		System.out.println(answer(N));
		
	}
	static long answer(long N) {
		if(N <= 0) return 1;
		if(map.containsKey(N)) return map.get(N);
		long d = answer(N/P - X) + answer(N/Q-Y);
		map.put(N, d);
		return d;
	}
}

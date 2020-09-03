package Problem_14395;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Data {
	long number;
	String ans;
	public Data(long number, String ans) {
		this.number = number;
		this.ans = ans;
	}
	
}
public class Main {
	static String d[] = {"*","+","-","/"};
	public static long Calculate(long number, int i) {
		if(i == 0) return number * number;
		else if(i == 1) return number + number;
		else if(i == 2) return number - number;
		else return number / number;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long s = sc.nextLong();
		long t = sc.nextLong();
		// s == t인 경우, 예외처리
		if(s == t) {System.out.println("0"); return;}
		ArrayList<Long> arr = new ArrayList<>();
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(s, ""));
		arr.add(s);
		
		while(!q.isEmpty()) {
			Data data = q.poll();
			String st = data.ans;
			
			if(data.number == t) {
				// t와 일치할 경우 결과값 출력
				System.out.println(st);
				return;
			}
			for(int i = 0; i < 4; i++) {
				long dn = Calculate(data.number, i);
				if (dn < 1) continue;
				if(arr.contains(dn)) continue;
				arr.add(dn);
				// 해당 dn과 결과값을 저장
				q.add(new Data(dn, st+d[i]));
			}
		}
		
		// 결과값이 존재하지 않는 경우
		System.out.println(-1);
	}
}

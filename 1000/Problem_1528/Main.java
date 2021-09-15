package Problem_1528;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N;
	static class Pair {
		int num;
		String text;
		int cnt;
		
		Pair(int num_, String text_, int cnt_) {
			num = num_;
			text = text_;
			cnt = cnt_;
		}

		@Override
		public String toString() {
			return "Pair [num=" + num + ", text=" + text + ", cnt=" + cnt + "]";
		}
		
	}
	
	static Pair answer = new Pair(0, "",Integer.MAX_VALUE);
	static Set<Integer> number = new HashSet<>();
	static boolean[] visited = new boolean[1000000+1];
	public static void makeNumber(String num) {
		int numb = Integer.valueOf(num);
		if(numb > N) return;
		number.add(numb);
		makeNumber(num+"4");
		makeNumber(num+"7");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(N, "", 0));
		
		makeNumber("4");
		makeNumber("7");
		Object[] num_t = number.toArray();
		Arrays.sort(num_t);
		
		while(!q.isEmpty()) {
			Pair data = q.poll();
					
			if(data.num == 0) {
				if(answer.cnt > data.cnt) {
					answer = data;
				}
				else if(answer.cnt == data.cnt) {
					answer = answer.text.trim().compareTo(data.text.trim()) > 0 ? data : answer; 
				}
			} else {
				for(int i = 0; i<num_t.length; i++) {
					
					if(data.num - (int)num_t[i] < 0) break;
					if(visited[data.num-(int)num_t[i]]) continue;
					q.add(new Pair(data.num-(int)num_t[i],data.text+" "+ num_t[i], data.cnt+1));
					visited[data.num-(int)num_t[i]] = true;
				}
			}
		}
		if(answer.cnt == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else System.out.println(answer.text.trim());
	}
}

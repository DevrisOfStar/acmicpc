package Problem_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Long> pq2 = new PriorityQueue<>();
		
		for(long i = 0; i < N; i++) {
			long num =Long.parseLong(br.readLine());
			if(num >= 0) pq.add(num);
			else pq2.add(num);
		}
		

		long value = 0;
		long zeroCount = 0;
		
		while(pq.size() > 1 && pq.peek() >= 0) {
			long a = pq.poll();
			long b = pq.poll();
			
			if(a > 0 && b > 0 && a*b > a+b)  {value += a*b;}
			if(a > 0 && b > 0 && a*b <= a+b)  {value += (a+b);}
			else if(a > 0 && b == 0) {value += a; zeroCount+=1;}
			else if(a == 0 && b == 0) {zeroCount+=2;}
			else {
				if(a < 0) pq.add(a);
				if(b < 0) pq.add(b);
			}
		}
		
		if(!pq.isEmpty()) {
			if(pq.peek() == 0) zeroCount++;
			else value += pq.poll();
		}
		
		while(pq2.size() > 1) {
			long a = pq2.poll();
			long b = pq2.poll();
			value += (a*b);
		}
		
		if(!pq2.isEmpty()) {
			if(zeroCount > 0) pq2.poll();
			else value += pq2.poll();
		}
		
		System.out.println(value);
	}
}

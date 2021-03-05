package Problem_16953;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		ArrayList<Integer> isvisited = new ArrayList<>();
		isvisited.add(B);
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {B,1});
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			if(data[0] == A) {
				System.out.println(data[1]);
				return;
			}
			else if(data[0] < A) continue;
			
			else {
				if(data[0] % 2 == 0) {
					q.add(new int[] {data[0] / 2, data[1]+1});
				}
				if(data[0] % 10 == 1) {
					q.add(new int[] {data[0]/10, data[1]+1});				
				}
			}
		}
		System.out.println(-1);
		
	}
}

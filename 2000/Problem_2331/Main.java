package Problem_2331;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int P = sc.nextInt();	
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int num = 1;
		map.put(A, num);
		while(true) {
			int num_ = 0;
			int tmp = A;
			while(tmp > 0) {
				int t = tmp % 10;
				int b = 1;
				tmp /= 10;
				for(int i =0;i<P;i++) b*=t;
				num_+=b;
			}
			A = num_;
			
			if(map.containsKey(A)) {
				System.out.println(map.get(A)-1);
				return;
			} else {
				map.put(A, ++num);
			}
			
		}
		
	}
}

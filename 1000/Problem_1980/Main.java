package Problem_1980;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		
		int[] answer = new int[2];
		
		int a = n > m ? n : m;
		int b = n > m ? m : n;
		int burg_ = t/b;
		int coke_ = t%b;
		answer[0] = burg_; answer[1] = coke_;
		
		for(int burger_ = burg_ ; burger_ >= 0 ; burger_--) {
			int sumbur = burger_ + (t-burger_*b)/a;
			int sumcoke = (t-burger_*b)%a;
			if(answer[1] > sumcoke) {
				answer[0] = sumbur;
				answer[1] = sumcoke;
			}
			else if(answer[1] == sumcoke) {
				if(answer[0] < sumbur) {
					answer[0] = sumbur;
					answer[1] = sumcoke;
				}
			}
		}
		System.out.println(answer[0] + " " +answer[1]);
	}
}

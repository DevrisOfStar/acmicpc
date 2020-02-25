package Problem_12852;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N+1];
		Arrays.fill(arr, "");
		int cnt = 0;
		arr[1] = "1";
		for(int i = 2; i<=N;i++) {
			if(i % 3 == 0) {
				arr[i] = i + " " + arr[i/3];
			}
			if(i%2 == 0) {
				if(!arr[i].equals("")) {
					cnt = arr[i].split(" ").length-1;
					if(cnt > arr[i/2].split(" ").length) {
						arr[i] = i+ " " + arr[i/2];
					}	
				}
				else {
					arr[i] = i+ " " + arr[i/2];
				}
			}
			if(!arr[i].equals("")) {
				cnt = arr[i].split(" ").length-1;
				if(cnt > arr[i-1].split(" ").length) {
					arr[i] = i+ " " + arr[i-1];
				}	
			}
			else {
					arr[i] = i+ " " + arr[i-1];
			}
			
		}
		System.out.println(arr[N].split(" ").length-1 + "\n" + arr[N]);
		
		
	}
}

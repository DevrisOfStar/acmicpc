package Problem_12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] stack = new int[N];
		int top = -1;
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0;
		int target = 1;
		while(index < N) {
			if(arr[index] == target) {
				index++;
				target++;
			}
			else if(top != -1 && stack[top] == target) {
				top--;
				target++;
			}
			else if(arr[index] != target && top != N) {
				stack[++top] = arr[index++];
			}
			else {
				System.out.println("Sad1");
				return;
			}
		}
		
		while(top != -1) {
			if(stack[top] == target) {
				top--;
				target++;
			} else {
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
		
	}
}

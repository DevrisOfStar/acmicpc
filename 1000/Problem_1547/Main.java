package Problem_1547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] cups = new int[4];
		cups[1] = 1; cups[2] = 2; cups[3] = 3;
		for(int i = 0 ; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = 0;
			int d = 0;
			for(int j = 1; j<=3; j++)
			{
				if (cups[j] == a) c = j;
				if (cups[j] == b) d = j;
			}
			int temp = cups[c];
			cups[c] = cups[d];
			cups[d] = temp;
		}
		
		System.out.println(cups[1]);
	}
}
